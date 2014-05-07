/**   
* @Title: SystemFunctionSetDao.java 
* @Package cn.fuego.misp.dao 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-22 下午11:53:42 
* @version V1.0   
*/ 
package cn.fuego.misp.dao;

import java.util.List;

import cn.fuego.misp.domain.po.SystemFunctionSet;

/**   
 * @Title: SystemFunctionSetDao.java 
 * @Package cn.fuego.misp.dao 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-22 下午11:53:42 
 * @version V1.0   
 */

public interface SystemFunctionSetDao {
	public void create(SystemFunctionSet function);

	public void saveOrUpdate(SystemFunctionSet function);

	public void delete(SystemFunctionSet function);
	
	public List<SystemFunctionSet> getByFilter(SystemFunctionSet functionSet);
}
