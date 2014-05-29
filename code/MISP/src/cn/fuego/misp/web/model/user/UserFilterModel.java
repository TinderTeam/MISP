/**   
* @Title: UserFilterModel.java 
* @Package cn.fuego.misp.web.model.user 
* @Description: TODO
* @author Tang Jun   
* @date 2014-5-22 上午12:41:35 
* @version V1.0   
*/ 
package cn.fuego.misp.web.model.user;

import java.util.List;

import cn.fuego.misp.web.model.common.AttributeModel;

/** 
 * @ClassName: UserFilterModel 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-5-22 上午12:41:35 
 *  
 */

public class UserFilterModel
{
	private String userID;
	private List<AttributeModel> attrList;

	
	public String getUserID()
	{
		return userID;
	}

	public void setUserID(String userID)
	{
		this.userID = userID;
	}

	public List<AttributeModel> getAttrList()
	{
		return attrList;
	}

	public void setAttrList(List<AttributeModel> attrList)
	{
		this.attrList = attrList;
	}
	

}
