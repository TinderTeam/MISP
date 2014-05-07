/**   
* @Title: SystemMetaDataDao.java 
* @Package cn.fuego.misp.dao 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-22 下午8:10:37 
* @version V1.0   
*/ 
package cn.fuego.misp.dao;

import java.util.List;

import cn.fuego.misp.domain.po.SystemMetaData;

/**   
 * @Title: SystemMetaDataDao.java 
 * @Package cn.fuego.misp.dao 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-22 下午8:10:37 
 * @version V1.0   
 */

public interface SystemMetaDataDao {
	public void create(SystemMetaData meta);

	public void saveOrUpdate(SystemMetaData meta);

	public void delete(SystemMetaData meta);
	
	public List<SystemMetaData> getMetaDataByTableName(String tableName);
}
