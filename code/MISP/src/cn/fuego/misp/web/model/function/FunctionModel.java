/**   
* @Title: FunctionModel.java 
* @Package cn.fuego.misp.web.model 
* @Description: TODO
* @author Tang Jun   
* @date 2014-6-19 上午10:26:06 
* @version V1.0   
*/ 
package cn.fuego.misp.web.model.function;

/** 
 * @ClassName: FunctionModel 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-6-19 上午10:26:06 
 *  
 */

public class FunctionModel
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
	
	
}
