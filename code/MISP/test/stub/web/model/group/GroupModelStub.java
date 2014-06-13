package stub.web.model.group;

import java.util.ArrayList;
import java.util.List;

import cn.fuego.misp.web.model.group.GroupModel;

public class GroupModelStub 
{
	
	public static List<GroupModel> getGroupModelList()
	{
		List<GroupModel> drlist = new ArrayList<GroupModel>();
		List<String> userIDList = new ArrayList<String>();
		userIDList.add("用户1");
		userIDList.add("用户2");
		userIDList.add("用户3");
		drlist.add(getGroupModel("权限组1",userIDList));
		drlist.add(getGroupModel("权限组2",userIDList));
		drlist.add(getGroupModel("权限组3",userIDList));
		drlist.add(getGroupModel("权限组4",userIDList));
		
		return drlist;
		
	}
	
	public static GroupModel getGroupModel()
	{
		List<String> userIDList = new ArrayList<String>();
		userIDList.add("用户1");
		userIDList.add("用户2");
		userIDList.add("用户3");
		
		return getGroupModel("权限组1",userIDList);
		
	}
	
	public static GroupModel getGroupModel(String name, List<String> userIDList)
	{

		GroupModel o = new GroupModel();
		o.setGroupName(name);
	    o.setUserIDList(userIDList);
		return o;
	}
	
	

}
