/**   
* @Title: TableAction.java 
* @Package cn.fuego.misp.web.action.basic 
* @Description: TODO
* @author Tang Jun   
* @date 2014-6-16 下午11:23:14 
* @version V1.0   
*/ 
package cn.fuego.misp.web.action.basic;

import com.opensymphony.xwork2.ActionSupport;

/** 
 * @ClassName: TableAction 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-6-16 下午11:23:14 
 *  
 */

public class TableAction extends ActionSupport
{
	private String selectedID;
	private String[] selectedIDList;
	private String operateType;

	
	public String getOperateType()
	{
		return operateType;
	}

	public void setOperateType(String operateType)
	{
		this.operateType = operateType;
	}

	public String[] getSelectedIDList()
	{
		return selectedIDList;
	}

	public void setSelectedIDList(String[] selectedIDList)
	{
		this.selectedIDList = selectedIDList;
	}

	public String getSelectedID()
	{
		return selectedID;
	}

	public void setSelectedID(String selectedID)
	{
		this.selectedID = selectedID;
	}
	

}
