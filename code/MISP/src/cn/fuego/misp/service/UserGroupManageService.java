/**   
* @Title: UserGroupManage.java 
* @Package cn.fuego.misp.service 
* @Description: TODO
* @author Tang Jun   
* @date 2014-6-18 下午09:53:48 
* @version V1.0   
*/ 
package cn.fuego.misp.service;

import java.util.List;

import cn.fuego.misp.web.model.function.FunctionModel;
import cn.fuego.misp.web.model.group.UserGroupModel;

/** 
 * @ClassName: UserGroupManage 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-6-18 下午09:53:48 
 *  
 */

public interface UserGroupManageService
{
	public void delete(String groupID);
	public void modify(UserGroupModel userGroupModel);
	public void create(UserGroupModel userGroupModel);
	public List<UserGroupModel> getAll();
	public UserGroupModel getGroupByID(String groupID);
	
	public List<FunctionModel>  getAllFunction();
	
	public void deleteMember(String groupID,String userID);
	public void addMember(String groupID, List<String> userIDList);
	public void modifyFunction(String groupID,  List<String> functionIDList);

}
