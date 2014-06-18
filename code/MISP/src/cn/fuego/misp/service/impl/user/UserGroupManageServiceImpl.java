/**   
* @Title: UserGroupManageImpl.java 
* @Package cn.fuego.misp.service.impl.user 
* @Description: TODO
* @author Tang Jun   
* @date 2014-6-18 下午10:41:44 
* @version V1.0   
*/ 
package cn.fuego.misp.service.impl.user;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.fuego.misp.dao.DaoContext;
import cn.fuego.misp.dao.UserGroupDao;
import cn.fuego.misp.domain.po.UserGroup;
import cn.fuego.misp.domain.po.UserMapGroup;
import cn.fuego.misp.service.UserGroupManageService;
import cn.fuego.misp.service.cache.UserCache;
import cn.fuego.misp.web.model.group.UserGroupModel;

/** 
 * @ClassName: UserGroupManageImpl 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-6-18 下午10:41:44 
 *  
 */

public class UserGroupManageServiceImpl implements UserGroupManageService
{

	private UserGroupDao userGroupDao = DaoContext.getInstance().getUserGroupDao();
	/* (non-Javadoc)
	 * @see cn.fuego.misp.service.UserGroupManageService#delete(java.lang.String)
	 */
	@Override
	public void delete(String groupID)
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.service.UserGroupManageService#modify(cn.fuego.misp.web.model.user.UserGroupModel)
	 */
	@Override
	public void modify(UserGroupModel userGroupModel)
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.service.UserGroupManageService#create(cn.fuego.misp.web.model.user.UserGroupModel)
	 */
	@Override
	public void create(UserGroupModel userGroupModel)
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.service.UserGroupManageService#getAll()
	 */
	@Override
	public List<UserGroupModel> getAll()
	{
		
		return null;
	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.service.UserGroupManageService#getGroupByID(java.lang.String)
	 */
	@Override
	public UserGroupModel getGroupByID(String groupID)
	{
 		UserGroupModel groupModel = convertGroupToGroupUserModel(userGroupDao.getGroupByID(groupID));
		
 		List<UserMapGroup> userMapGroupList = DaoContext.getInstance().getUserMapGroupDao().getByGroupID(groupID);
		
 		//update group user list
 		Set<String> userIDSet = new HashSet<String>();
 		for(UserMapGroup map : userMapGroupList)
		{
 			userIDSet.add(map.getUserID());
		}
 		
 		groupModel.setUserList(UserCache.getInstance().getUserByUserID(userIDSet));
 		
 		return groupModel;
	}
	
	private UserGroupModel convertGroupToGroupUserModel(UserGroup userGroup)
	{
		UserGroupModel groupModel = new UserGroupModel();
		
		groupModel.setGroupID(userGroup.getGroupID());
		groupModel.setGroupName(userGroup.getGroupName());
		groupModel.setGroupDesp(userGroup.getGroupDesp());
		
		return groupModel;
	}

}
