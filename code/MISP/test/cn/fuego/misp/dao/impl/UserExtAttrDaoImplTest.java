/**   
* @Title: UserExtAttrDaoImplTest.java 
* @Package cn.fuego.misp.dao.impl 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-28 上午12:23:24 
* @version V1.0   
*/ 
package cn.fuego.misp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import stub.web.model.user.UserModelStub;


import cn.fuego.misp.domain.base.AttributeBean;
import cn.fuego.misp.domain.po.UserExtAttr;
import cn.fuego.misp.web.model.user.UserModel;

/**   
 * @Title: UserExtAttrDaoImplTest.java 
 * @Package cn.fuego.misp.dao.impl 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-28 上午12:23:24 
 * @version V1.0   
 */

public class UserExtAttrDaoImplTest
{
	Log log = LogFactory.getLog(UserExtAttrDaoImplTest.class);
	
	UserExtAttr attr= new UserExtAttr();
	UserExtAttrDaoImpl attrimpl=new UserExtAttrDaoImpl();
	/**
	 * Test method for {@link cn.fuego.misp.dao.impl.UserExtAttrDaoImpl#create(cn.fuego.misp.domain.po.UserExtAttr)}.
	 */
	@Test
	public void testCreate()
	{
		attr.setUserID("a");
		attr.setAttrName("aa");
		attr.setAttrValue("11");
		attrimpl.create(attr);
	}

	/**
	 * Test method for {@link cn.fuego.misp.dao.impl.UserExtAttrDaoImpl#saveOrUpdate(cn.fuego.misp.domain.po.UserExtAttr)}.
	 */
	@Test
	public void testSaveOrUpdate()
	{
		attr.setUserID("b");
		attr.setAttrName("bb");
		attr.setAttrValue("12");
		attrimpl.saveOrUpdate(attr);		

	}

	/**
	 * Test method for {@link cn.fuego.misp.dao.impl.UserExtAttrDaoImpl#delete(cn.fuego.misp.domain.po.UserExtAttr)}.
	 */
	@Test
	public void testDelete()
	{
		attr.setUserID("a");
		attr.setAttrName("aa");
		attrimpl.delete(attr);
	}

	/**
	 * Test method for {@link cn.fuego.misp.dao.impl.UserExtAttrDaoImpl#getByFilter(java.util.List)}.
	 */


	@Test
	public void testGetByFilter()
	{
//		ArrayList<AttributeBean> attrList= new ArrayList<AttributeBean>();
		
		AttributeBean ab1 =new AttributeBean();
//		AttributeBean ab2 =new AttributeBean();
//	
		ab1.setAttrName("a");
		ab1.setAttrValue("aa");
//		ab2.setAttrName("b");
//		ab2.setAttrValue("bb");
//		attrList.add(ab1);
//		attrList.add(ab2);
//		log.info(attrList);
		UserModelStub.setAttrModel("001", "a", "aa");
		UserModelStub.setAttrModel("002", "b", "bb");
		UserModelStub.setAttrModel("003", "c", "cc");
		
		List<UserExtAttr> userExtList=attrimpl.getByFilter(null,ab1);
		log.info(userExtList);
		System.out.println(userExtList);
		//assert.equals(userExtList);
		
	}

}
