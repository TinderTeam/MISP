/**   
* @Title: UserGroupManageImpl.java 
* @Package cn.fuego.misp.service.impl.user 
* @Description: TODO
* @author Tang Jun   
* @date 2014-6-18 下午10:41:44 
* @version V1.0   
*/ 
package cn.fuego.misp.service.impl.user;

import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import cn.fuego.misp.service.cache.FunctionCache;
import cn.fuego.misp.service.cache.SystemMenuCache;
import cn.fuego.misp.service.cache.UserCache;
import cn.fuego.misp.service.cache.UserGroupBatchData;
import cn.fuego.misp.service.exception.ServiceException;
import cn.fuego.misp.service.exception.msg.ExceptionMsg;
import cn.fuego.misp.util.validate.ValidatorUtil;
import cn.fuego.misp.web.model.function.FunctionModel;
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
	private Log log = LogFactory.getLog(UserGroupManageServiceImpl.class);

	private UserGroupDao userGroupDao = DaoContext.getInstance().getUserGroupDao();
	private UserMapGroupDao userMapGroupDao = DaoContext.getInstance().getUserMapGroupDao();
	private UserGroupMapFunctionDao groupMapFunctionDao = DaoContext.getInstance().getUserGroupMapFunctionDao();

	/* (non-Javadoc)
	 * @see cn.fuego.misp.service.UserGroupManageService#delete(java.lang.String)
	 */
	@Override
	public void delete(String groupID)
	{
		this.userGroupDao.delete(groupID);
		this.userMapGroupDao.deleteByGroupID(groupID);
		this.groupMapFunctionDao.deleteByGroupID(groupID);
		
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
		userGroupModel.setGroupID(IDList.get(0));
		userGroup.setGroupID(IDList.get(0));
		if(ValidatorUtil.isEmpty(userGroupModel.getGroupName()))
		{
			log.error("the user group name is empty");
			throw new ServiceException(ExceptionMsg.USER_GROUP_NAME_EMPTY);
		}
		userGroup.setGroupName(userGroupModel.getGroupName());
		userGroup.setGroupDesp(userGroupModel.getGroupDesp());
		
		log.info("create new user group. " + userGroup);

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
		UserGroupModel groupModel;
		Set<String> functionSet = new HashSet<String>();
		if(ValidatorUtil.isEmpty(groupID))
		{
		    groupModel = new UserGroupModel();
		}
		else
		{
            groupModel = convertGroupToGroupUserModel(userGroupDao.getGroupByID(groupID));
 
	 		//update group user list
	 		List<UserMapGroup> userMapGroupList = userMapGroupDao.getByGroupID(groupID);
	 		Set<String> userIDSet = new HashSet<String>();
	 		for(UserMapGroup map : userMapGroupList)
			{
	 			userIDSet.add(map.getUserID());
			}
	 		groupModel.setUserList(UserCache.getInstance().getUserByUserID(userIDSet));
	 		
	 		
	 		//update group user list
	 		List<UserGroupMapFunction> userGroupMapFunctionList = groupMapFunctionDao.getByGroupID(groupID);
	 		
	 		for(UserGroupMapFunction map : userGroupMapFunctionList)
			{
	 			functionSet.add(map.getFunctionID());
			}
		}
 
 		groupModel.setMenuTreeList(SystemMenuCache.getInstance().getAllByFunctionIDList(functionSet));;
 		
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

	/* (non-Javadoc)
	 * @see cn.fuego.misp.service.UserGroupManageService#getAllFunction()
	 */
	@Override
	public List<FunctionModel> getAllFunction()
	{
		
		return FunctionCache.getInstance().getAllFunction();
	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.service.UserGroupManageService#deleteMember(java.lang.String, java.lang.String)
	 */
	@Override
	public void deleteMember(String groupID, String userID)
	{
		UserMapGroup map = new UserMapGroup();
		map.setGroupID(groupID);
		map.setUserID(userID);
		this.userMapGroupDao.delete(map);
	}
	@Override
	public void addMember(String groupID,  List<String> userIDList)
	{ 
 		
		List<UserMapGroup> existMapList = this.userMapGroupDao.getByGroupID(groupID);
		List<UserMapGroup> newMapList = new ArrayList<UserMapGroup>();
		for(String userID : userIDList)
		{
			UserMapGroup map = new UserMapGroup();
			map.setGroupID(groupID);
			map.setUserID(userID);
			if(!existMapList.contains(map))
			{
	 			newMapList.add(map);
			}
		}
		
		this.userMapGroupDao.create(newMapList);
 
	}
	
	@Override
	public void modifyFunction(String groupID,  List<String> functionIDList)
	{ 
 		List<String> allFunctionIDList = SystemMenuCache.getInstance().getAllMenuFunctionIDList();
 		
		List<UserGroupMapFunction> existMapList = new  ArrayList<UserGroupMapFunction>();
		for(String id : allFunctionIDList)
		{	
			UserGroupMapFunction map = new UserGroupMapFunction();
			map.setGroupID(groupID);
			map.setFunctionID(id);
			existMapList.add(map);
		}
 
		this.groupMapFunctionDao.delete(existMapList);
		
		List<UserGroupMapFunction> newMapList = new ArrayList<UserGroupMapFunction>();
		for(String functionID : functionIDList)
		{
			UserGroupMapFunction map = new UserGroupMapFunction();
			map.setGroupID(groupID);
			map.setFunctionID(functionID);
			newMapList.add(map);
		}
		
		this.groupMapFunctionDao.create(newMapList);
 
	}

}
