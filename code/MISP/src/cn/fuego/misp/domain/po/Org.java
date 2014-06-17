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
	private int orgID;
	private String orgName;
	private String orgDesp;
	private String fatherID;
	/**
	 * @return the orgID
	 */
	public int getOrgID()
	{
		return orgID;
	}
	/**
	 * @param orgID the orgID to set
	 */
	public void setOrgID(int orgID)
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
	/**
	 * @return the fatherID
	 */
	public String getFatherID()
	{
		return fatherID;
	}
	/**
	 * @param fatherID the fatherID to set
	 */
	public void setFatherID(String fatherID)
	{
		this.fatherID = fatherID;
	}
	
	

}
