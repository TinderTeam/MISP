package stub.web.model.group;

import java.util.ArrayList;
import java.util.List;

import cn.fuego.misp.web.model.group.GroupModel;

public class GroupModelStub 
{
	public static GroupModel getGroupModel(String name)
	{

		GroupModel o = new GroupModel();
		o.setGroupName(name);
	
		return o;
	}
	
	public static List<GroupModel> getGroupModelList()
	{
		List<GroupModel> drlist = new ArrayList<GroupModel>();
		drlist.add(getGroupModel("权限组1"));
		drlist.add(getGroupModel("权限组2"));
		drlist.add(getGroupModel("权限组3"));
		drlist.add(getGroupModel("权限组4"));
		
		return drlist;
		
	}

}
