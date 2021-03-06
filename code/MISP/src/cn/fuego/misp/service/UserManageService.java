/**   
* @Title: UserMangeService.java 
* @Package cn.fuego.misp.service 
* @Description: TODO
* @author Tang Jun   
* @date 2014-2-28 下午11:13:18 
* @version V1.0   
*/ 
package cn.fuego.misp.service;

import java.util.List;

import cn.fuego.misp.web.model.menu.MenuTreeModel;
import cn.fuego.misp.web.model.user.UserModel;

/** 
 * @ClassName: UserMangeService 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-2-28 下午11:13:18 
 *  
 */

public interface UserManageService
{
	UserModel getUserByID(String userID);
	
	/**
	 * get the menu tree by user id.
	 * @param userID
	 * @return
	 */
	public List<MenuTreeModel> loadMenuTreeByUserID(String userID);

}
