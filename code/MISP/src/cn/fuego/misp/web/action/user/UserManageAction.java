
package cn.fuego.misp.web.action.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import stub.web.util.forecom.table.MispTableStub;
import cn.fuego.misp.service.ServiceContext;
import cn.fuego.misp.service.UserManageService;
import cn.fuego.misp.service.datasource.AbstractDataSource;
import cn.fuego.misp.web.action.util.BreadTrail;
import cn.fuego.misp.web.action.util.MISPAction;
import cn.fuego.misp.web.constant.SessionAttrNameConst;
import cn.fuego.misp.web.model.menu.MenuTreeModel;
import cn.fuego.misp.web.model.page.PageModel;
import cn.fuego.misp.web.model.user.UserFilterModel;
import cn.fuego.misp.web.model.user.UserManageModel;
import cn.fuego.misp.web.model.user.UserModel;
import cn.fuego.misp.web.util.forecom.table.MispTable;

import com.opensymphony.xwork2.ActionContext;
import com.sun.xml.internal.ws.wsdl.writer.document.Service;

/**
 * @ClassName: LoginAction
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-2-28 上午01:05:19
 * @Edit Nan Bowen at 2014-03-23
 */

public class UserManageAction extends MISPAction
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Log log = LogFactory.getLog(UserManageAction.class);
	private List<MenuTreeModel> menuTreeItem;


	private UserManageModel userManage = new UserManageModel();
	
	private UserManageService userService = ServiceContext.getInstance().getUserManagerService();
 
	
	public String execute()
	{
		 ActionContext actionContext = ActionContext.getContext();
	     Map session = actionContext.getSession();
	       
	     /*
	      * Get MenuList
	      */
	     menuTreeItem=(List<MenuTreeModel>) session.get(SessionAttrNameConst.MENU_TREE);
	 
 
		/*
		 * This Code is Designed by Bowen. Which is means to config the basic page info. for instance, the name and the breadTrail
		 * we mast try to do and design better on this fuction. 
		 */
	    AbstractDataSource<UserModel> userDataSource = userService.getUserListDataSourceByFilter(userManage.getFilter());
	    userManage.setUserList(new PageModel<UserModel>(userDataSource));
		
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



 



 
	

}
