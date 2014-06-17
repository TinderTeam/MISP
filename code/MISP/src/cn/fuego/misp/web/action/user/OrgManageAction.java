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

import cn.fuego.misp.domain.po.Org;
import cn.fuego.misp.service.exception.ServiceException;
import cn.fuego.misp.web.action.util.BreadTrail;
import cn.fuego.misp.web.action.util.MISPAction;
import cn.fuego.misp.web.constant.SessionAttrNameConst;
import cn.fuego.misp.web.constant.UtilConstant;
import cn.fuego.misp.web.model.org.OrgManageModel;
import cn.fuego.misp.web.model.user.UserModel;

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
		return null;
	}
	
	public String searchOrgInfoByID() throws Exception
	{   
		
		/*Modify the Org Information*/
		log.info("Action: getOrgInfoByID");
		
		//get paraData;
		
		String orgID=getAjaxPara("orgID");


			
		Org org =new Org();
		org.setOrgDesp("描述信息");	
		org.setOrgName("名称 ");
		
		String jsonStr = JSON.toJSONString(org);
		log.info(jsonStr);
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().getWriter().print(jsonStr);
		return null;
		
		
	}
	
	public String searchUserByID() throws Exception
	{   
		
		log.info("Action: searchUserByID");
		
		//get paraData;
		
		String orgID=getAjaxPara("orgID");

		List<UserModel> userList= UserModelStub.getUserModelList();
			

		
		String jsonStr = JSON.toJSONString(userList);
		log.info(jsonStr);
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().getWriter().print(jsonStr);
		return null;
		
		
	}

	public String addSubOrg() throws Exception
	{   
		
		/*Add sub Org*/
		log.info("addSubOrg");
		
		//get paraData;	
		try{		
			return SUCCESS;	//rejump to orgManage.action to refresh the page;

		}catch(ServiceException ex){	
			return UtilConstant.SYSTEM_ERR;
		}
			
		
		
	}
	
	public String 	modifyOrg() throws Exception
	{   
		
		/*modyfyOrg*/
		log.info("modifyOrg");
		String orgID=getAjaxPara("orgID");
		String newName=getAjaxPara("newName");
		String dept=getAjaxPara("dept");
		log.info("上传的数据为："+orgID);
		//get paraData;		
		//Service
		return null;
	
		
		
	}
	

	
	public String deleteSubOrg() throws Exception
	{   
		log.info("deleteOrg Function");
		
		/*Add sub Org*/
		String deleteOrg=getAjaxPara("deleteOrg");
		
		log.info("上传的数据为："+deleteOrg);
		
		//get paraData;	
		try{		
			return SUCCESS;	//rejump to orgManage.action to refresh the page;

		}catch(ServiceException ex){	
			return UtilConstant.SYSTEM_ERR;
		}
			
		
		
	}
	public String orgNameVerification() throws Exception
	{   
		
		/*Modify the Org Information*/
		log.info("orgNameVerification");
		String verificationResult="";
		//get paraData;
		
	
			String newOrgName=getAjaxPara("newOrgName");
			log.info(newOrgName);
		//	if(service.orgNameVerification(newOrgName)){
		//		verificationResult="noRepeat";	//new Org name not repeat
		//	}else{
				verificationResult="repeat";	//new Org name is repeat
		//	}
				ServletActionContext.getResponse().setCharacterEncoding("utf-8");
				ServletActionContext.getResponse().getWriter().print(verificationResult);
			
			return null;	

		
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
