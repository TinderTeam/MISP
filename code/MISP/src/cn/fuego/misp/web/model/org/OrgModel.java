package cn.fuego.misp.web.model.org;

import java.util.List;

public class OrgModel
{
	
	private String orgID;
	private String orgName;
	private String orgDescription;
	private String parentID;
	private List<OrgModel> subOrgList;
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
	 * @return the subOrgList
	 */
	public List<OrgModel> getSubOrgList()
	{
		return subOrgList;
	}
	/**
	 * @param subOrgList the subOrgList to set
	 */
	public void setSubOrgList(List<OrgModel> subOrgList)
	{
		this.subOrgList = subOrgList;
	}
	/**
	 * @return the orgDescription
	 */
	public String getOrgDescription()
	{
		return orgDescription;
	}
	/**
	 * @param orgDescription the orgDescription to set
	 */
	public void setOrgDescription(String orgDescription)
	{
		this.orgDescription = orgDescription;
	}
	public void setOrgID(String orgID)
	{
		this.orgID = orgID;
	}
	public String getOrgID()
	{
		return orgID;
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
