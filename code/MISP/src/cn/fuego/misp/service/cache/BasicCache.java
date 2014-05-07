/**   
* @Title: BasicCache.java 
* @Package cn.fuego.misp.service.cache 
* @Description: TODO
* @author Tang Jun   
* @date 2014-2-28 下午11:18:45 
* @version V1.0   
*/ 
package cn.fuego.misp.service.cache;

import java.util.List;

/** 
 * @ClassName: BasicCache 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-2-28 下午11:18:45 
 *  
 */

public abstract class BasicCache
{
    List<Object> cacheList = null;

	public abstract void reload();
	
	public List<Object> getAllCache()
	{
		return cacheList;
	}

}
