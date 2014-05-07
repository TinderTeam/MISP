/**   
 * @Title: UserCache.java 
 * @Package cn.fuego.misp.service.cache 
 * @Description: TODO
 * @author Tang Jun   
 * @date 2014-3-14 上午12:55:47 
 * @version V1.0   
 */
package cn.fuego.misp.service.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.fuego.misp.dao.DaoContext;
import cn.fuego.misp.domain.po.SystemUser;
import cn.fuego.misp.domain.po.UserExtAttr;
import cn.fuego.misp.service.exception.ServiceException;
import cn.fuego.misp.service.exception.msg.ExceptionMsg;
import cn.fuego.misp.web.model.common.AttributeListModel;
import cn.fuego.misp.web.model.common.AttributeModel;
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
		List<UserExtAttr> extAtrrList = DaoContext.getInstance().getUserExtAttrDao().getByFilter(null);
		if (null == userList)
		{
			log.error("No users in Database.");
			throw new ServiceException(ExceptionMsg.USERCACHE_LOAD_ERR);
		}
		for (SystemUser basicUser : userList)
		{
			UserModel user = new UserModel();
			user.setUserID(basicUser.getUserID());
			user.setUserName(basicUser.getUserName());
			user.setPassword(basicUser.getPassword());
			user.setAttrValueList(getUserAttrByUserID(basicUser.getUserID(), extAtrrList));
			cache.put(user.getUserID(), user);
		}
	}

	public UserModel getUserByUserID(String id)
	{
		return cache.get(id);
	}

	private AttributeListModel getUserAttrByUserID(String userID, List<UserExtAttr> attrList)
	{
		AttributeListModel attrListBean = new AttributeListModel();

		if (null != attrList)
		{
			for (UserExtAttr extAttr : attrList)
			{
				if (userID.equals(extAttr.getUserID()))
				{
					AttributeModel attrBean = new AttributeModel();
					attrListBean.getAttrList().add(attrBean);
				}
			}

		} else
		{
			log.warn("there is no extend attribute for user " + userID);
		}

		return attrListBean;
	}

}
