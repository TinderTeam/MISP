package cn.fuego.misp.web.util.forecom.table;

import java.util.List;

import cn.fuego.misp.web.util.forecom.exception.ForeComException;
import cn.fuego.misp.web.util.forecom.exception.ForeComExceptionMsg;

public class MispTable
{
	private String tTitle="";	//title of this table, show in the top of compoment  
	private List<TField> tFieldlist=null;	// list for fieldName
	private List<List<String>> tDataList =null;	// table data
	
	int fieldNum = 0;	//field Num
	int dataNum = 0;	//field Num
	
	MispTable(List<TField> fl,List<List<String>> dl){
		tFieldlist=fl;
		tDataList=dl;
		init();
		
	}
	
	/**
	 * Table inspection and init;
	 * 
	 */
	private void init()
	{
		if(null!=tFieldlist && tFieldlist.size()>0){
			fieldNum =tFieldlist.size();
			if(null!=tDataList && tDataList.size()>0){
				dataNum=tDataList.size();
				//逐行校验
				for(List<String> row :tDataList){
					//一行数据
					int rowFieldSize=row.size();
					//校验长度
					if(rowFieldSize!=fieldNum){
						//字段数量出现错误
						throw new ForeComException(ForeComExceptionMsg.MISPTABLE_FIELDNUM_ERR);
					}
					
					/* Notice:
					 * 对字段属性的校验，在这里暂时不做，因为这个方法是在显示的时候，这样处理有可能会影响效率
					 */
					
					/*
					for(int i=0;i<row.size();i++){
						//逐个字段校验
						String inspectionMsg=inspection(row.get(i),tFieldlist.get(i).getIspection());
						if(!inspectionMsg.equals("True")){
							//校验出现错误
							throw new ForeComException(inspectionMsg);
						}						
					}
					*/
				}
			}
		}	
	}

	/**
	 * 校验
	 * @param string
	 * @param ispection
	 */
	private String inspection(String string, String ispection)
	{
		return "True";
		// TODO 完成校验方法
		
	}

	public void settTitle(String tTitle)
	{
		this.tTitle = tTitle;
	}

	/**
	 * @return the tFieldlist
	 */
	public List<TField> gettFieldlist()
	{
		return tFieldlist;
	}

	/**
	 * @param tFieldlist the tFieldlist to set
	 */
	public void settFieldlist(List<TField> tFieldlist)
	{
		this.tFieldlist = tFieldlist;
	}

	public String gettTitle()
	{
		return tTitle;
	}
}
