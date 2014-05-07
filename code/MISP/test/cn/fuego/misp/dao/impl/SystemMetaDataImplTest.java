/**   
* @Title: SystemMetaDataImplTest.java 
* @Package cn.fuego.misp.dao.impl 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-22 下午8:24:46 
* @version V1.0   
*/ 
package cn.fuego.misp.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.fuego.misp.domain.po.SystemMetaData;

/**   
 * @Title: SystemMetaDataImplTest.java 
 * @Package cn.fuego.misp.dao.impl 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-22 下午8:24:46 
 * @version V1.0   
 */

public class SystemMetaDataImplTest {

	SystemMetaData meta=new SystemMetaData();
	SystemMetaDataDaoImpl metaimpl=new SystemMetaDataDaoImpl();
	@Test
	public void testcreate() {
		
		meta.setTableName("a");
		meta.setAttrName("b");
		meta.setAttrDefaultValue("1");
		meta.setIsDisplay(0);
		meta.setIsFilter(0);
		meta.setSortOrder(0);
		metaimpl.create(meta);
		}
	
	@Test
	public void testdelete(){
		meta.setTableName("a");
		meta.setAttrName("b");
		metaimpl.delete(meta);
	}
	
	@Test
	public void testsaveorupdate(){
		meta.setTableName("aa");
		meta.setAttrName("bb");
		meta.setAttrDefaultValue("1");
		meta.setIsDisplay(0);
		meta.setIsFilter(0);
		meta.setSortOrder(0);
		metaimpl.create(meta);
	}
}
