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
import cn.fuego.misp.domain.po.SystemFunctionSet;
import cn.fuego.misp.domain.po.UserGroupMapFunction;
import cn.fuego.misp.util.validate.ValidatorUtil;

/** 
 * @ClassName: SystemMetaDataCache 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-3-27 上午12:08:45 
 *  
 */

public class FunctionCache
{
	private Log log = LogFactory.getLog(FunctionCache.class);
 	private static FunctionCache instance;
 	private static List<SystemFunctionSet> functionSetCache = new ArrayList<SystemFunctionSet>();
	private Map<Integer,List<Integer>> functionControlCache = new HashMap<Integer,List<Integer>>();

	private FunctionCache()
	{
 
	}
	
	public static synchronized FunctionCache getInstance()
	{
		if (null == instance)
		{
			instance = new FunctionCache();
		}
		return instance;
	}
	
	/**
	 * get function id by user group id 
	 * @param groupID
	 * @return
	 */
	public List<Integer> getFunctionIDListByGroupID(int groupID)
	{
		List<Integer> functionIDList = this.functionControlCache.get(groupID);
		if(null == functionIDList)
		{
			log.info("loading meta data of table " + groupID);

			List<UserGroupMapFunction> groupMapFunList = DaoContext.getInstance().getUserGroupMapFunctionDao().getByGroupID(groupID);
			if(!ValidatorUtil.isEmpty(groupMapFunList))
			{
				functionIDList = new ArrayList<Integer>();
				for(UserGroupMapFunction groupMapFun : groupMapFunList)
				{
					functionIDList.add(groupMapFun.getFunctionID());
				}
				this.functionControlCache.put(groupID, functionIDList);

				log.info(functionIDList);
			}
			else
			{
				log.warn("there is no function for the user group id " + groupID);
			}

		}
		
		return functionIDList;
	}
	
	public void reload()
	{
		functionControlCache.clear();
		functionSetCache = DaoContext.getInstance().getSystemFunctionSetDao().getByFilter(null);
		
		if(!ValidatorUtil.isEmpty(functionSetCache))
		{
			log.info("all the function set size is ");
		}
		else
		{
			log.warn("there is no funciton set");
		}

		log.info("clear all cache,then it will reload the cache");
	}
	
	
}
