/**   
* @Title: UserGroupImplTest.java 
* @Package cn.fuego.misp.dao.impl 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-22 下午8:56:13 
* @version V1.0   
*/ 
package cn.fuego.misp.dao.impl;

import org.junit.Test;

import cn.fuego.misp.domain.po.UserGroup;

/**   
 * @Title: UserGroupImplTest.java 
 * @Package cn.fuego.misp.dao.impl 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-22 下午8:56:13 
 * @version V1.0   
 */

public class UserGroupImplTest {

	UserGroup group=new UserGroup();
	UserGroupDaoImpl gimpl=new UserGroupDaoImpl();
	@Test
	public void testcreate() {

		group.setGroupID(01);
		group.setGroupName("aa");
		group.setGroupDesp("aaa");
		gimpl.create(group);
		
	}
	@Test 
	public void testdelete(){
		
		group.setGroupID(01);
		gimpl.delete(group);
	}
	@Test
	public void testsaveorupdate(){
		group.setGroupID(02);
		group.setGroupName("bb");
		group.setGroupDesp("bbb");
		gimpl.saveOrUpdate(group);		
		
	}

}
