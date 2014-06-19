package cn.fuego.misp.service;

import cn.fuego.misp.service.impl.id.CommonIDImpl;
import cn.fuego.misp.service.impl.org.OrgManageServiceImpl;
import cn.fuego.misp.service.impl.user.UserGroupManageServiceImpl;
import cn.fuego.misp.service.impl.user.UserManageServiceImpl;
import cn.fuego.misp.service.login.LoginService;
import cn.fuego.misp.service.login.impl.LoginServiceImpl;

public class ServiceContext
{
	private static ServiceContext instance;
	private LoginService loginService=null;
	private UserManageService userManagerService = null;
	private IDCreateService idCreateService = null;
	private OrgManageService orgManageService = null;
	private UserGroupManageService userGroupManageService = null;

	
	
	  
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

	

	public OrgManageService getOrgManageService() {
		if (null == orgManageService)
		{
			orgManageService = new OrgManageServiceImpl();
		}
		return orgManageService;
	}
	
	public IDCreateService getIDCreateService() {
		if (null == idCreateService)
		{
			idCreateService = new CommonIDImpl();
		}
		return idCreateService;
	}
	
	public UserGroupManageService getUserGroupManageService() {
		if (null == userGroupManageService)
		{
			userGroupManageService = new UserGroupManageServiceImpl();
		}
		return userGroupManageService;
	}
}
