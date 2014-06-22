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
	
	public void delete(List<String> userIDList);
	
	/**
	 * when filter is null, return all users
	 * @param userIDList
	 * @param userNameList
	 * @return
	 */
	public SystemUser	 getByUserID(String userID);

	public List<SystemUser>	 getByUserIDList(List<String> userIDList);
	public List<SystemUser>	 getByFilter(SystemUser filter);

	
  
}
