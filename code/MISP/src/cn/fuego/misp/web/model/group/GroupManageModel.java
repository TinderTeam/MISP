package cn.fuego.misp.web.model.group;

import java.util.List;


public class GroupManageModel
{
	private List<UserGroupModel> groupList;
	private UserGroupModel userGroup;

	
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
