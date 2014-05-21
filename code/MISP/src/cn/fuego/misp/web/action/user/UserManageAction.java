
package cn.fuego.misp.web.action.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import stub.web.util.forecom.table.MispTableStub;
import cn.fuego.misp.web.action.util.BreadTrail;
import cn.fuego.misp.web.action.util.BreadTrailList;
import cn.fuego.misp.web.action.util.MISPAction;
import cn.fuego.misp.web.constant.SessionAttrNameConst;
import cn.fuego.misp.web.model.menu.MenuTreeModel;
import cn.fuego.misp.web.util.forecom.table.MispTable;

import com.opensymphony.xwork2.ActionContext;

/**
 * @ClassName: LoginAction
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-2-28 上午01:05:19
 * @Edit Nan Bowen at 2014-03-23
 */

public class UserManageAction extends MISPAction
{
	Log log = LogFactory.getLog(UserManageAction.class);
	private List<MenuTreeModel> menuTreeItem;

	//表格属性
	private MispTable table;
	
	
	public String execute()
	{
		 ActionContext actionContext = ActionContext.getContext();
	     Map session = actionContext.getSession();
	       
	     /*
	      * Get MenuList
	      */
	     menuTreeItem=(List<MenuTreeModel>) session.get(SessionAttrNameConst.MENU_TREE);
	 
	     /*
	      * Set Table
	      */
	     table=MispTableStub.getBasicMispTableStub();
	     log.info(table);
		/*
		 * This Code is Designed by Bowen. Which is means to config the basic page info. for instance, the name and the breadTrail
		 * we mast try to do and design better on this fuction. 
		 */
		setPage_pageName("用户管理");
		List<BreadTrail> breadList= new ArrayList<BreadTrail>();
		breadList.add(new BreadTrail("用户管理"));
		setPage_breadList(breadList);
		return SUCCESS;
	}

	


	public void setMenuTreeItem(List<MenuTreeModel> menuTreeItem)
	{
		this.menuTreeItem = menuTreeItem;
	}

	public List<MenuTreeModel> getMenuTreeItem()
	{
		return menuTreeItem;
	}




	/**
	 * @return the table
	 */
	public MispTable getTable()
	{
		return table;
	}




	/**
	 * @param table the table to set
	 */
	public void setTable(MispTable table)
	{
		this.table = table;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "UserManageAction [log=" + log + ", menuTreeItem="
				+ menuTreeItem + ", table=" + table + "]";
	}
	
	

}
