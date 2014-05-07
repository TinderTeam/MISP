/**   
* @Title: UserGroupModel.java 
* @Package cn.fuego.misp.web.model 
* @Description: TODO
* @author Tang Jun   
* @date 2014-3-16 下午11:04:24 
* @version V1.0   
*/ 
package cn.fuego.misp.web.model.user;

/** 
 * @ClassName: UserGroupModel 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-3-16 下午11:04:24 
 *  
 */

public class UserGroupModel
{
	private String groupID;
	private String groupName;
	private String groupDesp;
	public String getGroupID()
	{
		return groupID;
	}
	public void setGroupID(String groupID)
	{
		this.groupID = groupID;
	}
	public String getGroupName()
	{
		return groupName;
	}
	public void setGroupName(String groupName)
	{
		this.groupName = groupName;
	}
	public String getGroupDesp()
	{
		return groupDesp;
	}
	public void setGroupDesp(String groupDesp)
	{
		this.groupDesp = groupDesp;
	}
 

}
