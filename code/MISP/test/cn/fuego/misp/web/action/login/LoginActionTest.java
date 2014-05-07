package cn.fuego.misp.web.action.login;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.StrutsTestCase;
import org.junit.Test;

import stub.web.model.user.UserModelStub;
import cn.fuego.misp.service.login.exception.LoginServiceExceptionMsg;
import cn.fuego.misp.web.constant.SessionAttrNameConst;
import cn.fuego.misp.web.model.user.UserModel;

import com.opensymphony.xwork2.ActionProxy;

public class LoginActionTest extends StrutsTestCase
{
	Log log = LogFactory.getLog(LoginActionTest.class);
	static ActionProxy proxy = null;
	static LoginAction test = null;

	public void init()
	{
		proxy = getActionProxy("/login.action");
		Map<String,Object> map = new HashMap<String, Object>();     
		proxy.getInvocation().getInvocationContext().setSession(map);
		test = (LoginAction) proxy.getAction();
	}

	@Test
	/*
	 * success login logic
	 */
	public void testSuccessLogin() throws Exception
	{
		init();		
		UserModel userModel=UserModelStub.getAdminUserModel();
		test.setUser(userModel);
		String result = proxy.execute();
		assertNotNull(test.getMenuTreeItem());
		assertFalse(test.getMenuTreeItem().isEmpty());
		assertEquals("success", result);
	
	}
	
	@Test
	/*
	 * wrong login logic
	 */
	public void testPasswordWrongLogin() throws Exception
	{
		init();		
		UserModel userModel=UserModelStub.getAdminUserModel();
		userModel.setPassword("wrongPassword");
		test.setUser(userModel);
		String result = proxy.execute();
		assertEquals("LoginFailed", result);
		assertEquals(test.getMessage(), LoginServiceExceptionMsg.PASSWORD_WRONG);
	}
	
	@Test
	/*
	 * no name login logic
	 */
	public void testNoUserLogin() throws Exception
	{
		init();		
		UserModel userModel=UserModelStub.getAdminUserModel();
		userModel.setUserID("NoThisUser");
		test.setUser(userModel);
		String result = proxy.execute();
		assertEquals("LoginFailed", result);
		assertEquals(test.getMessage(), LoginServiceExceptionMsg.USER_NOT_EXIST);
	}
}