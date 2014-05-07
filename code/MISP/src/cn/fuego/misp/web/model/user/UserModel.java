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

import cn.fuego.misp.web.model.common.AttributeListModel;

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
	private String userName;
	private String password;
	private List<UserGroupModel> userGroupList;
	private AttributeListModel attrValueList;
	public String getUserID()
	{
		return userID;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "UserModel [userID=" + userID + ", userName=" + userName
				+ ", password=" + password + ", userGroupList=" + userGroupList
				+ ", attrValueList=" + attrValueList + "]";
	}
	public void setUserID(String userID)
	{
		this.userID = userID;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
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
	public AttributeListModel getAttrValueList()
	{
		return attrValueList;
	}
	public void setAttrValueList(AttributeListModel attrValueList)
	{
		this.attrValueList = attrValueList;
	}
 
 
	

}
