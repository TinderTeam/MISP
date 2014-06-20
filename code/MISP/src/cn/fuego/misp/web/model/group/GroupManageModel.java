package cn.fuego.misp.web.model.group;

import java.util.List;

import cn.fuego.misp.web.model.function.FunctionModel;
import cn.fuego.misp.web.model.user.UserModel;


public class GroupManageModel
{
	private List<UserGroupModel> groupList;
	private UserGroupModel userGroup;
	
	
	private List<String> tableExtAttrNameList;
	private List<UserModel> userList;

	private List<FunctionModel> allFunctionList;

	
	public List<String> getTableExtAttrNameList()
	{
		return tableExtAttrNameList;
	}

	public void setTableExtAttrNameList(List<String> tableExtAttrNameList)
	{
		this.tableExtAttrNameList = tableExtAttrNameList;
	}

	public List<UserModel> getUserList()
	{
		return userList;
	}

	public void setUserList(List<UserModel> userList)
	{
		this.userList = userList;
	}

	public List<FunctionModel> getAllFunctionList()
	{
		return allFunctionList;
	}

	public void setAllFunctionList(List<FunctionModel> allFunctionList)
	{
		this.allFunctionList = allFunctionList;
	}

	public UserGroupModel getUserGroup()
	{
		return userGroup;
	}

	public void setUserGroup(UserGroupModel userGroup)
	{
		this.userGroup = userGroup;
	}

	public List<UserGroupModel> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<UserGroupModel> groupList) {
		this.groupList = groupList;
	}
}
