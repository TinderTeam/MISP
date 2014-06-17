/**   
* @Title: UserGroupDaoImpl.java 
* @Package cn.fuego.misp.dao.impl 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-22 下午8:49:33 
* @version V1.0   
*/ 
package cn.fuego.misp.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.fuego.misp.dao.OrgDao;
import cn.fuego.misp.dao.UserGroupDao;
import cn.fuego.misp.dao.hibernate.util.HibernateUtil;
import cn.fuego.misp.domain.po.Org;
import cn.fuego.misp.domain.po.UserGroup;

/**  
 *  
* @ClassName: OrgDaoImpl 
* @Description: TODO
* @author Nan Bowen
* @date 2014-6-13 下午06:26:29 
*
 */
 
 
public class OrgDaoImpl implements OrgDao {
	Log log = LogFactory.getLog(OrgDaoImpl.class);
	
	@Override
	public void create(Org org) {
		log.debug("[DAO] Create a org:" + org.toString());
		try
		{
			HibernateUtil.add(org);
		} catch (RuntimeException re)
		{
			throw re;
		} finally
		{
			HibernateUtil.closeSession();
		}
		log.debug("[DAO] Success! -Create a org:" + org.toString());

	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.UserGroupDao#saveOrUpdate(cn.fuego.misp.domain.po.UserGroup)
	 */
	@Override
	public void saveOrUpdate(Org org) {
		log.debug("[DAO] Save a org:" + org.toString());		
		try
		{
				HibernateUtil.update(org);
		} catch (RuntimeException re)
		{
			throw re;
		} finally
		{
			HibernateUtil.closeSession();
		}
		log.debug("[DAO] Success! -Save a org:" + org.toString());

	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.UserGroupDao#delete(cn.fuego.misp.domain.po.UserGroup)
	 */
	@Override
	public void delete(Org org) {
		log.debug("[DAO] Delete the Org:" + org.toString());

		Session session = null;
		Transaction tx = null;
		try
		{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();

			Object classObj = session.load(Org.class, org.getOrgID());

			session.delete(classObj);

			tx.commit();
		} catch (RuntimeException re)
		{
			throw re;
		} finally
		{
			if (session != null)
			{
				session.close();
			}
		}


		log.debug("[DAO] Success!Delete the Org:" + org.toString());

	}

}
