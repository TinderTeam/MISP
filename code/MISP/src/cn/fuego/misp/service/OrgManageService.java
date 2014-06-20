/**   
* @Title: OrgTreeManageService.java 
* @Package cn.fuego.misp.service 
* @Description: TODO
* @author Tang Jun   
* @date 2014-6-18 下午09:09:38 
* @version V1.0   
*/ 
package cn.fuego.misp.service;

import java.util.List;

import cn.fuego.misp.web.model.org.OrgModel;

/** 
 * @ClassName: OrgTreeManageService 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-6-18 下午09:09:38 
 *  
 */

public interface OrgManageService
{
	public List<OrgModel>  getAllOrg();
	
	public OrgModel getOrgModelByID(String orgID);
 
	public void create(OrgModel orgModel);
	public void modify(OrgModel orgModel);
	
	public void delete(String orgID);
 

}
