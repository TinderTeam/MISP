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

public class UserManageModel
{
	private UserFilterModel filter;
	private UserModel user;
	
	private List<String> extAttrNameList;
	private PageModel<UserModel> userList = new PageModel<UserModel>();
	public UserFilterModel getFilter()
	{
		return filter;
	}
	public void setFilter(UserFilterModel filter)
	{
		this.filter = filter;
	}
	public List<String> getExtAttrNameList()
	{
		return extAttrNameList;
	}
	public void setExtAttrNameList(List<String> extAttrNameList)
	{
		this.extAttrNameList = extAttrNameList;
	}
	public UserModel getUser()
	{
		return user;
	}
	public void setUser(UserModel user)
	{
		this.user = user;
	}
	public PageModel<UserModel> getUserList()
	{
		return userList;
	}
	public void setUserList(PageModel<UserModel> userList)
	{
		this.userList = userList;
	}
	
}
