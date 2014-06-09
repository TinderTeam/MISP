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

import stub.web.model.org.OrgModelStub;
import stub.web.model.user.UserModelStub;

import cn.fuego.misp.service.exception.ServiceException;
import cn.fuego.misp.web.action.util.BreadTrail;
import cn.fuego.misp.web.action.util.MISPAction;
import cn.fuego.misp.web.constant.SessionAttrNameConst;
import cn.fuego.misp.web.constant.UtilConstant;
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

public class OrgManageAction extends MISPAction
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2858809485016016887L;
	
	private Log log = LogFactory.getLog(OrgManageAction.class);
	
	ActionContext actionContext = ActionContext.getContext();
	Map<String, Object> session = actionContext.getSession();
	Map<String, Object> parameters = actionContext.getParameters();
	

	private OrgManageModel orgManageModel;
	
	public String execute()
	{   
		OrgManageModel orgManageModel =new OrgManageModel();
		
		/*
		 *	TODO:
		 *	get unOrgUserName-list(for org member set up), and get orgList. 
		 */
		orgManageModel.setNoOrgUserList(UserModelStub.getUserModelList());
		orgManageModel.setOrgList(OrgModelStub.getOrgModelList());
		
		session.put(SessionAttrNameConst.ORG_MANAGE_MODEL, orgManageModel);
		
		setPage_pageName("组织机构管理");
		List<BreadTrail> breadList= new ArrayList<BreadTrail>();
		breadList.add(new BreadTrail("组织机构管理"));
		setPage_breadList(breadList);
		return SUCCESS;
	}

	public String ajaxSearchOrg() throws Exception
	{   
		
		/* 
		 *  Ajax request return the BeloneInfo of ORG
		 */
		/*
		 * 
		 *  TODO:
		 *  here call function in 'OrgManageService'
		 *  basic function：
		 *  OrgManageModel getOrgBeloneInfoByOrgMame(String orgName);
		 *  Input Para: orgName=(String[])parameters.get("orgName")[0]
		 *  Return ：OrgManageModel OrgBeloneInfo
		 *  Formal：
		 *  "root - branch - leaf"
		 */
		
		/*----Test code-----*/
		OrgManageModel orgManageModel = new OrgManageModel();
		orgManageModel.setOrgBeloneInfo("深圳孚思科技 - 研发部 - MISP项目组");
		orgManageModel.setStaticInfo("MISP项目组有：子机构2个，成员用户2个");
		/*----*/
		
		
		String jsonStr = JSON.toJSONString(orgManageModel);
		log.info(jsonStr);
		
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().getWriter().print(jsonStr);
		parameters.put("test","testValue");
		return null;
	}

	public String ajaxOrgModify() throws Exception
	{   
		
		/*Modify the Org Information*/
		
		
		//get paraData;
		
		String oldOrgName=getAjaxPara("oldOrgName");
		String newOrgBelone=getAjaxPara("newOrgBelone");
		String newOrgName=getAjaxPara("newOrgName");
			
		try{
			/* 
			 * TODO: Implements Service Code
			 * 1.modify org Info.
			 * service.modifyOrgInfo(String oldOrgName,String newOrgName,String new orgBelone);
			 * 
			 * 2. update 'orgManageModel' content (orgList & orgManageModel)
			 *  orgManageModel.setOrgList(OrgModelStub.getOrgModelList());
			 * 	session.put(SessionAttrNameConst.ORG_MANAGE_MODEL, orgManageModel);
			 */
			return SUCCESS;	//rejump to orgManage.action to refresh the page;

		}catch(ServiceException ex){	
			return UtilConstant.SYSTEM_ERR;
		}
			
		
		
	}


	public void setOrgManageModel(OrgManageModel orgManageModel)
	{
		this.orgManageModel = orgManageModel;
	}

	public OrgManageModel getOrgManageModel()
	{
		return orgManageModel;
	}
	
}
