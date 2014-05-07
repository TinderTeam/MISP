/**   
* @Title: AttributeBean.java 
* @Package cn.fuego.misp.domain.base 
* @Description: TODO
* @author Tang Jun   
* @date 2014-3-27 上午12:28:42 
* @version V1.0   
*/ 
package cn.fuego.misp.domain.base;

/** 
 * @ClassName: AttributeBean 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-3-27 上午12:28:42 
 *  
 */

public class AttributeBean
{
	private String attrName;
	private String attrValue;
	public String getAttrName()
	{
		return attrName;
	}
	public void setAttrName(String attrName)
	{
		this.attrName = attrName;
	}
	public String getAttrValue()
	{
		return attrValue;
	}
	public void setAttrValue(String attrValue)
	{
		this.attrValue = attrValue;
	}
	@Override
	public String toString()
	{
		return "AttributeBean [attrName=" + attrName + ", attrValue="
				+ attrValue + "]";
	}
	
}
