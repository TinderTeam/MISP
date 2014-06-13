package cn.fuego.misp.web.model.group;

import java.util.List;

import cn.fuego.misp.web.model.user.UserModel;


public class GroupModel
{
	private String groupName;
    private List<String> userIDList;
    
	public List<String> getUserIDList() {
		return userIDList;
	}

	public void setUserIDList(List<String> userIDList) {
		this.userIDList = userIDList;
	}


	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
