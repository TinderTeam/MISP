/**   
* @Title: UserExtAttr.java 
* @Package cn.fuego.misp.domain.po 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-21 下午11:24:12 
* @version V1.0   
*/ 
package cn.fuego.misp.domain.po;

import java.io.Serializable;

/**   
 * @Title: UserExtAttr.java 
 * @Package cn.fuego.misp.domain.po 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-21 下午11:24:12 
 * @version V1.0   
 */

public class UserExtAttr implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userID;
	private String attrName;
	private String attrValue;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getAttrName() {
		return attrName;
	}
	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}
	public String getAttrValue() {
		return attrValue;
	}
	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}
	@Override
	public String toString() {
		return "UserExtAttr [userID=" + userID + ", attrName=" + attrName
				+ ", attrValue=" + attrValue + "]";
	}
	
}
