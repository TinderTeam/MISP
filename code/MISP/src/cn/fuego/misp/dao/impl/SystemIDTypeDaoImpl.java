/**   
* @Title: SystemIDTypeDaoImpl.java 
* @Package cn.fuego.misp.dao.impl 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-16 下午11:37:09 
* @version V1.0   
*/ 
package cn.fuego.misp.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import cn.fuego.misp.dao.SystemIDTypeDao;
import cn.fuego.misp.dao.hibernate.util.HibernateUtil;
import cn.fuego.misp.domain.po.SystemIDType;
import cn.fuego.misp.domain.po.SystemMenu;

/**   
 * @Title: SystemIDTypeDaoImpl.java 
 * @Package cn.fuego.misp.dao.impl 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-16 下午11:37:09 
 * @version V1.0   
 */

public class SystemIDTypeDaoImpl implements SystemIDTypeDao {

	Log log = LogFactory.getLog(SystemIDTypeDaoImpl.class);
	
	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.SystemIDTypeDao#create(cn.fuego.misp.domain.po.SystemIDType)
	 */
	@Override
	public void create(SystemIDType id) {
		log.debug("[DAO] Create a SystemIDType:" + id.toString());
		try
		{
			HibernateUtil.add(id);
		} catch (RuntimeException re)
		{
			throw re;
		} finally
		{
			HibernateUtil.closeSession();
		}
		log.debug("[DAO] Success! -Create a SystemIDType:" + id.toString());

	}	


	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.SystemIDTypeDao#saveOrUpdate(cn.fuego.misp.domain.po.SystemIDType)
	 */
	@Override
	public void saveOrUpdate(SystemIDType id) {
		log.debug("[DAO] Save a SystemIDType:" + id.toString());
		try
		{
				HibernateUtil.update(id);
		} catch (RuntimeException re)
		{
			throw re;
		} finally
		{
			HibernateUtil.closeSession();
		}
		log.debug("[DAO] Success! -Save a SystemIDType:" + id.toString());
	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.SystemIDTypeDao#delete(cn.fuego.misp.domain.po.SystemIDType)
	 */
	@Override
	public void delete(SystemIDType id) {

		log.debug("[DAO] Delete the SystemIDType:" + id.toString());

		Session session = null;
		Transaction tx = null;
		try
		{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();

			Object classObj = session.load(SystemIDType.class, id.getName());

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


		log.debug("[DAO] Success!Delete the SystemIDType:" + id.toString());
	 }
	public SystemIDType getIDTypeByName(String name)
	{
		
		log.debug("get the SystemIDType by name:" + name);
		Session s = null;
		SystemIDType idType;
		try
		{
			s = HibernateUtil.getSession();
			Criteria c = s.createCriteria(SystemIDType.class);
			c.add(Restrictions.eq("name", name));
			idType =(SystemIDType) c.uniqueResult();
		} catch (RuntimeException re)
		{
			throw re;
		} finally
		{
			// HibernateUtil.closeSession();
			if (s != null)
			{
				s.close();
			}
		}

		return idType;		

	}
}
