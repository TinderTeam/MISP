/**   
* @Title: QueryUserAction.java 
* @Package cn.fuego.misp.web.action.user 
* @Description: TODO
* @author Tang Jun   
* @date 2014-3-16 下午10:42:47 
* @version V1.0   
*/ 
package cn.fuego.misp.web.action.user;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.fuego.misp.service.ServiceContext;
import cn.fuego.misp.service.UserGroupManageService;
import cn.fuego.misp.web.action.basic.TableAction;
import cn.fuego.misp.web.constant.OperateTypeConst;
import cn.fuego.misp.web.model.group.GroupManageModel;
import cn.fuego.misp.web.model.group.UserGroupModel;
import cn.fuego.misp.web.model.user.UserManageModel;

/** 
 * @ClassName: QueryUserAction 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-3-16 下午10:42:47 
 *  
 */

public class GroupManageAction extends TableAction
{

	private static final long serialVersionUID = 6429748817468751103L;

	private Log log = LogFactory.getLog(GroupManageAction.class);
	
 
	private static final String SHOW_INFO="showInfo";

	private UserGroupManageService groupService = ServiceContext.getInstance().getUserGroupManageService();
	
	private GroupManageModel groupManage;
	
	public String execute()
	{   
	 
		this.loadList();
		return SUCCESS;
	}
	public String show()
	{
		log.info("show user");
		if(null == groupManage)
		{
			log.warn("the group manage is null");
			groupManage = new GroupManageModel();
		}
		
	    if(OperateTypeConst.CREATE.equals(super.getOperateType()))
	    {	
	    	groupManage.setUserGroup(new UserGroupModel()); 
	    }
	    else
	    {
	    	groupManage.setUserGroup(groupService.getGroupByID(getSelectedID()));
	    }
	    groupManage.getUserGroup().setTableExtAttrNameList(super.convertToPageMessage(ServiceContext.getInstance().getUserManagerService().getUserDisAttrNameList()));
 		return SHOW_INFO;
	}

	public String delete()
	{
		log.info("delete group, group id is " + super.getSelectedID());
		groupService.delete(super.getSelectedID());
		this.loadList();
		return SUCCESS;
	}
	public String create()
	{
		log.info("create user group, group is  " + groupManage.getUserGroup());
		groupService.create(groupManage.getUserGroup());
		this.loadList();
		return SUCCESS;
	}
	public String modify()
	{
		log.info("modify user group, group is  " + groupManage.getUserGroup());

		groupService.modify(groupManage.getUserGroup());
		this.loadList();
		return SUCCESS;
	}
 
	private void loadList()
	{
		if(null == groupManage)
		{	
			groupManage =new GroupManageModel();
		}

		groupManage.setGroupList(groupService.getAll());
		
		log.info("the group list size is " + groupManage.getGroupList().size());

	}
	public Log getLog()
	{
		return log;
	}
	public void setLog(Log log)
	{
		this.log = log;
	}
	public UserGroupManageService getGroupService()
	{
		return groupService;
	}
	public void setGroupService(UserGroupManageService groupService)
	{
		this.groupService = groupService;
	}
	public GroupManageModel getGroupManage()
	{
		return groupManage;
	}
	public void setGroupManage(GroupManageModel groupManage)
	{
		this.groupManage = groupManage;
	}
	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}
	public static String getShowInfo()
	{
		return SHOW_INFO;
	}
 

 

	
}
