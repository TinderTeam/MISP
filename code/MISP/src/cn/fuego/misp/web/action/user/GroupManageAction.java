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

import stub.web.model.group.GroupModelStub;
import cn.fuego.misp.service.ServiceContext;
import cn.fuego.misp.service.UserGroupManageService;
import cn.fuego.misp.web.action.basic.TableAction;
import cn.fuego.misp.web.model.group.GroupManageModel;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;

/** 
 * @ClassName: QueryUserAction 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-3-16 下午10:42:47 
 *  
 */

public class GroupManageAction extends TableAction
{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 6429748817468751103L;

	private Log log = LogFactory.getLog(GroupManageAction.class);
	
 
	
	private UserGroupManageService groupService = ServiceContext.getInstance().getUserGroupManageService();
	
	private GroupManageModel groupManageModel;
	
	public String execute()
	{   
		
 		
		loadList();
 
		return SUCCESS;
	}
	
	public void loadList()
	{
		if(null == groupManageModel)
		{	
			groupManageModel =new GroupManageModel();
		}

		groupManageModel.setGroupList(groupService.getAll());

	}
	public String delete()
	{
		log.info("delete user, user id is " + super.getSelectedID());
		groupService.delete(super.getSelectedID());
		loadList();
		return SUCCESS;
	}
	public String create()
	{
		return SUCCESS;
	}
	public String modify()
	{
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

	/**
	 * @return the groupManageModel
	 */
	public GroupManageModel getGroupManageModel()
	{
		return groupManageModel;
	}

	/**
	 * @param groupManageModel the groupManageModel to set
	 */
	public void setGroupManageModel(GroupManageModel groupManageModel)
	{
		this.groupManageModel = groupManageModel;
	}

	
}
