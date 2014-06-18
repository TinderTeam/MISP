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
 * 
* @ClassName: Org 
* @Description: TODO
* @author Nan Bowen
* @date 2014-6-13 下午06:16:58 
*
 */

public class Org {
	private String orgID;
	private String orgName;
	private String orgDesp;
	private String parentID;
 
	public String getOrgID()
	{
		return orgID;
	}
	public void setOrgID(String orgID)
	{
		this.orgID = orgID;
	}
	/**
	 * @return the orgName
	 */
	public String getOrgName()
	{
		return orgName;
	}
	/**
	 * @param orgName the orgName to set
	 */
	public void setOrgName(String orgName)
	{
		this.orgName = orgName;
	}
	/**
	 * @return the orgDesp
	 */
	public String getOrgDesp()
	{
		return orgDesp;
	}
	/**
	 * @param orgDesp the orgDesp to set
	 */
	public void setOrgDesp(String orgDesp)
	{
		this.orgDesp = orgDesp;
	}
	public String getParentID()
	{
		return parentID;
	}
	public void setParentID(String parentID)
	{
		this.parentID = parentID;
	}
 
	

}
