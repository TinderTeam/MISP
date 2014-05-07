/**   
* @Title: UserGroupMapFunctionDao.java 
* @Package cn.fuego.misp.dao 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-23 上午12:22:53 
* @version V1.0   
*/ 
package cn.fuego.misp.dao;

import java.util.List;

import cn.fuego.misp.domain.po.UserGroupMapFunction;

/**   
 * @Title: UserGroupMapFunctionDao.java 
 * @Package cn.fuego.misp.dao 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-23 上午12:22:53 
 * @version V1.0   
 */

public interface UserGroupMapFunctionDao {

	public void create(UserGroupMapFunction usermap);

	public void saveOrUpdate(UserGroupMapFunction usermap);

	public void delete(UserGroupMapFunction usermap);
	public List<UserGroupMapFunction> getByGroupID(int groupID);

}
