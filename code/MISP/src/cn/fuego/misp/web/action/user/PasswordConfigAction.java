/**   
* @Title: QueryUserAction.java 
* @Package cn.fuego.misp.web.action.user 
* @Description: TODO
* @author Tang Jun   
* @date 2014-3-16 下午10:42:47 
* @version V1.0   
*/ 
package cn.fuego.misp.web.action.user;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.fuego.misp.service.ServiceContext;
import cn.fuego.misp.service.UserManageService;
import cn.fuego.misp.service.exception.ServiceException;
import cn.fuego.misp.service.exception.msg.ExceptionMsg;
import cn.fuego.misp.web.constant.SessionAttrNameConst;
import cn.fuego.misp.web.model.user.UserModel;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/** 
 * @ClassName: QueryUserAction 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-3-16 下午10:42:47 
 *  
 */

public class PasswordConfigAction extends ActionSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2858809485016016887L;
	
	private Log log = LogFactory.getLog(PasswordConfigAction.class);
	private String PAGE= "PAGE";
	
	private UserManageService userService = ServiceContext.getInstance().getUserManagerService();
	 
	private String newPassword;
	private String oldPassword;
	private String confirmPassword;
	
	public String execute()
	{   
		return PAGE;
	}
	
	public String submit() throws Exception
	{
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		
		
		userService.modifyPassword(
				(UserModel)actionContext.getSession().get(SessionAttrNameConst.LOGIN_USER),
				oldPassword,
				confirmPassword,
				newPassword
		);
		
		session.put(SessionAttrNameConst.LOGIN_USER, user);
		return SUCCESS;
	}
	

	/**
	 * @return the newPassword
	 */
	public String getNewPassword()
	{
		return newPassword;
	}

	/**
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(String newPassword)
	{
		this.newPassword = newPassword;
	}

	/**
	 * @return the oldPassword
	 */
	public String getOldPassword()
	{
		return oldPassword;
	}

	/**
	 * @param oldPassword the oldPassword to set
	 */
	public void setOldPassword(String oldPassword)
	{
		this.oldPassword = oldPassword;
	}

	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword()
	{
		return confirmPassword;
	}

	/**
	 * @param confirmPassword the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword)
	{
		this.confirmPassword = confirmPassword;
	}

}
