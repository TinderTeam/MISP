/**   
* @Title: SystemMetaDataCache.java 
* @Package cn.fuego.misp.service.cache 
* @Description: TODO
* @author Tang Jun   
* @date 2014-3-27 上午12:08:45 
* @version V1.0   
*/ 
package cn.fuego.misp.service.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.fuego.misp.dao.DaoContext;
import cn.fuego.misp.domain.po.SystemMetaData;

/** 
 * @ClassName: SystemMetaDataCache 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-3-27 上午12:08:45 
 *  
 */

public class SystemMetaDataCache
{
	private Log log = LogFactory.getLog(SystemMetaDataCache.class);
	public static String USER_TABLE = "D_USER_EXT_ATTR";
	
	public static int IS_DISPLAY = 1;
	public static int IS_Filter = 1;
	private static SystemMetaDataCache instance;
	private Map<String,List<SystemMetaData>> cache = new HashMap<String,List<SystemMetaData>>();

	private SystemMetaDataCache()
	{
 
	}
	
	public static synchronized SystemMetaDataCache getInstance()
	{
		if (null == instance)
		{
			instance = new SystemMetaDataCache();
		}
		return instance;
	}
	
 
	private List<SystemMetaData> getMetaDataByTableName(String tableName)
	{
		List<SystemMetaData> metaDataList = this.cache.get(tableName);
		if(null == metaDataList)
		{
			metaDataList = DaoContext.getInstance().getSystemMetaDataDao().getMetaDataByTableName(tableName);
			this.cache.put(tableName, metaDataList);
			log.info("loading meta data of table " + tableName);
			log.info(metaDataList);
		}
		
		return metaDataList;
	}
	public List<String> getDisplayAttrNameList(String tableName)
	{
		List<String> extAttrNameList = new ArrayList<String>();
		List<SystemMetaData> metaDataList = this.getMetaDataByTableName(tableName);
		for(SystemMetaData metaData : metaDataList)
		{
			if(metaData.getIsDisplay() == SystemMetaDataCache.IS_Filter)
			{	
				extAttrNameList.add(metaData.getAttrName());
			}
		}
		
		return extAttrNameList;
	}
	public List<String> getFilterAttrNameList(String tableName)
	{
		List<String> extAttrNameList = new ArrayList<String>();
		List<SystemMetaData> metaDataList = this.getMetaDataByTableName(tableName);
		for(SystemMetaData metaData : metaDataList)
		{
			if(metaData.getIsFilter() == SystemMetaDataCache.IS_DISPLAY)
			{	
				extAttrNameList.add(metaData.getAttrName());
			}
		}
		
		return extAttrNameList;
	}
	public void reload()
	{
		cache.clear();
		log.info("clear all the meta data,then it will reload the cache");
	}
	
	
}
