/**   
* @Title: AttributeModel.java 
* @Package cn.fuego.misp.web.model.common 
* @Description: TODO
* @author Tang Jun   
* @date 2014-3-27 下午11:30:03 
* @version V1.0   
*/ 
package cn.fuego.misp.web.model.common;

/** 
 * @ClassName: AttributeModel 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-3-27 下午11:30:03 
 *  
 */

public class AttributeModel
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
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attrName == null) ? 0 : attrName.hashCode());
		result = prime * result + ((attrValue == null) ? 0 : attrValue.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttributeModel other = (AttributeModel) obj;
		if (attrName == null)
		{
			if (other.attrName != null)
				return false;
		} else if (!attrName.equals(other.attrName))
			return false;
		if (attrValue == null)
		{
			if (other.attrValue != null)
				return false;
		} else if (!attrValue.equals(other.attrValue))
			return false;
		return true;
	}
	
	
}
