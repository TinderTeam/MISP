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
 


}
