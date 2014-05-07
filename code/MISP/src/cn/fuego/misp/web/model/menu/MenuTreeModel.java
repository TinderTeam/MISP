/**   
 * @Title: MenuTreeModel.java 
 * @Package cn.fuego.misp.web.model.menu 
 * @Description: TODO
 * @author Tang Jun   
 * @date 2014-3-17 上午12:02:36 
 * @version V1.0   
 */
package cn.fuego.misp.web.model.menu;

import java.util.List;

/**
 * @ClassName: MenuTreeModel
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-3-17 上午12:02:36
 * 
 */

public class MenuTreeModel
{
	private MenuModel menu;
	private List<MenuTreeModel> childMenuList;

	public MenuModel getMenu()
	{
		return menu;
	}

	public void setMenu(MenuModel menu)
	{
		this.menu = menu;
	}

	public List<MenuTreeModel> getChildMenuList()
	{
		return childMenuList;
	}

	public void setChildMenuList(List<MenuTreeModel> childMenuList)
	{
		this.childMenuList = childMenuList;
	}

	@Override
	public String toString()
	{
		return "MenuTreeModel [menu=" + menu + ", childMenuList=" + childMenuList + "]";
	}

}
