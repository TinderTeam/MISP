/**   
* @Title: UserManageServiceImpl.java 
* @Package cn.fuego.misp.service.user 
* @Description: TODO
* @author Tang Jun   
* @date 2014-3-25 下午11:10:13 
* @version V1.0   
*/ 
package cn.fuego.misp.service.user;

import java.util.List;

import cn.fuego.misp.domain.po.SystemMenu;
import cn.fuego.misp.domain.po.SystemUser;
import cn.fuego.misp.service.UserManageService;
import cn.fuego.misp.service.cache.SystemMenuCache;
import cn.fuego.misp.service.exception.ServiceException;
import cn.fuego.misp.service.exception.msg.ExceptionMsg;
import cn.fuego.misp.web.model.menu.MenuTreeModel;
import cn.fuego.misp.web.model.user.UserModel;

/** 
 * @ClassName: UserManageServiceImpl 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-3-25 下午11:10:13 
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
		// TODO Auto-generated method stub
		return null;
	}
	
  
	@Override
	public List<MenuTreeModel> loadMenuTreeByUserID(String userID)
	{
 
		return SystemMenuCache.getInstance().getAllMenu();
 
 	}


}
