/**   
* @Title: ValidatorUtil.java 
* @Package cn.tinder.fuego.util 
* @Description: TODO
* @author Tang Jun   
* @date 2013-12-4 下午06:01:41 
* @version V1.0   
*/ 
package cn.fuego.misp.util.validate;

import java.util.List;

/** 
 * @ClassName: ValidatorUtil 
 * @Description: TODO
 * @author Tang Jun
 * @date 2013-12-4 下午06:01:41 
 *  
 */

public class ValidatorUtil
{
	public static boolean isEmpty(List list)
	{
		if(null == list)
		{
			return true;
		}
		if(list.isEmpty())
		{
			return true;
		}
		return false;
	}
	public static boolean isEmpty(String str)
	{
		if(null == str)
		{
			return true;
		}
		if(str.trim().isEmpty())
		{
			return true;
		}
		return false;
	}
}
