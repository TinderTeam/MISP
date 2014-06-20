package cn.fuego.misp.dao.impl;

import org.junit.Test;

import cn.fuego.misp.domain.po.Org;
import cn.fuego.misp.domain.po.UserGroup;


public class OrgDaoImplTest
{
	Org org=new Org();
	OrgDaoImpl gimpl=new OrgDaoImpl();
	//@Test
	public void testcreate() {

		org.setOrgID("01");
		org.setOrgName("aa");
		org.setOrgDesp("aaa");
		gimpl.create(org);
		
	}
	@Test 
	public void testdelete(){
		Org org=new Org();
		org.setOrgID("001");
		gimpl.delete(org);
	}
	//@Test
	public void testsaveorupdate(){
		org.setOrgID("002");
		org.setOrgName("bb");
		org.setOrgDesp("bbb");
		gimpl.saveOrUpdate(org);		
		
	}

}
