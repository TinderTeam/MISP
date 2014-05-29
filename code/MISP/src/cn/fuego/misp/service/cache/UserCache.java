/**   
 * @Title: UserCache.java 
 * @Package cn.fuego.misp.service.cache 
 * @Description: TODO
 * @author Tang Jun   
 * @date 2014-3-14 上午12:55:47 
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
import cn.fuego.misp.domain.base.AttributeBean;
import cn.fuego.misp.domain.po.SystemUser;
import cn.fuego.misp.domain.po.UserExtAttr;
import cn.fuego.misp.service.exception.ServiceException;
import cn.fuego.misp.service.exception.msg.ExceptionMsg;
import cn.fuego.misp.util.validate.ValidatorUtil;
import cn.fuego.misp.web.model.common.AttributeModel;
import cn.fuego.misp.web.model.user.UserFilterModel;
import cn.fuego.misp.web.model.user.UserModel;

/**
 * @ClassName: UserCache
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-3-14 上午12:55:47
 * @Edit: Nan Bowen at 2014-03-23
 * 
 */

public class UserCache
{
	private Log log = LogFactory.getLog(UserCache.class);
	private static UserCache instance;
	private Map<String, UserModel> cache;

	private UserCache()
	{
		this.reload();
	}

	public static synchronized UserCache getInstance()
	{
		if (null == instance)
		{
			instance = new UserCache();
		}
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.fuego.misp.service.cache.BasicCache#reload()
	 */

	public void reload()
	{
		cache = new HashMap<String, UserModel>();
		List<SystemUser> userList = DaoContext.getInstance().getSystemUserDao().getByFilter(null, null);
		List<UserExtAttr> extAtrrList = DaoContext.getInstance().getUserExtAttrDao().getByFilter(null,null);
		if (null == userList)
		{
			log.error("No users in Database.");
			throw new ServiceException(ExceptionMsg.USERCACHE_LOAD_ERR);
		}
		for (SystemUser basicUser : userList)
		{
			UserModel user = new UserModel();
			user.setUserID(basicUser.getUserID());
			user.setPassword(basicUser.getPassword());
			user.setAttrList((getUserAttrByUserID(basicUser.getUserID(), extAtrrList)));
			cache.put(user.getUserID(), user);
		}
	}
	
	public List<UserModel> getUserListByFilter(UserFilterModel userFilter)
	{
		List<UserModel> userModelList = new ArrayList<UserModel>();
		if(null == userFilter)
		{
			log.info("the filter is null");;
			userModelList = new ArrayList<UserModel>(this.cache.values());
			return userModelList;
		}
		
 
		List<SystemUser> basicUserList;
		SystemUser basicFilter = new SystemUser();
		if(!ValidatorUtil.isEmpty(userFilter.getUserID()))
		{ 
			basicFilter.setUserID(userFilter.getUserID());
		}
		basicUserList = DaoContext.getInstance().getSystemUserDao().getByFilter(basicFilter);

		if(ValidatorUtil.isEmpty(basicUserList))
		{
           return userModelList;
		}
		
		Set<String> userIDSet = new HashSet<String>();
		for(SystemUser basicUser : basicUserList)
		{
			userIDSet.add(basicUser.getUserID());
		}
		if(!ValidatorUtil.isEmpty(userFilter.getAttrList()))
		{
			for(AttributeModel attr : userFilter.getAttrList())
			{
				if(!ValidatorUtil.isEmpty(userIDSet))
				{
					userIDSet = getUserIDByExtAttr(userIDSet, attr);
				}
			}
		}

		return this.getUserByUserID(userIDSet);
	}

	private Set<String> getUserIDByExtAttr(Set<String> userIDSet, AttributeModel attr)
	{
		List<UserExtAttr> extAttrList = null;

		if(!ValidatorUtil.isEmpty(attr.getAttrValue()))
		{
		
			AttributeBean attrBean = new AttributeBean(); 
			extAttrList = DaoContext.getInstance().getUserExtAttrDao().getByFilter(userIDSet, attrBean);
		}
 		userIDSet = new HashSet<String>();
		if(!ValidatorUtil.isEmpty(extAttrList))
		{
			for(UserExtAttr basicUser : extAttrList)
			{
				userIDSet.add(basicUser.getUserID());
			}
		}

 		return  userIDSet;
	}

	public UserModel getUserByUserID(String id)
	{
		return cache.get(id);
	}
	
	public List<UserModel> getUserByUserID(Set<String> idSet)
	{
		List<UserModel> userModelList = new ArrayList<UserModel>();

		if(!ValidatorUtil.isEmpty(idSet))
		{
			for(String userID : idSet)
			{
				userModelList.add(cache.get(userID));
			}
		}

		return userModelList;
	}
 
	private List<AttributeModel> getUserAttrByUserID(String userID, List<UserExtAttr> attrList)
	{
		List<AttributeModel> attrModelList = new ArrayList<AttributeModel>();

		if (null != attrList)
		{
			for (UserExtAttr extAttr : attrList)
			{
				if (userID.equals(extAttr.getUserID()))
				{
					AttributeModel attrBean = new AttributeModel();
					attrModelList.add(attrBean);
				}
			}

		} else
		{
			log.warn("there is no extend attribute for user " + userID);
		}

		return attrModelList;
	}

}
