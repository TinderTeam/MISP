package stub.web.model.group;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.engine.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;

import cn.fuego.misp.web.model.group.UserGroupModel;
import cn.fuego.misp.web.model.user.UserModel;

public class GroupModelStub 
{
	
	public static List<UserGroupModel> getGroupModelList()
	{
		List<UserGroupModel> drlist = new ArrayList<UserGroupModel>();
		List<UserModel> userIDList = new ArrayList<UserModel>();
		for(int i = 1;i<4;i++)
		{	
			UserModel user = new UserModel();
			user.setUserID("user"+i);
			userIDList.add(user);
		}
		drlist.add(getGroupModel("权限组1",userIDList));
		drlist.add(getGroupModel("权限组2",userIDList));
		drlist.add(getGroupModel("权限组3",userIDList));
		drlist.add(getGroupModel("权限组4",userIDList));
		
		return drlist;
		
	}
	
	public static UserGroupModel getGroupModel()
	{
		List<UserModel> userIDList = new ArrayList<UserModel>();
		for(int i = 1;i<4;i++)
		{	
			UserModel user = new UserModel();
			user.setUserID("user"+i);
			userIDList.add(user);
		}
 
		return getGroupModel("权限组1",userIDList);
		
	}
	
	public static UserGroupModel getGroupModel(String name, List<UserModel> userIDList)
	{

		UserGroupModel o = new UserGroupModel();
		o.setGroupName(name);
	    o.setUserList(userIDList);
		return o;
	}
	
	

}
