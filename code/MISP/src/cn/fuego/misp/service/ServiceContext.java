package cn.fuego.misp.service;

import java.util.HashMap;
import java.util.Map;

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
	private OrgManageService orgManageService = null;
	private UserGroupManageService userGroupManageService = null;
	
	private Map<String,IDCreateService> idCreateServiceMap = new HashMap<String,IDCreateService>();


	
	
	  
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
	public synchronized  LoginService getLoginService() {
		if (null == loginService)
		{
			loginService = new LoginServiceImpl();
		}
		return loginService;
	}

	public  synchronized UserManageService getUserManagerService() {
		if (null == userManagerService)
		{
			userManagerService = new UserManageServiceImpl();
		}
		return userManagerService;
	}

	

	public  synchronized OrgManageService getOrgManageService() {
		if (null == orgManageService)
		{
			orgManageService = new OrgManageServiceImpl();
		}
		return orgManageService;
	}
	
	public synchronized IDCreateService getIDCreateService(String IDName) {
		
		if(null == idCreateServiceMap.get(IDName))
		{
			idCreateServiceMap.put(IDName, new CommonIDImpl(IDName));
		}
		
		return idCreateServiceMap.get(IDName);
	}
	
	public synchronized UserGroupManageService getUserGroupManageService() {
		if (null == userGroupManageService)
		{
			userGroupManageService = new UserGroupManageServiceImpl();
		}
		return userGroupManageService;
	}
}
