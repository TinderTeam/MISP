/**   
* @Title: UserMapGroupDao.java 
* @Package cn.fuego.misp.dao 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-22 下午11:12:37 
* @version V1.0   
*/ 
package cn.fuego.misp.dao;

import cn.fuego.misp.domain.po.UserMapGroup;

/**   
 * @Title: UserMapGroupDao.java 
 * @Package cn.fuego.misp.dao 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-22 下午11:12:37 
 * @version V1.0   
 */

public interface UserMapGroupDao {
	public void create(UserMapGroup map);

	public void saveOrUpdate(UserMapGroup map);

	public void delete(UserMapGroup map);
}
