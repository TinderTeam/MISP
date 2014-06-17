/**   
 * @Title: UserManageServiceImpl.java 
 * @Package cn.fuego.misp.service.impl.user 
 * @Description: TODO
 * @author Tang Jun   
 * @date 2014-4-20 下午10:32:34 
 * @version V1.0   
 */
package cn.fuego.misp.service.impl.user;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.fuego.misp.dao.DaoContext;
import cn.fuego.misp.dao.impl.SystemUserDaoImpl;
import cn.fuego.misp.domain.po.SystemUser;
import cn.fuego.misp.domain.po.UserExtAttr;
import cn.fuego.misp.service.UserManageService;
import cn.fuego.misp.service.cache.SystemMenuCache;
import cn.fuego.misp.service.cache.SystemMetaDataCache;
import cn.fuego.misp.service.cache.UserCache;
import cn.fuego.misp.service.datasource.AbstractDataSource;
import cn.fuego.misp.service.datasource.MemoryDataSourceImpl;
import cn.fuego.misp.service.exception.ServiceException;
import cn.fuego.misp.service.exception.msg.ExceptionMsg;
import cn.fuego.misp.service.login.exception.LoginServiceExceptionMsg;
import cn.fuego.misp.util.format.DataTypeConvert;
import cn.fuego.misp.util.validate.ValidatorUtil;
import cn.fuego.misp.web.model.common.AttributeModel;
import cn.fuego.misp.web.model.menu.MenuTreeModel;
import cn.fuego.misp.web.model.user.UserFilterModel;
import cn.fuego.misp.web.model.user.UserModel;

/**
 * @ClassName: UserManageServiceImpl
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-4-20 下午10:32:34
 * 
 */

public class UserManageServiceImpl implements UserManageService
{
	Log log = LogFactory.getLog(UserManageServiceImpl.class);

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.fuego.misp.service.UserManageService#getUserByID(java.lang.String)
	 */
	@Override
	public UserModel getUserByID(String userID)
	{
		UserModel user = UserCache.getInstance().getUserByUserID(userID);
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.fuego.misp.service.UserManageService#loadMenuTreeByUserID(java.lang.String)
	 */
	@Override
	public List<MenuTreeModel> loadMenuTreeByUserID(String userID)
	{
		// TODO Auto-generated method stub
		return SystemMenuCache.getInstance().getAllMenu();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.fuego.misp.service.UserManageService#getUserListDataSourceByFilter(cn.fuego.misp.web.model.user.UserFilterModel)
	 */
	@Override
	public AbstractDataSource<UserModel> getUserListDataSourceByFilter(UserFilterModel filterModel)
	{
		List<UserModel> userList = UserCache.getInstance().getUserListByFilter(filterModel);

		AbstractDataSource<UserModel> userDataSource = new MemoryDataSourceImpl<UserModel>(userList);
		return userDataSource;
	}

	public void delete(String userID)
	{
		if (ValidatorUtil.isEmpty(userID))
		{
			log.warn("the user id is empty");
			throw new ServiceException(ExceptionMsg.SELECT_ONE_USER);
		}
		try
		{
			DaoContext.getInstance().getSystemUserDao().delete(DataTypeConvert.strToList(userID));
			DaoContext.getInstance().getUserExtAttrDao().delete(DataTypeConvert.strToList(userID));
		}
		catch (RuntimeException e)
		{
			log.error("database error when delete user ");
			throw new ServiceException(ExceptionMsg.DATABASE_EEROR);
		}

		UserCache.getInstance().reload();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.fuego.misp.service.UserManageService#getUserExtAttrNameList()
	 */
	@Override
	public List<String> getUserExtAttrNameList()
	{
		List<String> extAttrNameList = SystemMetaDataCache.getInstance().getDisplayAttrNameList(SystemMetaDataCache.USER_TABLE);

		return extAttrNameList;
	}

	@Override
	public UserModel modifyPassword(UserModel user, String oldPassword, String confirmPassword, String newPassword)
	{
		if (!newPassword.equals(confirmPassword))
		{
			// two password not correct
			throw new ServiceException(ExceptionMsg.TWO_PASSWORD_WRONG);
		}
		else if (!user.getPassword().equals(oldPassword))
		{
			// old password is wrong
			throw new ServiceException(LoginServiceExceptionMsg.PASSWORD_WRONG);
		}
		else
		{
			// reSet the password

			// 1.database update

			SystemUser systemUser = new SystemUser();
			systemUser.setUserID(user.getUserID());
			systemUser.setPassword(newPassword);
			DaoContext.getInstance().getSystemUserDao().saveOrUpdate(systemUser);

			// 1.Model Set newPasword
			user.setPassword(newPassword);

			return user;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.fuego.misp.service.UserManageService#modify(cn.fuego.misp.web.model.user.UserModel)
	 */
	@Override
	public void modify(UserModel userModel)
	{

		//update sytem user basic information
//		SystemUser systemUser = new SystemUser();
//		
//		systemUser.setUserID(userModel.getUserID());
//		systemUser.setPassword(userModel.getPassword());
//
//		DaoContext.getInstance().getSystemUserDao().saveOrUpdate(systemUser);
		
		
		//update system user extend attribute information
		if(!ValidatorUtil.isEmpty(userModel.getAttrList()))
		{
			log.info("the user attribute is " + userModel.getAttrList());
			for(AttributeModel attr : userModel.getAttrList())
			{
				UserExtAttr extAttr = new UserExtAttr();
				extAttr.setUserID(userModel.getUserID());
				extAttr.setAttrName(attr.getAttrName());
				extAttr.setAttrValue(attr.getAttrValue());
				DaoContext.getInstance().getUserExtAttrDao().saveOrUpdate(extAttr);
			}
		}
		else
		{
			log.warn("there is no attribute of user. the user id is " + userModel.getUserID());
		}
		
		//reload the system user cache
		UserCache.getInstance().reload();
 
	}

}
