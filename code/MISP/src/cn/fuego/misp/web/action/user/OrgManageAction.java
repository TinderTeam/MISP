/**   
* @Title: QueryUserAction.java 
* @Package cn.fuego.misp.web.action.user 
* @Description: TODO
* @author Tang Jun   
* @date 2014-3-16 下午10:42:47 
* @version V1.0   
*/ 
package cn.fuego.misp.web.action.user;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/** 
 * @ClassName: QueryUserAction 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-3-16 下午10:42:47 
 *  
 */

public class OrgManageAction extends ActionSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2858809485016016887L;
	
	private Log log = LogFactory.getLog(OrgManageAction.class);
	
	ActionContext actionContext = ActionContext.getContext();
	Map<String, Object> session = actionContext.getSession();
	Map<String, Object> parameters = actionContext.getParameters();
	
	private String[] orgNameArray;
	private String orgBeloneInfo;
	
	
	public String execute()
	{   
		log.info("test");
		
		return SUCCESS;
	}

	public String ajaxSearchOrg() throws Exception
	{   
		
		/* 
		 *  Ajax request return the BeloneInfo of ORG
		 */
		
		orgNameArray= (String[])parameters.get("orgName");
		/*
		 * 
		 *  TODO:
		 *  这里调用OrgManageService的相关方法
		 *  具体功能：
		 *  String getOrgBeloneInfoByOrgMame(String orgName);
		 *  返回值：String OrgBeloneInfo格式为：
		 *  "深圳孚思科技 - 研发部 - MISP项目组"
		 */
	
		
		orgBeloneInfo="深圳孚思科技 - 研发部 - MISP项目组";//TODO 传入组织归属信息
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().getWriter().print(orgBeloneInfo);
		parameters.put("test","testValue");
		return null;
	}

	/**
	 * @return the orgName
	 */

	public void setOrgBeloneInfo(String orgBeloneInfo)
	{
		this.orgBeloneInfo = orgBeloneInfo;
	}

	public String getOrgBeloneInfo()
	{
		return orgBeloneInfo;
	}
	
}
