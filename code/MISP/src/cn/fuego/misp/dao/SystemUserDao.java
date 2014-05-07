/**   
* @Title: SystemUserDao.java 
* @Package cn.fuego.misp.dao 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-21 下午10:59:52 
* @version V1.0   
*/ 
package cn.fuego.misp.dao;

import java.util.List;


import cn.fuego.misp.domain.po.SystemUser;
import cn.fuego.misp.web.model.user.UserModel;

/**   
 * @Title: SystemUserDao.java 
 * @Package cn.fuego.misp.dao 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-21 下午10:59:52 
 * @version V1.0   
 */

public interface SystemUserDao {

	public void create(SystemUser user);

	public void saveOrUpdate(SystemUser user);

	public void delete(SystemUser user);
	
	/**
	 * when filter is null, return all users
	 * @param userIDList
	 * @param userNameList
	 * @return
	 */
	public List<SystemUser>	 getByFilter(List<String> userIDList,List<String> userNameList);
	
  
}
