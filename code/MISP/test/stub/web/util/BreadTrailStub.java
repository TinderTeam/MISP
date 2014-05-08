package stub.web.util;

import java.util.ArrayList;
import java.util.List;

import cn.fuego.misp.web.action.util.BreadTrail;

public class BreadTrailStub
{
	public static List<BreadTrail> getTwoOrderBreadTrailStub()
	{
		
		
		List<BreadTrail> list = new ArrayList<BreadTrail>();
		
		BreadTrail bt = new BreadTrail();
		bt.setValue("一级标题");
		bt.setUrl("www.fuego.cn");
		BreadTrail bt2 = new BreadTrail();
		bt2.setValue("二级标题");
		bt2.setUrl("www.baidu.com");
		
		list.add(bt);
		list.add(bt2);
		
		return list;

	}
}
