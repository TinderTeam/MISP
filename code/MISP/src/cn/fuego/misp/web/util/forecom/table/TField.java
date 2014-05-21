package cn.fuego.misp.web.util.forecom.table;
/**
 * 
* @ClassName: TField 
* @Description: TODO
* @author Nan Bowen
* @date 2014-5-19 上午12:22:14 
*
 */
public class TField
{
	private String name="field";	//fieldName 
	private String ispection=null;	//regular expression or funtion
	private boolean isVisable=true;	//visable
	private String value="value";
	private String type="String";
	private String url=null;
	private String id=null;
	

	public TField()
	{
	}
	
	
	public TField(String n)
	{
		
		setName(n);
		return ;
	}	
	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * @return the ispection
	 */
	public String getIspection()
	{
		return ispection;
	}
	/**
	 * @param ispection the ispection to set
	 */
	public void setIspection(String ispection)
	{
		this.ispection = ispection;
	}
	/**
	 * @return the isVisable
	 */
	public boolean isVisable()
	{
		return isVisable;
	}
	/**
	 * @param isVisable the isVisable to set
	 */
	public void setVisable(boolean isVisable)
	{
		this.isVisable = isVisable;
	}
	/**
	 * @return the value
	 */
	public String getValue()
	{
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String v)
	{
		value = v;
	}
	/**
	 * @return the type
	 */
	public String getType()
	{
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type)
	{
		this.type = type;
	}
	/**
	 * @return the url
	 */
	public String getUrl()
	{
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url)
	{
		this.url = url;
	}
	/**
	 * @return the id
	 */
	public String getId()
	{
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id)
	{
		this.id = id;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "TField [name=" + name + ", ispection=" + ispection
				+ ", isVisable=" + isVisable + ", value=" + value + ", type="
				+ type + ", url=" + url + ", id=" + id + "]";
	}
	
	
}
