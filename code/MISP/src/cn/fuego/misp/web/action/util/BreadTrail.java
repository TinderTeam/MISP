package cn.fuego.misp.web.action.util;

public class BreadTrail
{
	
	
	
	private String value;
	private String url;
	
	
	
	
	public BreadTrail(String v)
	{	
		this.value=v;
		this.url="#";
	}
	
	public BreadTrail(String v,String u){
		value=v;
		url=u;
	}
	public BreadTrail()
	{

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
	public void setValue(String value)
	{
		this.value = value;
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
	
}
