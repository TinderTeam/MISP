package cn.fuego.misp.dao;

import cn.fuego.misp.dao.impl.OrgDaoImpl;
import cn.fuego.misp.dao.impl.SystemFunctionSetDaoImpl;
import cn.fuego.misp.dao.impl.SystemIDTypeDaoImpl;
import cn.fuego.misp.dao.impl.SystemMenuDaoImpl;
import cn.fuego.misp.dao.impl.SystemMetaDataDaoImpl;
import cn.fuego.misp.dao.impl.SystemUserDaoImpl;
import cn.fuego.misp.dao.impl.UserExtAttrDaoImpl;
import cn.fuego.misp.dao.impl.UserGroupDaoImpl;
import cn.fuego.misp.dao.impl.UserGroupMapFunctionDaoImpl;
import cn.fuego.misp.dao.impl.UserMapGroupDaoImpl;


/**
 * 
* @ClassName: DaoContext 
* @Description: TODO
* @author Nan Bowen
* @date 2014-3-23 下午11:27:41 
* 
 */
public class DaoContext
{
	private static DaoContext instance;
	private SystemUserDao systemUserDao=null;
	private UserExtAttrDao userExtAttrDao = null;
	private SystemMenuDao systemMenuDao = null;
	private SystemMetaDataDao systemMetaDataDao = null;
	private UserGroupMapFunctionDao userGroupMapFunctionDao = null;
	private SystemFunctionSetDao systemFunctionSetDao = null;
	private OrgDao orgDao = null;
	private SystemIDTypeDao systemIDTypeDao = null;
	private UserGroupDao userGroupDao = null;
	
	private UserMapGroupDao userMapGroupDao = null;


	

	private DaoContext()
	{

	}

	public static synchronized DaoContext getInstance()
	{
		if (null == instance)
		{
			instance = new DaoContext();
		}
		return instance;
	}

	public synchronized SystemUserDao getSystemUserDao() 
	{
		if (null == systemUserDao)
		{
			systemUserDao = new SystemUserDaoImpl();
		}
		return systemUserDao;
	}
	public synchronized UserExtAttrDao getUserExtAttrDao() 
	{
		if (null == userExtAttrDao)
		{
			userExtAttrDao = new UserExtAttrDaoImpl();
		}
		return userExtAttrDao;
	}
	public synchronized SystemMenuDao getSystemMenuDao() 
	{
		if (null == systemMenuDao)
		{
			systemMenuDao = new SystemMenuDaoImpl();
		}
		return systemMenuDao;
	}
	
	public synchronized SystemMetaDataDao getSystemMetaDataDao() 
	{
		if (null == systemMetaDataDao)
		{
			systemMetaDataDao = new SystemMetaDataDaoImpl();
		}
		return systemMetaDataDao;
	}
	
	public synchronized UserGroupMapFunctionDao getUserGroupMapFunctionDao() 
	{
		if (null == userGroupMapFunctionDao)
		{
			userGroupMapFunctionDao = new UserGroupMapFunctionDaoImpl();
		}
		return userGroupMapFunctionDao;
	}
	public synchronized SystemFunctionSetDao getSystemFunctionSetDao() 
	{
		if (null == systemFunctionSetDao)
		{
			systemFunctionSetDao = new SystemFunctionSetDaoImpl();
		}
		return systemFunctionSetDao;
	}
	public synchronized OrgDao getOrgDao() 
	{
		if (null == orgDao)
		{
			orgDao = new OrgDaoImpl();
		}
		return orgDao;
	}
	
	public synchronized SystemIDTypeDao getSystemIDTypeDao() 
	{
		if (null == systemIDTypeDao)
		{
			systemIDTypeDao = new SystemIDTypeDaoImpl();
		}
		return systemIDTypeDao;
	}
	
	public synchronized UserGroupDao getUserGroupDao() 
	{
		if (null == userGroupDao)
		{
			userGroupDao = new UserGroupDaoImpl();
		}
		return userGroupDao;
	}
	
	public synchronized UserMapGroupDao getUserMapGroupDao() 
	{
		if (null == userMapGroupDao)
		{
			userMapGroupDao = new UserMapGroupDaoImpl();
		}
		return userMapGroupDao;
	}
}
