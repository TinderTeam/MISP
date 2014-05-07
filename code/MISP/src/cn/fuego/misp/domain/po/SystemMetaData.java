/**   
* @Title: SystemMetaData.java 
* @Package cn.fuego.misp.domain.po 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-22 下午7:54:20 
* @version V1.0   
*/ 
package cn.fuego.misp.domain.po;

import java.io.Serializable;

/**   
 * @Title: SystemMetaData.java 
 * @Package cn.fuego.misp.domain.po 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-22 下午7:54:20 
 * @version V1.0   
 */

public class SystemMetaData implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tableName;
	private String attrName;
	private String attrDefaultValue;
	private int isDisplay;
	private int isFilter;
	private int sortOrder;
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getAttrName() {
		return attrName;
	}
	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}
	public String getAttrDefaultValue() {
		return attrDefaultValue;
	}
	public void setAttrDefaultValue(String attrDefaultValue) {
		this.attrDefaultValue = attrDefaultValue;
	}
	public int getIsDisplay() {
		return isDisplay;
	}
	public void setIsDisplay(int isDisplay) {
		this.isDisplay = isDisplay;
	}
	public int getIsFilter() {
		return isFilter;
	}
	public void setIsFilter(int isFilter) {
		this.isFilter = isFilter;
	}
	public int getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "SystemMetaData [tableName=" + tableName + ", attrName="
				+ attrName + ", attrDefaultValue=" + attrDefaultValue
				+ ", isDisplay=" + isDisplay + ", isFilter=" + isFilter
				+ ", sortOrder=" + sortOrder + "]";
	}



}
