/**   
 * @Title: SystemUserImplTest.java 
 * @Package cn.fuego.misp.dao.impl 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-21 下午11:11:29 
 * @version V1.0   
 */
package cn.fuego.misp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.fuego.misp.domain.po.SystemUser;

/**
 * @Title: SystemUserImplTest.java
 * @Package cn.fuego.misp.dao.impl
 * @Description: TODO
 * @author Zhu Liucao
 * @date 2014-3-21 下午11:11:29
 * @version V1.0
 */

public class SystemUserImplTest
{

	SystemUser user = new SystemUser();
	SystemUserDaoImpl userImpl = new SystemUserDaoImpl();
	

	

	@Test
	public void testcreate()
	{
		user.setUserID("a");
		user.setPassword("123456");
		user.setUserName("admin");

		userImpl.create(user);
	}

	@Test
	public void testdelete()
	{
		user.setUserID("a");
		userImpl.delete(user);
	}

	@Test
	public void testsaveorupdate()
	{
		user.setUserID("b");
		user.setPassword("1234");
		user.setUserName("admin");

		userImpl.saveOrUpdate(user);
	}
	@Test
	public  void testgetByFilter()
	{
		ArrayList<String> IDList=new ArrayList<String>();
		ArrayList<String> NameList=new ArrayList<String>();

		user.setUserID("1");
		user.setUserName("a");
		user.setPassword("1234");
		userImpl.saveOrUpdate(user);
		user.setUserID("2");
		user.setUserName("b");
		user.setPassword("4321");
		userImpl.saveOrUpdate(user);
		user.setUserID("3");
		user.setUserName("c");
		user.setPassword("1111");
		userImpl.saveOrUpdate(user);

		//IDList.add("1");
		//IDList.add("2");
		IDList=null;
		NameList=null;
		//NameList.add("a");
		//NameList.add("b");
		List<SystemUser> userList2 = userImpl.getByFilter(IDList, NameList);
		System.out.println(userList2);
		 
		
	}

}
