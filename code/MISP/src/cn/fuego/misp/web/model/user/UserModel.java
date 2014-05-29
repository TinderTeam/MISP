/**   
* @Title: UserModel.java 
* @Package cn.fuego.misp.web.model 
* @Description: TODO
* @author Tang Jun   
* @date 2014-3-3 下午09:56:17 
* @version V1.0   
*/ 
package cn.fuego.misp.web.model.user;

import java.util.List;

import cn.fuego.misp.web.model.common.AttributeModel;

/** 
 * @ClassName: UserModel 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-3-3 下午09:56:17 
 *  
 */

public class UserModel
{
	private String userID;
	private String password;
	private List<AttributeModel> attrList;
	private List<UserGroupModel> userGroupList;

	public String getUserID()
	{
		return userID;
	}
 
	public void setUserID(String userID)
	{
		this.userID = userID;
	}
 
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public List<UserGroupModel> getUserGroupList()
	{
		return userGroupList;
	}
	public void setUserGroupList(List<UserGroupModel> userGroupList)
	{
		this.userGroupList = userGroupList;
	}

	public List<AttributeModel> getAttrList()
	{
		return attrList;
	}

	public void setAttrList(List<AttributeModel> attrList)
	{
		this.attrList = attrList;
	}
 
 
}
