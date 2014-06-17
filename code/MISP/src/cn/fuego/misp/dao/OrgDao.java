/**   
* @Title: UserGroupDao.java 
* @Package cn.fuego.misp.dao 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-22 下午8:44:47 
* @version V1.0   
*/ 
package cn.fuego.misp.dao;

import cn.fuego.misp.domain.po.Org;

/**   
 * 
* @ClassName: OrgDao 
* @Description: TODO
* @author Nan Bowen
* @date 2014-6-13 下午06:25:04 
*
 */

public interface OrgDao {
	public void create(Org org);

	public void saveOrUpdate(Org or);

	public void delete(Org or);
}
