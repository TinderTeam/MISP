
package cn.fuego.misp.web.action.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.fuego.misp.service.ServiceContext;
import cn.fuego.misp.service.UserManageService;
import cn.fuego.misp.service.datasource.AbstractDataSource;
import cn.fuego.misp.util.validate.ValidatorUtil;
import cn.fuego.misp.web.action.basic.TableAction;
import cn.fuego.misp.web.action.util.BreadTrail;
import cn.fuego.misp.web.constant.OperateTypeConst;
import cn.fuego.misp.web.model.common.AttributeModel;
import cn.fuego.misp.web.model.menu.MenuTreeModel;
import cn.fuego.misp.web.model.user.UserFilterModel;
import cn.fuego.misp.web.model.user.UserManageModel;
import cn.fuego.misp.web.model.user.UserModel;

/**
 * @ClassName: LoginAction
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-2-28 上午01:05:19
 * @Edit Nan Bowen at 2014-03-23
 */

public class UserManageAction extends TableAction
{
 
	private static final long serialVersionUID = 1L;
	private Log log = LogFactory.getLog(UserManageAction.class);
	private List<MenuTreeModel> menuTreeItem;


	private UserManageModel userManage ;
 	
	private UserManageService userService = ServiceContext.getInstance().getUserManagerService();
 
	
	public String execute()
	{
 	    loadUserList();
		
 	    List<BreadTrail> breadList= new ArrayList<BreadTrail>();
		breadList.add(new BreadTrail("用户管理"));
 
		return SUCCESS;
	}
	
	public String delete()
	{
		log.info("delete user, user id is " + super.getSelectedID());
		userService.delete(super.getSelectedID());
		loadUserList();
		return SUCCESS;
	}
	
	public String create()
	{
		userService.create(userManage.getUser());
		loadUserList();
		return SUCCESS;
	}
	
	public String modify()
	{
		userService.modify(userManage.getUser());
		loadUserList();
		return SUCCESS;
	}
	public String showUser()
	{
		log.info("show user");
		if(null == userManage)
		{
			userManage = new UserManageModel();
		}
	    userManage.setExtAttrNameList(convertToPageMessage(userService.getUserDisAttrNameList()));
 
	    if(OperateTypeConst.CREATE.equals(super.getOperateType()))
	    {	
			userManage.setUser(new UserModel());
	    	userManage.getUser().setAttrList(getInitAttrList(userService.getUserFilterAttrNameList()));
 
	    }
	    else
	    {
			userManage.setUser(userService.getUserByID(getSelectedID()));
	    }
		return SUCCESS;
	}
	
	public void loadUserList()
	{
		if(null == userManage)
		{
			log.warn("the user manage is null");
			userManage = new UserManageModel();
		}
	    if(null == userManage.getFilter())
	    {
	    	log.warn("the userf filer is null");
	    	userManage.setFilter(new UserFilterModel());
 
	    	userManage.getFilter().setAttrList(getInitAttrList(userService.getUserFilterAttrNameList()));
 
	    }
	    
    	userManage.getFilter().setFilterAttrNameList(convertToPageMessage(userService.getUserFilterAttrNameList()));

    	
	    AbstractDataSource<UserModel> userDataSource = userService.getUserListDataSourceByFilter(userManage.getFilter());
	    userManage.getUserList().setDataSource(userDataSource);
	    userManage.setExtAttrNameList(convertToPageMessage(userService.getUserDisAttrNameList()));
	 
	}

	private List<AttributeModel>  getInitAttrList(List<String> attrNameList)
	{
		List<AttributeModel> filterAttrList = new ArrayList<AttributeModel>();
		for(String filterAttrName : attrNameList)
		{	
			AttributeModel attrModel = new AttributeModel();
			attrModel.setAttrName(filterAttrName);
			filterAttrList.add(attrModel);
		}
		return filterAttrList;
	}

	private List<String> convertToPageMessage(List<String> messageList)
	{
		List<String> resourceList = new ArrayList<String>();
		if(!ValidatorUtil.isEmpty(messageList))
		{
			for(String message : messageList)
			{
				resourceList.add(this.getText(message));
			}
		}
		return resourceList;

	}


	public void setMenuTreeItem(List<MenuTreeModel> menuTreeItem)
	{
		this.menuTreeItem = menuTreeItem;
	}

	public List<MenuTreeModel> getMenuTreeItem()
	{
		return menuTreeItem;
	}




	public UserManageModel getUserManage()
	{
		return userManage;
	}




	public void setUserManage(UserManageModel userManage)
	{
		this.userManage = userManage;
	}



 



 
	

}
