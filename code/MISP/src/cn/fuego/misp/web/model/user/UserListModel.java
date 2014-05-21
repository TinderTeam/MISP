/**   
* @Title: UserListModel.java 
* @Package cn.fuego.misp.web.model 
* @Description: TODO
* @author Tang Jun   
* @date 2014-3-16 下午10:56:39 
* @version V1.0   
*/ 
package cn.fuego.misp.web.model.user;

import java.util.List;

import cn.fuego.misp.web.model.page.PageModel;

/** 
 * @ClassName: UserListModel 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-3-16 下午10:56:39 
 *  
 */

public class UserListModel
{
	private UserFilterModel filter;
	private List<String> extAttrNameList;
	private UserModel user;
	private PageModel<UserModel> userList;
}
