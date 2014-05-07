/**   
* @Title: SystemUser.java 
* @Package cn.fuego.misp.domain.po 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-21 下午10:48:56 
* @version V1.0   
*/ 
package stub.domain.po;

import cn.fuego.misp.domain.po.SystemUser;

/**
 * 
* @ClassName: SystemUserStub 
* @Description: TODO
* @author Nan Bowen
* @date 2014-3-26 下午11:55:40 
*
 */
public class SystemUserStub {
	public static SystemUser getAdminUser(){
		
		return getUser("0001","admin","1234");
		
	}
	public static SystemUser getUser(String id,String name,String password){
		SystemUser user= new SystemUser();
		user.setUserID(id);
		user.setUserName(name);
		user.setPassword(password);
		return user;	
	}
}
