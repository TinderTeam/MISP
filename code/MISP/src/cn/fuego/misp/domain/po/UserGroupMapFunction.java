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
	
	private String groupID;
	private String functionID;
	public String getGroupID()
	{
		return groupID;
	}
	public void setGroupID(String groupID)
	{
		this.groupID = groupID;
	}
	public String getFunctionID()
	{
		return functionID;
	}
	public void setFunctionID(String functionID)
	{
		this.functionID = functionID;
	}
	@Override
	public String toString()
	{
		return "UserGroupMapFunction [groupID=" + groupID + ", functionID=" + functionID + "]";
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((functionID == null) ? 0 : functionID.hashCode());
		result = prime * result + ((groupID == null) ? 0 : groupID.hashCode());
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
		UserGroupMapFunction other = (UserGroupMapFunction) obj;
		if (functionID == null)
		{
			if (other.functionID != null)
				return false;
		}
		else if (!functionID.equals(other.functionID))
			return false;
		if (groupID == null)
		{
			if (other.groupID != null)
				return false;
		}
		else if (!groupID.equals(other.groupID))
			return false;
		return true;
	}
 


}
