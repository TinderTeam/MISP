/**   
* @Title: SystemMenuImplTest.java 
* @Package cn.fuego.misp.dao.impl 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-23 下午11:55:22 
* @version V1.0   
*/ 
package cn.fuego.misp.dao.impl;

import java.util.List;

import org.junit.Test;

import cn.fuego.misp.domain.po.SystemMenu;

/**   
 * @Title: SystemMenuImplTest.java 
 * @Package cn.fuego.misp.dao.impl 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-23 下午11:55:22 
 * @version V1.0   
 */

public class SystemMenuImplTest {

	SystemMenu menu= new SystemMenu();
	SystemMenuDaoImpl mimpl=new SystemMenuDaoImpl();
	@Test
	public void testcreate() {
		menu.setMenuID(001);
		menu.setName("aa");
		menu.setFunctionID(02);
		menu.setIcon("red");
		mimpl.create(menu);
		
	}
	@Test
	public void testdelete()
	{
		menu.setMenuID(001);
		mimpl.delete(menu);
	}
	@Test
	public void testsaveorupdate()
	{
		menu.setMenuID(001);
		menu.setName("aa");
		menu.setFunctionID(02);
		menu.setIcon("green");
		
		mimpl.saveOrUpdate(menu);
	}
	@Test
	public void testgetbyparentID()
	{
		int pID=002;
		menu.setMenuID(001);
		menu.setName("aa");
		menu.setFunctionID(02);
		menu.setIcon("green");
		menu.setParentID(001);
		mimpl.saveOrUpdate(menu);
		
		menu.setMenuID(002);
		menu.setName("bb");
		menu.setFunctionID(03);
		menu.setIcon("blue");
		menu.setParentID(002);
		mimpl.saveOrUpdate(menu);
		
		List<SystemMenu> menuout=mimpl.getMenuByParentID(pID);
		System.out.println(menuout);
	}
	
}
