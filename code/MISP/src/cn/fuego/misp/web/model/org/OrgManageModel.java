package cn.fuego.misp.web.model.org;

import java.util.List;

import cn.fuego.misp.web.model.user.UserModel;

public class OrgManageModel
{
	private String orgBeloneInfo;	
	private String staticInfo;
	private List<UserModel> noOrgUserList;
	private List<OrgModel> orgList;
	
	/**
	 * @return the orgBeloneInfo
	 */
	public String getOrgBeloneInfo()
	{
		return orgBeloneInfo;
	}
	/**
	 * @param orgBeloneInfo the orgBeloneInfo to set
	 */
	public void setOrgBeloneInfo(String orgBeloneInfo)
	{
		this.orgBeloneInfo = orgBeloneInfo;
	}
	/**
	 * @return the staticInfo
	 */
	public String getStaticInfo()
	{
		return staticInfo;
	}
	/**
	 * @param staticInfo the staticInfo to set
	 */
	public void setStaticInfo(String staticInfo)
	{
		this.staticInfo = staticInfo;
	}

	public void setOrgList(List<OrgModel> orgList)
	{
		this.orgList = orgList;
	}
	public List<OrgModel> getOrgList()
	{
		return orgList;
	}
	public void setNoOrgUserList(List<UserModel> noOrgUserList)
	{
		this.noOrgUserList = noOrgUserList;
	}
	public List<UserModel> getNoOrgUserList()
	{
		return noOrgUserList;
	}
}
