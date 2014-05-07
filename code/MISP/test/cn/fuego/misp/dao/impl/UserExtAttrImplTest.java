/**   
* @Title: UserExtAttrImplTest.java 
* @Package cn.fuego.misp.dao.impl 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-22 上午1:00:00 
* @version V1.0   
*/ 
package cn.fuego.misp.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.fuego.misp.domain.po.UserExtAttr;

/**   
 * @Title: UserExtAttrImplTest.java 
 * @Package cn.fuego.misp.dao.impl 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-22 上午1:00:00 
 * @version V1.0   
 */

public class UserExtAttrImplTest {
	UserExtAttr attr= new UserExtAttr();
	UserExtAttrDaoImpl attrimpl=new UserExtAttrDaoImpl();
	
	@Test
	public void testcreate() {
		
		attr.setUserID("a");
		attr.setAttrName("aa");
		attr.setAttrValue("11");
		attrimpl.create(attr);
	}
	
	@Test
	public void testdelete(){
		attr.setUserID("a");
		attr.setAttrName("aa");
		attrimpl.delete(attr);
	}
	
	@Test
	public void testsaveorupdate(){
		attr.setUserID("b");
		attr.setAttrName("bb");
		attr.setAttrValue("12");
		attrimpl.saveOrUpdate(attr);
	}
}
