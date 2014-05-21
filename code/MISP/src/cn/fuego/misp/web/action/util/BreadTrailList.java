package cn.fuego.misp.web.action.util;

import java.util.ArrayList;
import java.util.List;

public class BreadTrailList extends ArrayList
{
	/**
	 * 二级目录
	 * @param twoarg
	 * @return
	 */
	public  BreadTrailList(BreadTrail breadTrail, BreadTrail breadTrail2)
	{
		List<BreadTrail> list=BreadTrailList();
		list.add(breadTrail);
		list.add(breadTrail2);
		return ;
	}

	private List<BreadTrail> BreadTrailList()
	{
		// TODO Auto-generated method stub
		return new ArrayList<BreadTrail>();
	}

	
	/**
	 * 一级目录
	 * @param onearg
	 * @return
	 */
	public BreadTrailList(BreadTrail breadTrail){
		List<BreadTrail> list= BreadTrailList();
		list.add(breadTrail);
		return ;
	}
	
	

}
