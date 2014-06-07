package cn.fuego.misp.web.model.org;

import java.util.List;

public class OrgModel
{
	private String orgName;
	private Boolean subOrgExist;
	private List<OrgModel> subOrgList;
	private String orgDescription;
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
	public void setSubOrgExist(Boolean subOrgExist)
	{
		this.subOrgExist = subOrgExist;
	}
	public Boolean getSubOrgExist()
	{
		return subOrgExist;
	}
	
	
}
