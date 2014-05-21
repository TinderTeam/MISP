package cn.fuego.misp.web.util.forecom.table;

import java.util.List;

public class MispTable
{
	private String tTitle="";	//title of this table, show in the top of compoment  
	private List<TField> tFieldlist=null;	// list for fieldName
	private List<?> obList =null;	// table data
	
	int fieldNum = 0;	//field Num
	int dataNum = 0;	//field Num
	
	public MispTable(List<TField> fl,List<?> dl){
		tFieldlist=fl;
		obList=dl;
		init();		
	}
	
	/**
	 *  init;
	 * 
	 */
	private void init()
	{
		if(null!=tFieldlist && tFieldlist.size()>0){
			fieldNum =tFieldlist.size();
			if(null!=obList && obList.size()>0){
				dataNum=obList.size();
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "MispTable [tTitle=" + tTitle + ", tFieldlist=" + tFieldlist
				+ ", obList=" + obList + ", fieldNum=" + fieldNum
				+ ", dataNum=" + dataNum + "]";
	}
	
	
}
