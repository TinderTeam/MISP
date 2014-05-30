package stub.web.model.user;

import cn.fuego.misp.dao.impl.UserExtAttrDaoImpl;
import cn.fuego.misp.domain.po.UserExtAttr;
import cn.fuego.misp.web.model.user.UserModel;

public class UserModelStub
{
	public static UserModel getAdminUserModel()
	{

		return getUserModel("admin", "admin", "1234");

	}

	public static UserModel getUserModel(String id, String name, String password)
	{
		UserModel user = new UserModel();
		user.setUserID(id);
	 
		user.setPassword(password);
		return user;
	}
	public static void  setAttrModel(String id,String name, String value)
	{
		
		UserExtAttrDaoImpl attrimpl=new UserExtAttrDaoImpl();
		UserExtAttr extAttr = new UserExtAttr();
		extAttr.setUserID(id);
		extAttr.setAttrName(name);
		extAttr.setAttrValue(value);
		attrimpl.saveOrUpdate(extAttr);
		
			
	}
	
	

}
