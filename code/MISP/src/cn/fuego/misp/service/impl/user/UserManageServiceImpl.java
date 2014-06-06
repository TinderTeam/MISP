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
import java.util.Map;

import cn.fuego.misp.dao.DaoContext;
import cn.fuego.misp.dao.SystemUserDao;
import cn.fuego.misp.domain.po.SystemMetaData;
import cn.fuego.misp.domain.po.SystemUser;
import cn.fuego.misp.service.UserManageService;
import cn.fuego.misp.service.cache.SystemMenuCache;
import cn.fuego.misp.service.cache.SystemMetaDataCache;
import cn.fuego.misp.service.cache.UserCache;
import cn.fuego.misp.service.datasource.AbstractDataSource;
import cn.fuego.misp.service.datasource.MemoryDataSourceImpl;
import cn.fuego.misp.service.exception.ServiceException;
import cn.fuego.misp.service.exception.msg.ExceptionMsg;
import cn.fuego.misp.service.login.exception.LoginServiceExceptionMsg;
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

	/* (non-Javadoc)
	 * @see cn.fuego.misp.service.UserManageService#getUserByID(java.lang.String)
	 */
	@Override
	public UserModel getUserByID(String userID)
	{
		UserModel user = UserCache.getInstance().getUserByUserID(userID);
		return user;
	}

	/* (non-Javadoc) 
	 * @see cn.fuego.misp.service.UserManageService#loadMenuTreeByUserID(java.lang.String)
	 */
	@Override
	public List<MenuTreeModel> loadMenuTreeByUserID(String userID)
	{
		// TODO Auto-generated method stub
		return  SystemMenuCache.getInstance().getAllMenu();
	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.service.UserManageService#getUserListDataSourceByFilter(cn.fuego.misp.web.model.user.UserFilterModel)
	 */
	@Override
	public AbstractDataSource<UserModel> getUserListDataSourceByFilter(UserFilterModel filterModel)
	{
		List<UserModel> userList = UserCache.getInstance().getUserListByFilter(filterModel);
		
		AbstractDataSource<UserModel> userDataSource = new MemoryDataSourceImpl<UserModel>(userList);
		return userDataSource;
	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.service.UserManageService#getUserExtAttrNameList()
	 */
	@Override
	public List<String> getUserExtAttrNameList()
	{
		List<String> extAttrNameList = SystemMetaDataCache.getInstance().getDisplayAttrNameList(SystemMetaDataCache.USER_TABLE);
	
		return extAttrNameList;
	}

	@Override
	public UserModel modifyPassword(UserModel user, String oldPassword,
			String confirmPassword, String newPassword)
	{
		if(!newPassword.equals(confirmPassword))
		{
			//two password not correct
			throw new ServiceException(ExceptionMsg.TWO_PASSWORD_WRONG);
		}else if(!user.getPassword().equals(oldPassword))
		{
			//old password is wrong 
			throw new ServiceException(LoginServiceExceptionMsg.PASSWORD_WRONG);
		}else{
			//reSet the password 
			
			
			//1.database update
			
			SystemUserDao systemUserDao = DaoContext.getInstance().getSystemUserDao(); 
			SystemUser userPo =systemUserDao.getByID(user.getUserID());
			userPo.setPassword(newPassword);
			systemUserDao.saveOrUpdate(userPo);
			
			
			//1.Model Set newPasword
			user.setPassword(newPassword);
	
			
			return user;
		}
		
	}

}
