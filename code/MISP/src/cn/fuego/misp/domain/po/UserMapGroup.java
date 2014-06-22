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

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groupID == null) ? 0 : groupID.hashCode());
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserMapGroup other = (UserMapGroup) obj;
		if (groupID == null)
		{
			if (other.groupID != null)
				return false;
		}
		else if (!groupID.equals(other.groupID))
			return false;
		if (userID == null)
		{
			if (other.userID != null)
				return false;
		}
		else if (!userID.equals(other.userID))
			return false;
		return true;
	}

}
