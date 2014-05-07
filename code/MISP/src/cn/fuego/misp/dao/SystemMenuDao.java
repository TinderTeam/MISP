/**   
* @Title: SystemMenuDao.java 
* @Package cn.fuego.misp.dao 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-23 下午11:42:01 
* @version V1.0   
*/ 
package cn.fuego.misp.dao;

import java.util.List;

import cn.fuego.misp.domain.po.SystemMenu;

/**   
 * @Title: SystemMenuDao.java 
 * @Package cn.fuego.misp.dao 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-23 下午11:42:01 
 * @version V1.0   
 */

public interface SystemMenuDao {

	public void create(SystemMenu menu);

	public void saveOrUpdate(SystemMenu menu);

	public void delete(SystemMenu menu);
	
	public List<SystemMenu> getMenuByParentID(int parentID);
}
