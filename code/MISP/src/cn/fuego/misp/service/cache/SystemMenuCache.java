/**   
 * @Title: SystemMenuCache.java 
 * @Package cn.fuego.misp.service.cache 
 * @Description: TODO
 * @author Tang Jun   
 * @date 2014-3-25 下午11:13:07 
 * @version V1.0   
 */
package cn.fuego.misp.service.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.fuego.misp.dao.DaoContext;
import cn.fuego.misp.dao.SystemMenuDao;
import cn.fuego.misp.domain.po.SystemMenu;
import cn.fuego.misp.util.validate.ValidatorUtil;
import cn.fuego.misp.web.model.menu.MenuModel;
import cn.fuego.misp.web.model.menu.MenuTreeModel;

/**
 * @ClassName: SystemMenuCache
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-3-25 下午11:13:07
 * 
 */

public class SystemMenuCache
{	
	SystemMenuDao systemMenuDao = DaoContext.getInstance().getSystemMenuDao();

	
	private Log log = LogFactory.getLog(SystemMenuCache.class);

	private static SystemMenuCache instance;
	private List<MenuTreeModel> cache;
	private List<String> functionList;

	private SystemMenuCache()
	{
		this.reload();

	}
	
	public static synchronized SystemMenuCache getInstance()
	{
		if (null == instance)
		{
			instance = new SystemMenuCache();
		}
		return instance;
	}
	
	public void reload()
	{
		// there is no parent menu when parent id is 0
		cache = loadMenuTreeByParentID(0);
		log.info("loaded all menu list" + cache);

	}
	public List<MenuTreeModel> getAllMenu()
	{
		return this.cache;
	}
	public List<MenuTreeModel>  getAllByFunctionIDList(Set<String> functionList)
	{
		
		return getMenuTreeByFunctionIDList(this.cache,functionList);
		 
	}
	
	public List<String> getAllMenuFunctionIDList()
	{
         if(null != functionList)
         {
        	 return functionList;
         }
         functionList = new ArrayList<String>();
		 List<SystemMenu> menuList =  systemMenuDao.getAllMenu();
         
         if(!ValidatorUtil.isEmpty(menuList))
         {
        	 for(SystemMenu menu: menuList)
        	 {
        		 functionList.add(menu.getFunctionID());
        	 }
         }
         return functionList;
	}

	private List<MenuTreeModel> getMenuTreeByFunctionIDList(List<MenuTreeModel> menuTreeList, Set<String> functionList)
	{
		List<MenuTreeModel> nowMenuTreeList = new ArrayList<MenuTreeModel>();
		for(MenuTreeModel menuModel : menuTreeList)
		{

			MenuTreeModel nowMenuTree = new MenuTreeModel();
			
			nowMenuTree.setMenu(menuModel.getMenu().clone());
 			if (null != menuModel.getChildMenuList())
			{
				List<MenuTreeModel> childMenuList = getMenuTreeByFunctionIDList(menuModel.getChildMenuList(),functionList);
				nowMenuTree.setChildMenuList(childMenuList);
			}
			if(null != functionList && functionList.contains(menuModel.getMenu().getFunctionID()))
			{	
 			 
				nowMenuTree.getMenu().setSelected(true);
			}
 			nowMenuTreeList.add(nowMenuTree);

		}
		return nowMenuTreeList;
	}

	/**
	 * load menu tree by parent id
	 * 
	 * @param parentID
	 * @return
	 */
	private List<MenuTreeModel> loadMenuTreeByParentID(int parentID)
	{
		List<MenuTreeModel> menuTreeList = new ArrayList<MenuTreeModel>();

		for (SystemMenu menu : systemMenuDao.getMenuByParentID(parentID))
		{
			MenuTreeModel menuTreeModel = new MenuTreeModel();
			menuTreeModel.setMenu(convertSystemMenuToMenuModel(menu));
			if (null != systemMenuDao.getMenuByParentID(menu.getMenuID()) && !systemMenuDao.getMenuByParentID(menu.getMenuID()).isEmpty())
			{
				menuTreeModel.setChildMenuList(loadMenuTreeByParentID(menu.getMenuID()));
			}
			menuTreeList.add(menuTreeModel);
		}
		return menuTreeList;
	}
	
	private MenuModel convertSystemMenuToMenuModel(SystemMenu menu)
	{
		MenuModel menuModel = new MenuModel();
		menuModel.setMenuID(menu.getMenuID());
		menuModel.setFresh(menu.getFresh());
		menuModel.setIcon(menu.getIcon());
		menuModel.setName(menu.getName());
		menuModel.setType(menu.getType());
		menuModel.setParentID(menu.getParentID());
		menuModel.setUrl(menu.getUrl());
		menuModel.setFunctionID(menu.getFunctionID());
		menuModel.setValue(menu.getValue());
		menuModel.setExternal(menu.getExternal());
		return menuModel;
	}
}
