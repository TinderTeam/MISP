/**   
* @Title: UserMapGroupImplTest.java 
* @Package cn.fuego.misp.dao.impl 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-22 下午11:29:02 
* @version V1.0   
*/ 
package cn.fuego.misp.dao.impl;

import org.junit.Test;

import cn.fuego.misp.domain.po.UserMapGroup;

/**   
 * @Title: UserMapGroupImplTest.java 
 * @Package cn.fuego.misp.dao.impl 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-22 下午11:29:02 
 * @version V1.0   
 */

public class UserMapGroupImplTest {

	UserMapGroup map= new UserMapGroup();
	UserMapGroupDaoImpl mimpl= new UserMapGroupDaoImpl(); 
	@Test
	public void testcreate() {
		
		map.setUserID("a");
		map.setGroupID(001);
		mimpl.create(map);
		
	}

	@Test
	public void testdelete(){
		map.setUserID("a");
		map.setGroupID(001);
		mimpl.delete(map);
	}
	
	@Test
	public void testsaveorupdate(){
		map.setUserID("b");
		map.setGroupID(002);
		mimpl.saveOrUpdate(map);
	}
}
