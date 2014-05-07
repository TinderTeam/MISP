/**   
* @Title: SystemFunctionSetImplTest.java 
* @Package cn.fuego.misp.dao.impl 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-23 上午12:04:02 
* @version V1.0   
*/ 
package cn.fuego.misp.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.fuego.misp.domain.po.SystemFunctionSet;

/**   
 * @Title: SystemFunctionSetImplTest.java 
 * @Package cn.fuego.misp.dao.impl 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-23 上午12:04:02 
 * @version V1.0   
 */

public class SystemFunctionSetImplTest {

	SystemFunctionSet function= new SystemFunctionSet();
	SystemFunctionSetDaoImpl fimpl= new SystemFunctionSetDaoImpl();
	@Test
	public void testcreate() {
		
		function.setFunctionID(001);
		function.setFunctionName("add");
		function.setFunctionType(0);
		fimpl.create(function);
	}
	@Test
	public void testdelete(){
		function.setFunctionID(001);
		fimpl.delete(function);
	}
	@Test
	public void testsaveorupdate(){
		function.setFunctionID(002);
		function.setFunctionName("save");
		function.setFunctionType(3);
		fimpl.saveOrUpdate(function);
	}

}
