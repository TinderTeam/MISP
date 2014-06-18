/**   
 * @Title: UserMapGroup.java 
 * @Package cn.fuego.misp.domain.po 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-22 下午10:51:06 
 * @version V1.0   
 */
package cn.fuego.misp.domain.po;

import java.io.Serializable;

/**
 * @Title: UserMapGroup.java
 * @Package cn.fuego.misp.domain.po
 * @Description: TODO
 * @author Zhu Liucao
 * @date 2014-3-22 下午10:51:06
 * @version V1.0
 */

public class UserMapGroup implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userID;
	private String groupID;

	public String getUserID()
	{
		return userID;
	}

	public void setUserID(String userID)
	{
		this.userID = userID;
	}

	public String getGroupID()
	{
		return groupID;
	}

	public void setGroupID(String groupID)
	{
		this.groupID = groupID;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

	@Override
	public String toString()
	{
		return "UserMapGroup [userID=" + userID + ", groupID=" + groupID + "]";
	}

}
