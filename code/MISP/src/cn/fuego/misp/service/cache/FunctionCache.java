/**   
* @Title: SystemMetaDataCache.java 
* @Package cn.fuego.misp.service.cache 
* @Description: TODO
* @author Tang Jun   
* @date 2014-3-27 上午12:08:45 
* @version V1.0   
*/ 
package cn.fuego.misp.service.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.fuego.misp.dao.DaoContext;
import cn.fuego.misp.domain.po.SystemFunctionSet;
import cn.fuego.misp.web.model.function.FunctionModel;

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
 	private static Map<String,FunctionModel> functionSetCache = new HashMap<String,FunctionModel>();
 
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
	
	public FunctionModel getFunctionByFunctionID(String funcitonID)
	{
		return functionSetCache.get(funcitonID);
	}
	
	public List<FunctionModel> getAllFunction()
	{
		return (List<FunctionModel>) functionSetCache.values();
	}
	 
	
	public void reload()
	{
 		List<SystemFunctionSet> systemFunctionSet = DaoContext.getInstance().getSystemFunctionSetDao().getByFilter(null);
 		
 		for(SystemFunctionSet function : systemFunctionSet)
 		{	
 			FunctionModel functionModel = new  FunctionModel();
 			functionModel.setFunctionID(function.getFunctionID());
 			functionModel.setFunctionName(function.getFunctionName());
 			functionModel.setFunctionType(function.getFunctionType());
 			functionModel.setFunctionDesp(function.getFunctionDesp());
 			functionSetCache.put(function.getFunctionID(), functionModel);
 		}
 		log.info("the function set is " + functionSetCache);
	}
	
	
}
