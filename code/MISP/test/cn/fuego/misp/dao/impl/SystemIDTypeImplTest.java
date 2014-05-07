/**   
* @Title: SystemIDTypeImplTest2.java 
* @Package cn.fuego.misp.dao.impl 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-19 上午12:50:49 
* @version V1.0   
*/ 
package cn.fuego.misp.dao.impl;

import org.junit.Test;

import cn.fuego.misp.domain.po.SystemIDType;

/**   
 * @Title: SystemIDTypeImplTest2.java 
 * @Package cn.fuego.misp.dao.impl 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-19 上午12:50:49 
 * @version V1.0   
 */

public class SystemIDTypeImplTest {
    SystemIDType id=new SystemIDType();
    SystemIDTypeDaoImpl idimpl=new SystemIDTypeDaoImpl();
	@Test
	public void testcreate() {
		id.setName("c");
		id.setStep(1);
		id.setCurrentID(11);
		id.setIncMode(12);
		id.setLength(5);
//		id.setPrefix("b");
//		id.setSuffix("c");
		idimpl.create(id);
		
	}
	@Test 
	public void testsaveorupdate()
	{
		id.setName("b");
		id.setStep(1);
		id.setCurrentID(11);
		id.setIncMode(12);
		id.setLength(5);
		id.setPrefix("a");
		id.setSuffix("c");
		idimpl.saveOrUpdate(id);
		
	}
	
	@Test
	public void testdelete()
	{
		id.setName("a");

		idimpl.delete(id);
	}

}
