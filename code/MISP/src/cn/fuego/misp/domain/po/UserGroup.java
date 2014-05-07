/**   
* @Title: UserGroup.java 
* @Package cn.fuego.misp.domain.po 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-22 下午8:38:03 
* @version V1.0   
*/ 
package cn.fuego.misp.domain.po;

/**   
 * @Title: UserGroup.java 
 * @Package cn.fuego.misp.domain.po 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-22 下午8:38:03 
 * @version V1.0   
 */

public class UserGroup {
	private int groupID;
	private String groupName;
	private String groupDesp;
	public int getGroupID() {
		return groupID;
	}
	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupDesp() {
		return groupDesp;
	}
	public void setGroupDesp(String groupDesp) {
		this.groupDesp = groupDesp;
	}
	@Override
	public String toString() {
		return "UserGroup [groupID=" + groupID + ", groupName=" + groupName
				+ ", groupDesp=" + groupDesp + "]";
	}


}
