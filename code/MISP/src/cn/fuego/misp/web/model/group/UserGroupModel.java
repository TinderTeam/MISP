package cn.fuego.misp.web.model.group;

import java.util.List;

import cn.fuego.misp.web.model.function.FunctionModel;
import cn.fuego.misp.web.model.user.UserModel;


public class UserGroupModel
{
	private String groupID;
	private String groupName;
	private String groupDesp;
	private List<FunctionModel> functionList;
	
	private List<String> tableExtAttrNameList;
	private List<UserModel> userList;
	
	
 
	public List<String> getTableExtAttrNameList()
	{
		return tableExtAttrNameList;
	}
	public void setTableExtAttrNameList(List<String> tableExtAttrNameList)
	{
		this.tableExtAttrNameList = tableExtAttrNameList;
	}
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
 
	public List<FunctionModel> getFunctionList()
	{
		return functionList;
	}
	public void setFunctionList(List<FunctionModel> functionList)
	{
		this.functionList = functionList;
	}
	public List<UserModel> getUserList()
	{
		return userList;
	}
	public void setUserList(List<UserModel> userList)
	{
		this.userList = userList;
	}
	 

}
