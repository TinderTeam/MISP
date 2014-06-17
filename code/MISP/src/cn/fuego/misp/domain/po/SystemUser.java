/**   
* @Title: SystemUser.java 
* @Package cn.fuego.misp.domain.po 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-21 下午10:48:56 
* @version V1.0   
*/ 
package cn.fuego.misp.domain.po;

/**   
 * @Title: SystemUser.java 
 * @Package cn.fuego.misp.domain.po 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-21 下午10:48:56 
 * @version V1.0   
 */

public class SystemUser {

	private String userID;
	private String password;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
 
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "SystemUser [userID=" + userID + ", password=" + password + "]";
	}
	

}
