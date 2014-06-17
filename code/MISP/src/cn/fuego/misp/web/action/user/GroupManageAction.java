/**   
* @Title: QueryUserAction.java 
* @Package cn.fuego.misp.web.action.user 
* @Description: TODO
* @author Tang Jun   
* @date 2014-3-16 下午10:42:47 
* @version V1.0   
*/ 
package cn.fuego.misp.web.action.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import stub.web.model.group.GroupModelStub;
import stub.web.model.org.OrgModelStub;
import stub.web.model.user.UserModelStub;

import cn.fuego.misp.web.action.util.BreadTrail;
import cn.fuego.misp.web.action.util.MISPAction;
import cn.fuego.misp.web.constant.SessionAttrNameConst;
import cn.fuego.misp.web.model.group.GroupManageModel;
import cn.fuego.misp.web.model.org.OrgManageModel;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/** 
 * @ClassName: QueryUserAction 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-3-16 下午10:42:47 
 *  
 */

public class GroupManageAction extends MISPAction
{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 6429748817468751103L;

	private Log log = LogFactory.getLog(GroupManageAction.class);
	
	ActionContext actionContext = ActionContext.getContext();
	Map<String, Object> session = actionContext.getSession();
	Map<String, Object> parameters = actionContext.getParameters();
	
	
	private GroupManageModel groupManageModel;
	
	public String execute()
	{   
		groupManageModel =new GroupManageModel();
		
		groupManageModel.setGroupList(GroupModelStub.getGroupModelList());
		session.put(SessionAttrNameConst.GROUP_MANAGE_MODEL, groupManageModel);
		
		setPage_pageName("权限组管理");
		List<BreadTrail> breadList= new ArrayList<BreadTrail>();
		breadList.add(new BreadTrail("用户管理"));
		breadList.add(new BreadTrail("权限组管理"));
		setPage_breadList(breadList);
		return SUCCESS;
	}

	public String ajaxSearchGroup() throws Exception
	{   
		log.info("test");
		
		String jsonStr = JSON.toJSONString(GroupModelStub.getGroupModel());
		log.info(jsonStr);
		
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().getWriter().print(jsonStr);
		return null;
	}



	
}
