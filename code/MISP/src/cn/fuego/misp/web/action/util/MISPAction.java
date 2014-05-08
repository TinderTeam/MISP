package cn.fuego.misp.web.action.util;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class MISPAction extends ActionSupport
{
	private  String page_pageName=null;
	private List<BreadTrail> page_breadList =null;
	/**
	 * @return the page_pageName
	 */
	public String getPage_pageName()
	{
		return page_pageName;
	}
	/**
	 * @param page_pageName the page_pageName to set
	 */
	public void setPage_pageName(String page_pageName)
	{
		this.page_pageName = page_pageName;
	}
	/**
	 * @return the page_breadList
	 */
	public List getPage_breadList()
	{
		return page_breadList;
	}
	/**
	 * @param page_breadList the page_breadList to set
	 */
	public void setPage_breadList(List page_breadList)
	{
		this.page_breadList = page_breadList;
	}
	
	
	
}
