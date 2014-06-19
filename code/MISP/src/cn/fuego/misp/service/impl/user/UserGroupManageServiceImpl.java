/**   
* @Title: UserGroupManageImpl.java 
* @Package cn.fuego.misp.service.impl.user 
* @Description: TODO
* @author Tang Jun   
* @date 2014-6-18 下午10:41:44 
* @version V1.0   
*/ 
package cn.fuego.misp.service.impl.user;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.fuego.misp.dao.DaoContext;
import cn.fuego.misp.dao.UserGroupDao;
import cn.fuego.misp.dao.UserGroupMapFunctionDao;
import cn.fuego.misp.dao.UserMapGroupDao;
import cn.fuego.misp.domain.po.UserGroup;
import cn.fuego.misp.domain.po.UserGroupMapFunction;
import cn.fuego.misp.domain.po.UserMapGroup;
import cn.fuego.misp.service.IDCreateService;
import cn.fuego.misp.service.ServiceContext;
import cn.fuego.misp.service.UserGroupManageService;
import cn.fuego.misp.service.cache.UserCache;
import cn.fuego.misp.service.cache.UserGroupBatchData;
import cn.fuego.misp.web.model.group.UserGroupModel;
import cn.fuego.misp.web.model.user.UserModel;

/** 
 * @ClassName: UserGroupManageImpl 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-6-18 下午10:41:44 
 *  
 */

public class UserGroupManageServiceImpl implements UserGroupManageService
{
	private Log log = LogFactory.getLog(UserGroupManageServiceImpl.class);

	private UserGroupDao userGroupDao = DaoContext.getInstance().getUserGroupDao();
	private UserMapGroupDao userMapGroupDao = DaoContext.getInstance().getUserMapGroupDao();
	private UserGroupMapFunctionDao userMapFunctionDao = DaoContext.getInstance().getUserGroupMapFunctionDao();

	/* (non-Javadoc)
	 * @see cn.fuego.misp.service.UserGroupManageService#delete(java.lang.String)
	 */
	@Override
	public void delete(String groupID)
	{
		this.userGroupDao.delete(groupID);
		this.userMapGroupDao.deleteByGroupID(groupID);
		this.userMapFunctionDao.deleteByGroupID(groupID);
		
	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.service.UserGroupManageService#modify(cn.fuego.misp.web.model.user.UserGroupModel)
	 */
	@Override
	public void modify(UserGroupModel userGroupModel)
	{
		UserGroup userGroup = this.userGroupDao.getGroupByID(userGroupModel.getGroupID());

		userGroup.setGroupName(userGroupModel.getGroupName());
		userGroup.setGroupDesp(userGroupModel.getGroupDesp());
		userGroupDao.saveOrUpdate(userGroup);
	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.service.UserGroupManageService#create(cn.fuego.misp.web.model.user.UserGroupModel)
	 */
	@Override
	public void create(UserGroupModel userGroupModel)
	{
		List<String> IDList = ServiceContext.getInstance().getIDCreateService(IDCreateService.USER_GROUP_ID_NAME).createIDList(1);
		UserGroup userGroup = new UserGroup();
		userGroup.setGroupID(IDList.get(0));
		userGroup.setGroupName(userGroupModel.getGroupName());
		userGroup.setGroupDesp(userGroupModel.getGroupDesp());
		this.userGroupDao.create(userGroup);
	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.service.UserGroupManageService#getAll()
	 */
	@Override
	public List<UserGroupModel> getAll()
	{
		List<UserGroup> userGroupList = userGroupDao.getAll();
		
		List<UserGroupModel> userGroupModelList = new ArrayList<UserGroupModel>(); 
		
 		for(UserGroup userGroup : userGroupList)
		{	
			UserGroupModel groupUser = convertGroupToGroupUserModel(userGroup);
			groupUser.setUserList(UserGroupBatchData.getGroupIDMapUserModel().get(groupUser.getGroupID()));
			groupUser.setFunctionList(UserGroupBatchData.getGroupIDMapFunctionModel().get(groupUser.getGroupID()));
			userGroupModelList.add(groupUser);
		}
		
		return userGroupModelList;
	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.service.UserGroupManageService#getGroupByID(java.lang.String)
	 */
	@Override
	public UserGroupModel getGroupByID(String groupID)
	{
 		UserGroupModel groupModel = convertGroupToGroupUserModel(userGroupDao.getGroupByID(groupID));
		
 		
 		userMapFunctionDao.getByGroupID(groupID);
		
 		//update group user list
 		List<UserMapGroup> userMapGroupList = userMapGroupDao.getByGroupID(groupID);
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
