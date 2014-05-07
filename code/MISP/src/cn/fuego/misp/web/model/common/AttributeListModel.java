/**   
* @Title: AttributeListModel.java 
* @Package cn.fuego.misp.web.model.common 
* @Description: TODO
* @author Tang Jun   
* @date 2014-3-27 下午11:30:41 
* @version V1.0   
*/ 
package cn.fuego.misp.web.model.common;

import java.util.ArrayList;
import java.util.List;

/** 
 * @ClassName: AttributeListModel 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-3-27 下午11:30:41 
 *  
 */

public class AttributeListModel
{
	private List<AttributeModel> attrList = new ArrayList<AttributeModel>();

	public List<AttributeModel> getAttrList()
	{
		return attrList;
	}

	public void setAttrList(List<AttributeModel> attrList)
	{
		this.attrList = attrList;
	}

}
