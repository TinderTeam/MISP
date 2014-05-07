/**   
* @Title: AttributeListBean.java 
* @Package cn.fuego.misp.domain.base 
* @Description: TODO
* @author Tang Jun   
* @date 2014-3-27 上午12:29:54 
* @version V1.0   
*/ 
package cn.fuego.misp.domain.base;

import java.util.ArrayList;
import java.util.List;

/** 
 * @ClassName: AttributeListBean 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-3-27 上午12:29:54 
 *  
 */

public class AttributeListBean
{
	private List<AttributeBean> attrList = new ArrayList<AttributeBean>();

	public List<AttributeBean> getAttrList()
	{
		return attrList;
	}

	public void setAttrList(List<AttributeBean> attrList)
	{
		this.attrList = attrList;
	}
	

}
