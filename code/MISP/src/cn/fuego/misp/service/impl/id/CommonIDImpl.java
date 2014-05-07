/**   
* @Title: BasicIDImpl.java 
* @Package cn.fuego.misp.service.impl.id 
* @Description: TODO
* @author Tang Jun   
* @date 2014-2-28 下午11:10:36 
* @version V1.0   
*/ 
package cn.fuego.misp.service.impl.id;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.fuego.misp.domain.po.SystemIDType;
import cn.fuego.misp.service.IDCreateService;

/** 
 * @ClassName: BasicIDImpl 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-2-28 下午11:10:36 
 *  
 */

public class CommonIDImpl implements IDCreateService
{	
	Log log = LogFactory.getLog(IDCreateService.class);

	private String idName;

	public synchronized List<String> createIDList(int idCount)
	{
		//get id type by id name
		SystemIDType idType = new SystemIDType();
		
		List<String> idList = new ArrayList<String>();

		int currentID = idType.getCurrentID();
		for(int i=0;i<idCount;i++)
		{	
			//id increase mode is different
			if(IDCreateService.INCREASE_MODE == idType.getIncMode())
			{
				currentID += idType.getStep();
			}
			else
			{
				currentID -= idType.getStep();
			}
			
			String idString = getStringID(idType.getPrefix(),idType.getLength(),currentID,idType.getSuffix());
			idList.add(idString);
		}
		// update current id
		idType.setCurrentID(currentID);
		log.info("id count is " + idCount);
		log.info("now current id is " + currentID);
		return idList;
	}
 
	// Convert currentID to TransID
	public String getStringID(String prefix,int length,int currentID,String sufix)
	{
		String curID = "";
		curID = String.valueOf(currentID);
		curID = prefix + getZeroStr(length-curID.length()) + curID + sufix;

		return curID;

	}
	// get some "0" and add to transID
	private String getZeroStr(int n)
	{
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < n; i++)
		{
			str.append(IDCreateService.ID_PRFIX);
		}

		return str.toString();

	}
}
