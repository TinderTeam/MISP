package stub.web.model.org;

import java.util.ArrayList;
import java.util.List;

import cn.fuego.misp.web.model.org.OrgModel;

public class OrgModelStub
{
	public static OrgModel getOrgModel(String name,Boolean subOrgExist,List<OrgModel> subOrgList,String desc)
	{

		OrgModel o = new OrgModel();
		o.setOrgName(name);
		o.setSubOrgExist(subOrgExist);
		o.setSubOrgList(subOrgList);
		o.setOrgDescription(desc);
		
		return o;
	}
	
	public static List<OrgModel> getOrgModelList(){
		List<OrgModel> drlist = new ArrayList<OrgModel>();
		drlist.add(getOrgModel("MISP项目组",false,null,"MISP部是末级子节点"));
		drlist.add(getOrgModel("Fuego项目组",false,null,"fuego是末级子节点"));
		
		List<OrgModel> list = new ArrayList<OrgModel>();
		list.add(getOrgModel("研发部",true,drlist,"研发部"));
		list.add(getOrgModel("市场部",false,null,"市场部1级子节点"));

		List<OrgModel> allList = new ArrayList<OrgModel>();
		allList.add(getOrgModel("深圳市孚思科技有有限公司",true,list,"公司根节点"));
		return allList;
		
	}

}
