/**   
* @Title: OrgManageServiceImpl.java 
* @Package cn.fuego.misp.service.impl.org 
* @Description: TODO
* @author Tang Jun   
* @date 2014-6-18 下午09:12:48 
* @version V1.0   
*/ 
package cn.fuego.misp.service.impl.org;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.fuego.misp.dao.DaoContext;
import cn.fuego.misp.dao.OrgDao;
import cn.fuego.misp.domain.po.Org;
import cn.fuego.misp.service.OrgManageService;
import cn.fuego.misp.service.ServiceContext;
import cn.fuego.misp.service.impl.user.UserManageServiceImpl;
import cn.fuego.misp.util.validate.ValidatorUtil;
import cn.fuego.misp.web.model.org.OrgModel;

/** 
 * @ClassName: OrgManageServiceImpl 
 * @Description: TODO
 * @author Tang Jun
 * @date 2014-6-18 下午09:12:48 
 *  
 */

public class OrgManageServiceImpl implements OrgManageService
{
	Log log = LogFactory.getLog(UserManageServiceImpl.class);

	private OrgDao orgDao = DaoContext.getInstance().getOrgDao();

	private static final String ROOT_PARENT_ID = "0";

	/* (non-Javadoc)
	 * @see cn.fuego.misp.service.OrgTreeManageService#getAllOrg()
	 */
	@Override
	public List<OrgModel> getAllOrg()
	{
		return loadOrgTreeByParentID(ROOT_PARENT_ID);
	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.service.OrgTreeManageService#getOrgModelByID(java.lang.String)
	 */
	@Override
	public OrgModel getOrgModelByID(String orgID)
	{
		OrgModel orgModel = convertOrgToOrgModel(orgDao.getOrgByOrgID(orgID));
		orgModel.setSubOrgList(loadOrgTreeByParentID(orgID));
		return orgModel;
	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.service.OrgTreeManageService#modify(cn.fuego.misp.web.model.org.OrgModel)
	 */
	@Override
	public void modify(OrgModel orgModel)
	{
		log.info("modify the org");
		Org org = orgDao.getOrgByOrgID(orgModel.getOrgID());
		
		if(null == org)
		{
			log.error("can not find the org by the id. org id is " + orgModel.getOrgID());
			return;
		}
		org.setOrgName(orgModel.getOrgName());
		org.setOrgDesp(orgModel.getOrgDescription());
  
		orgDao.saveOrUpdate(org);

	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.service.OrgManageService#create(cn.fuego.misp.web.model.org.OrgModel)
	 */
	@Override
	public void create(OrgModel orgModel)
	{
		log.info("create the org." + orgModel);
		
		Org org = new Org();
		List<String> idList = ServiceContext.getInstance().getIDCreateService().createIDList(1);
		org.setOrgID(idList.get(0));
		org.setOrgName(orgModel.getOrgName());
		org.setOrgDesp(orgModel.getOrgDescription());
		org.setParentID(orgModel.getParentID());
		orgDao.create(org);
	}
	/* (non-Javadoc)
	 * @see cn.fuego.misp.service.OrgTreeManageService#delete(java.lang.String)
	 */
	@Override
	public void delete(String orgID)
	{
		log.info("delete the org. org id is " + orgID);

		orgDao.delete(orgID);
	}
	
	private List<OrgModel> loadOrgTreeByParentID(String parentID)
	{
		
		List<OrgModel> menuTreeList = new ArrayList<OrgModel>();

		for (Org org : orgDao.getOrgByParentID(parentID))
		{
			OrgModel orgModel = convertOrgToOrgModel(org);
		 
			if (!ValidatorUtil.isEmpty(orgDao.getOrgByParentID(org.getOrgID())))
			{
				orgModel.setSubOrgList(loadOrgTreeByParentID(org.getOrgID()));
			}
			menuTreeList.add(orgModel);
		}
		return menuTreeList;
	}
	
	private OrgModel convertOrgToOrgModel(Org org)
	{
		OrgModel orgModel = new OrgModel();
		orgModel.setOrgID(org.getOrgID());
		orgModel.setOrgName(org.getOrgName());
		orgModel.setOrgDescription(org.getOrgDesp());
		orgModel.setParentID(org.getOrgID());
 
		return orgModel;
	}


}
