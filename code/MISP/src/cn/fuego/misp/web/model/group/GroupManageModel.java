package cn.fuego.misp.web.model.group;

import java.util.List;

import cn.fuego.misp.web.model.org.OrgModel;


public class GroupManageModel
{
	private List<UserGroupModel> groupList;

	public List<UserGroupModel> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<UserGroupModel> groupList) {
		this.groupList = groupList;
	}
}
