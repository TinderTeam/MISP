/**   
* @Title: UserExtAttrDao.java 
* @Package cn.fuego.misp.dao 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-22 上午12:26:46 
* @version V1.0   
*/ 
package cn.fuego.misp.dao;

import java.util.List;
import java.util.Set;

import cn.fuego.misp.domain.base.AttributeBean;
import cn.fuego.misp.domain.po.UserExtAttr;

/**   
 * @Title: UserExtAttrDao.java 
 * @Package cn.fuego.misp.dao 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-22 上午12:26:46 
 * @version V1.0   
 */

public interface UserExtAttrDao 
{

	public void create(UserExtAttr attr);

	public void saveOrUpdate(UserExtAttr attr);

	public void delete(UserExtAttr attr);
	
	public List<UserExtAttr> getByFilter(Set<String> userIDList,AttributeBean attr);
	
}
