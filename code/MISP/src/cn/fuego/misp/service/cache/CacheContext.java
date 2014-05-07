package cn.fuego.misp.service.cache;


public class CacheContext
{
	private static CacheContext instance;

	 
	private CacheContext()
	{

	}

	public static synchronized CacheContext getInstance()
	{
		if (null == instance)
		{
			instance = new CacheContext();
		}
		return instance;
	}
	
 
}
