
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
import cn.fuego.misp.util.validate.ValidatorUtil;
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
import com.opensymphony.xwork2.ActionSupport;
import com.sun.xml.internal.ws.wsdl.writer.document.Service;

/**
 * @ClassName: LoginAction
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-2-28 上午01:05:19
 * @Edit Nan Bowen at 2014-03-23
 */

public class UserManageAction extends ActionSupport
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
 
	     menuTreeItem=(List<MenuTreeModel>) session.get(SessionAttrNameConst.MENU_TREE);
 
	    AbstractDataSource<UserModel> userDataSource = userService.getUserListDataSourceByFilter(userManage.getFilter());
	    userManage.getUserList().setDataSource(userDataSource);
	    userManage.setExtAttrNameList(convertToPageMessage(userService.getUserExtAttrNameList()));
	 
 
		List<BreadTrail> breadList= new ArrayList<BreadTrail>();
		breadList.add(new BreadTrail("用户管理"));
 
		return SUCCESS;
	}
	
	public String delete(String userID)
	{
		return "";
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
