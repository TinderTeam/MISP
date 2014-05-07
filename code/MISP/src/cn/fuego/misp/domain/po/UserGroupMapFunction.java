/**   
* @Title: UserGroupMapFunction.java 
* @Package cn.fuego.misp.domain.po 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-23 上午12:17:44 
* @version V1.0   
*/ 
package cn.fuego.misp.domain.po;

import java.io.Serializable;

/**   
 * @Title: UserGroupMapFunction.java 
 * @Package cn.fuego.misp.domain.po 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-23 上午12:17:44 
 * @version V1.0   
 */

public class UserGroupMapFunction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int groupID;
	private int functionID;
	public int getGroupID() {
		return groupID;
	}
	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}
	public int getFunctionID() {
		return functionID;
	}
	public void setFunctionID(int functionID) {
		this.functionID = functionID;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "UserGroupMapFunction [groupID=" + groupID + ", functionID="
				+ functionID + "]";
	}



}
