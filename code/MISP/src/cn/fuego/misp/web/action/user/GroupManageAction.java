/**   
* @Title: QueryUserAction.java 
* @Package cn.fuego.misp.web.action.user 
* @Description: TODO
* @author Tang Jun   
* @date 2014-3-16 下午10:42:47 
* @version V1.0   
*/ 
package cn.fuego.misp.web.action.user;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.type.DateType;

import cn.fuego.misp.service.ServiceContext;
import cn.fuego.misp.service.UserGroupManageService;
import cn.fuego.misp.util.format.DataTypeConvert;
import cn.fuego.misp.util.validate.ValidatorUtil;
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
	private static final String SHOW_MEMBER="showMember";


	private UserGroupManageService groupService = ServiceContext.getInstance().getUserGroupManageService();
	
	private GroupManageModel groupManage;
	
	public String execute()
	{   
	 
		this.loadList();
		return SUCCESS;
	}
	public String show()
	{

		
	    if(OperateTypeConst.CREATE.equals(super.getOperateType()))
	    {	
	    	log.info("the page is create page,just show a empty page");
	    	loadGroupByID(null);
	    }
	    else
	    {
	    	loadGroupByID(getSelectedID());
	    }
    	
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
	
 
	public String showMember()
	{
		
		loadGroupByID(getSelectedID());
		return SHOW_MEMBER;
	}
	public String deleteMember()
	{
		
		if(ValidatorUtil.isEmpty(this.getSelectedID()))
		{
			log.warn("select id list is empty");
		}
		else
		{
			groupService.deleteMember(this.groupManage.getUserGroup().getGroupID(),this.getSelectedID());
 		}
		
		loadGroupByID(this.groupManage.getUserGroup().getGroupID());

		return SHOW_MEMBER;
	}
 
	public String addMember()
	{
		if(ValidatorUtil.isEmpty(this.getSelectedIDList()))
		{
			log.warn("select id list is empty");
		}
		else
		{
			groupService.addMember(this.groupManage.getUserGroup().getGroupID(),Arrays.asList(this.getSelectedIDList()));

		}
		
		loadGroupByID(this.groupManage.getUserGroup().getGroupID());
 

		return SHOW_MEMBER;
	}
	private void loadGroupByID(String groupID)
	{
		log.info("show user group");
		if(null == groupManage)
		{
			log.warn("the group manage is null");
			groupManage = new GroupManageModel();
		}
		if(ValidatorUtil.isEmpty(groupID))
		{
			groupManage.setUserGroup(new UserGroupModel());
		}
		else
		{
		    groupManage.setUserGroup(groupService.getGroupByID(groupID));
		}
	  
	    groupManage.getUserGroup().setTableExtAttrNameList(super.convertToPageMessage(ServiceContext.getInstance().getUserManagerService().getUserDisAttrNameList()));
	    groupManage.setUserList(ServiceContext.getInstance().getUserManagerService().getUserListDataSourceByFilter(null).getAllPageData());
	    groupManage.setAllFunctionList(ServiceContext.getInstance().getUserGroupManageService().getAllFunction());
 		
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
