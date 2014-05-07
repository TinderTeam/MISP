/**   
 * @Title: LoginAction.java 
 * @Package cn.fuego.misp.web.action.login 
 * @Description: TODO
 * @author Tang Jun   
 * @date 2014-2-28 上午01:05:19 
 * @version V1.0   
 */
package cn.fuego.misp.web.action.login;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.fuego.misp.service.ServiceContext;
import cn.fuego.misp.service.login.exception.LoginServiceException;
import cn.fuego.misp.service.login.exception.LoginServiceExceptionMsg;
import cn.fuego.misp.service.login.impl.LoginServiceImpl;
import cn.fuego.misp.web.constant.SessionAttrNameConst;
import cn.fuego.misp.web.model.menu.MenuTreeModel;
import cn.fuego.misp.web.model.user.UserModel;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @ClassName: LoginAction
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-2-28 上午01:05:19
 * @Edit Nan Bowen at 2014-03-23
 */

public class LoginAction extends ActionSupport
{
	Log log = LogFactory.getLog(LoginAction.class);
	private static final String LOGIN_FAILED = "LoginFailed";
	private List<MenuTreeModel> menuTreeItem;
	private UserModel user;
	private String message; 
	
	
	public String execute()
	{
		 ActionContext actionContext = ActionContext.getContext();
	     Map session = actionContext.getSession();
	       
	     try
	     {
	    	 //User Login
	    	 ServiceContext.getInstance().getLoginService().userLogin(user);
	    	 //Loading MenuTree
	    	 menuTreeItem= ServiceContext.getInstance().getUserManagerService().loadMenuTreeByUserID(user.getUserID());	    	 
	     }catch(LoginServiceException ex)
	     {
	    	 message=ex.getMessage();
	    	 log.warn(ex.getMessage(),ex);
	    	 return this.LOGIN_FAILED;
	     }
	   
		//if login success, we should put the user into session
		session.put(SessionAttrNameConst.LOGIN_USER, user);
		return SUCCESS;
	}

	public UserModel getUser()
	{
		return user;
	}

	public String getMessage()
	{
		return message;
	}

	public void setUser(UserModel user)
	{
		this.user = user;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public void setMenuTreeItem(List<MenuTreeModel> menuTreeItem)
	{
		this.menuTreeItem = menuTreeItem;
	}

	public List<MenuTreeModel> getMenuTreeItem()
	{
		return menuTreeItem;
	}
	

 

}
