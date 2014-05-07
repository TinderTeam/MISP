/**   
* @Title: UserGroupMapFunctionImplTest.java 
* @Package cn.fuego.misp.dao.impl 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-23 上午12:31:22 
* @version V1.0   
*/ 
package cn.fuego.misp.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.fuego.misp.domain.po.UserGroupMapFunction;

/**   
 * @Title: UserGroupMapFunctionImplTest.java 
 * @Package cn.fuego.misp.dao.impl 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-23 上午12:31:22 
 * @version V1.0   
 */

public class UserGroupMapFunctionImplTest {

	UserGroupMapFunction umap= new UserGroupMapFunction();
	UserGroupMapFunctionDaoImpl umimpl=new UserGroupMapFunctionDaoImpl();
	@Test
	public void testcreate() {

		umap.setGroupID(001);
		umap.setFunctionID(100);
		umimpl.create(umap);
	}
	@Test
	public void testdelete(){
		umap.setGroupID(001);
		umap.setFunctionID(100);
		umimpl.delete(umap);
	}
	@Test
	public void testsaveorupdate(){
		umap.setGroupID(011);
		umap.setFunctionID(101);
		umimpl.saveOrUpdate(umap);
	}
}
