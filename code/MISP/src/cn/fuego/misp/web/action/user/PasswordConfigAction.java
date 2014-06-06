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
import cn.fuego.misp.service.login.exception.LoginServiceExceptionMsg;
import cn.fuego.misp.web.constant.SessionAttrNameConst;
import cn.fuego.misp.web.constant.UtilConstant;
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
	
	
	private UserManageService userService = ServiceContext.getInstance().getUserManagerService();
	 
	private String newPassword;
	private String oldPassword;
	private String confirmPassword;
	private String errorMsg= "密码修改完成";
	private static final String CONFIG_FAILED = "ConfigFailed";
	
	public String execute()
	{   
		
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		
		try{
			//log.info("old:"+oldPassword+";new:"+newPassword+";confirm:"+confirmPassword);
			UserModel user=userService.modifyPassword(
					(UserModel)actionContext.getSession().get(SessionAttrNameConst.LOGIN_USER),
					oldPassword,
					confirmPassword,
					newPassword
			);
			session.put(SessionAttrNameConst.LOGIN_USER, user);
		}catch(ServiceException ex){
			if(ex.getMessage().equals(LoginServiceExceptionMsg.PASSWORD_WRONG)||ex.getMessage().equals(ExceptionMsg.TWO_PASSWORD_WRONG)){
				errorMsg=ex.getMessage();
				return CONFIG_FAILED;	
			}
			else{
				return UtilConstant.SYSTEM_ERR;
			}	
		}
		
		
		session.put(SessionAttrNameConst.LOGIN_USER,null);
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


	/**
	 * @return the errorMsg
	 */
	public String getErrorMsg()
	{
		return errorMsg;
	}


	/**
	 * @param errorMsg the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg)
	{
		this.errorMsg = errorMsg;
	}

}
