/**   
* @Title: UserGroupDao.java 
* @Package cn.fuego.misp.dao 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-22 下午8:44:47 
* @version V1.0   
*/ 
package cn.fuego.misp.dao;

import java.util.List;

import cn.fuego.misp.domain.po.UserGroup;

/**   
 * @Title: UserGroupDao.java 
 * @Package cn.fuego.misp.dao 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-22 下午8:44:47 
 * @version V1.0   
 */

public interface UserGroupDao {
	public void create(UserGroup group);

	public void saveOrUpdate(UserGroup group);

	public void delete(UserGroup group);
	
	public List<UserGroup> getAll();
	
	public UserGroup getGroupByID(String groupID);
}
