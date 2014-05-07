package cn.fuego.misp.service;

import cn.fuego.misp.service.login.LoginService;
import cn.fuego.misp.service.login.impl.LoginServiceImpl;
import cn.fuego.misp.service.user.UserManageServiceImpl;

public class ServiceContext
{
	private static ServiceContext instance;
	private LoginService loginService=null;
	private UserManageService userManagerService = null;
	
	  
	private ServiceContext()
	{
		
	}
	public static synchronized ServiceContext getInstance()
	{
		if (null == instance)
		{
			instance = new ServiceContext();
		}
		return instance;
	}
	public LoginService getLoginService() {
		if (null == loginService)
		{
			loginService = new LoginServiceImpl();
		}
		return loginService;
	}

	public UserManageService getUserManagerService() {
		if (null == userManagerService)
		{
			userManagerService = new UserManageServiceImpl();
		}
		return userManagerService;
	}

	

}
