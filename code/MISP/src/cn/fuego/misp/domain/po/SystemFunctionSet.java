/**   
 * @Title: SystemFunctionSet.java 
 * @Package cn.fuego.misp.domain.po 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-22 下午11:42:15 
 * @version V1.0   
 */
package cn.fuego.misp.domain.po;

/**
 * @Title: SystemFunctionSet.java
 * @Package cn.fuego.misp.domain.po
 * @Description: TODO
 * @author Zhu Liucao
 * @date 2014-3-22 下午11:42:15
 * @version V1.0
 */

public class SystemFunctionSet
{

	private String functionID;
	private String functionName;
	private int functionType;
	private String functionDesp;

	public String getFunctionID()
	{
		return functionID;
	}

	public void setFunctionID(String functionID)
	{
		this.functionID = functionID;
	}

	public String getFunctionName()
	{
		return functionName;
	}

	public void setFunctionName(String functionName)
	{
		this.functionName = functionName;
	}

	public int getFunctionType()
	{
		return functionType;
	}

	public void setFunctionType(int functionType)
	{
		this.functionType = functionType;
	}

	public String getFunctionDesp()
	{
		return functionDesp;
	}

	public void setFunctionDesp(String functionDesp)
	{
		this.functionDesp = functionDesp;
	}

	@Override
	public String toString()
	{
		return "SystemFunctionSet [functionID=" + functionID + ", functionName=" + functionName + ", functionType=" + functionType + ", functionDesp=" + functionDesp + "]";
	}

}
