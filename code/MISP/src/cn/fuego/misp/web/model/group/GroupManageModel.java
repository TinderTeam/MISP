package cn.fuego.misp.web.model.group;

import java.util.List;

import cn.fuego.misp.web.model.org.OrgModel;


public class GroupManageModel
{
	private List<GroupModel> groupList;

	public List<GroupModel> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<GroupModel> groupList) {
		this.groupList = groupList;
	}
}
