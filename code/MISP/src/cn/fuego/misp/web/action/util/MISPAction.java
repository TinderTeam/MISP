package cn.fuego.misp.web.action.util;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MISPAction extends ActionSupport
{
	private  String page_pageName=null;
	private List<BreadTrail> page_breadList =null;
	
	
	
	/*
	 * Public Function 
	 * 用来方便Ajax获取单个参数使用
	 * 说明：因为从ajax 获取的参数如果是非常简单的String，则不需要用json处理，但是因为返回到后台始终以数组形式体现，
	 * 为了简化Action界面的代码量，故而在这个类里面实现相关单一参数提取功能。
	 */
	public String getAjaxPara(String paraName){
		
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> parameters = actionContext.getParameters();
		
		String[] paraList=(String[]) parameters.get(paraName);
		String para=paraList[0];
		return para;
		
	}
	
	
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "MISPAction [page_pageName=" + page_pageName
				+ ", page_breadList=" + page_breadList + "]";
	}
	
	
	
}
