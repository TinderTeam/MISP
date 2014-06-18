package cn.fuego.misp.service.login.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.fuego.misp.service.cache.UserCache;
import cn.fuego.misp.service.exception.ServiceException;
import cn.fuego.misp.service.exception.msg.ExceptionMsg;
import cn.fuego.misp.service.login.LoginService;
import cn.fuego.misp.web.model.user.UserModel;

/**
 * 
 * @ClassName: LoginServiceImpl
 * @Description: TODO
 * @author Nan Bowen
 * @date 2014-3-23 下午10:39:25
 * 
 */
public class LoginServiceImpl implements LoginService
{
	Log log = LogFactory.getLog(LoginServiceImpl.class);

	@Override
	public void userLogin(UserModel user)
	{
		// get targetUser
		UserModel targetUser = UserCache.getInstance().getUserByUserID(user.getUserID());

		if (null == targetUser || null == user)
		{
			// User isnot existant
			log.warn("User not exist：" + user);
			throw new ServiceException(ExceptionMsg.USER_NOT_EXIST);
		}
		else if (!targetUser.getPassword().equals(user.getPassword()))
		{
			log.warn("the password is wrong");
			throw new ServiceException(ExceptionMsg.PASSWORD_WRONG);
		}
		else
		{
			log.info("User Login : " + user.toString());
		}
	}

}
