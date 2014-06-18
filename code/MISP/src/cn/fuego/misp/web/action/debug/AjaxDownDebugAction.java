/**   
 * @Title: LoginAction.java 
 * @Package cn.fuego.misp.web.action.login 
 * @Description: TODO
 * @author Tang Jun   
 * @date 2014-2-28 上午01:05:19 
 * @version V1.0   
 */
package cn.fuego.misp.web.action.debug;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import cn.fuego.misp.web.action.util.MISPAction;

/**
 * @ClassName: LoginAction
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-2-28 上午01:05:19
 * @Edit Nan Bowen at 2014-03-23
 */

public class AjaxDownDebugAction extends MISPAction
{
	Log log = LogFactory.getLog(AjaxDownDebugAction.class);
//	private List<MenuTreeModel> menuTreeItem=null;
//	private UserModel user=null;
	private  String testUrl;
	
	
	public String execute()
	{
		 boolean result=false;
		
	    log.info("进入Action");	     	    	
	    try
		{
	    	result=true;
	    	testUrl="testUrl";
	    	try
			{
				Thread.sleep(10000);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//括号里面的30000代表30000毫秒，也就是30秒，可以该成你需要的时间
			ServletActionContext.getResponse().getWriter().print(testUrl);
			
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		log.info("完成计时Action");	  
		return null;
	}


	public void setTestUrl(String testUrl)
	{
		this.testUrl = testUrl;
	}


	public String getTestUrl()
	{
		return testUrl;
	}
	
	
}
