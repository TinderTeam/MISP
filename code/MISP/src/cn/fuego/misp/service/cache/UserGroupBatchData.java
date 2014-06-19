/**   
* @Title: UserGroupBatchData.java 
* @Package cn.fuego.misp.service.cache 
* @Description: TODO
* @author Tang Jun   
* @date 2014-6-19 上午10:44:53 
* @version V1.0   
*/ 
package cn.fuego.misp.service.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.fuego.misp.dao.DaoContext;
import cn.fuego.misp.domain.po.UserGroupMapFunction;
import cn.fuego.misp.domain.po.UserMapGroup;
import cn.fuego.misp.web.model.function.FunctionModel;
import cn.fuego.misp.web.model.user.UserModel;

/** 
 * @ClassName: UserGroupBatchData 
 * @Description: batch operate for large data
 * @author Tang Jun
 * @date 2014-6-19 上午10:44:53 
 *  
 */

public class UserGroupBatchData
{
	private static Log log = LogFactory.getLog(UserGroupBatchData.class);

 
	//batch operate for large data
	public static Map<String,List<UserModel>>  getGroupIDMapUserModel()
	{
		Map<String,List<UserModel>>  groupIDMapUser = new HashMap<String,List<UserModel>> ();
 		List<UserMapGroup> userMapGroupList =  DaoContext.getInstance().getUserMapGroupDao().getAll();
 		log.info("all user group count is " + userMapGroupList.size());
		for(UserMapGroup map : userMapGroupList)
		{
			List<UserModel> userList = groupIDMapUser.get(map.getGroupID());
			if(null == userList)
			{
				userList = new ArrayList<UserModel>();
			}
			userList.add(UserCache.getInstance().getUserByUserID(map.getUserID()));
			groupIDMapUser.put(map.getGroupID(),userList);
 
		}
		
		return groupIDMapUser;
	}
	//batch operate for large data
	public static Map<String,List<FunctionModel>>  getGroupIDMapFunctionModel()
	{
		Map<String,List<FunctionModel>>  groupIDMapFunction = new HashMap<String,List<FunctionModel>> ();
 		List<UserGroupMapFunction> userMapGroupList =  DaoContext.getInstance().getUserGroupMapFunctionDao().getAll();
 		log.info("all user group map function count is " + userMapGroupList.size());
		for(UserGroupMapFunction map : userMapGroupList)
		{
			List<FunctionModel> userList = groupIDMapFunction.get(map.getGroupID());
			if(null == userList)
			{
				userList = new ArrayList<FunctionModel>();
			}
			userList.add(FunctionCache.getInstance().getFunctionByFunctionID(map.getFunctionID()));
			groupIDMapFunction.put(map.getGroupID(),userList);
 
		}
		
		return groupIDMapFunction;
	}
	
	
	public static List<UserModel> getUserListByGroupID(String groupID)
	{
		//update group user list
		List<UserModel> functionList = new ArrayList<UserModel>();
 		List<UserMapGroup> userMapGroupList =  DaoContext.getInstance().getUserMapGroupDao().getByGroupID(groupID);
  		for(UserMapGroup map : userMapGroupList)
		{
  			functionList.add(UserCache.getInstance().getUserByUserID(map.getUserID()));
		}
  		return functionList;
 	}
	public static List<FunctionModel> getFunctionListByGroupID(String groupID)
	{
		//update group user list
		List<FunctionModel> functionList = new ArrayList<FunctionModel>();
 		List<UserGroupMapFunction> userMapGroupList =  DaoContext.getInstance().getUserGroupMapFunctionDao().getByGroupID(groupID);
  		for(UserGroupMapFunction map : userMapGroupList)
		{
  			functionList.add(FunctionCache.getInstance().getFunctionByFunctionID(map.getFunctionID()));
		}
  		return functionList;
 	}
}
