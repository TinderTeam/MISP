/**   
* @Title: SystemMenuDaoImpl.java 
* @Package cn.fuego.misp.dao.impl 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-23 下午11:43:47 
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

import cn.fuego.misp.dao.SystemMenuDao;
import cn.fuego.misp.dao.hibernate.util.HibernateUtil;
import cn.fuego.misp.domain.po.SystemIDType;
import cn.fuego.misp.domain.po.SystemMenu;

/**   
 * @Title: SystemMenuDaoImpl.java 
 * @Package cn.fuego.misp.dao.impl 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-23 下午11:43:47 
 * @version V1.0   
 */

public class SystemMenuDaoImpl implements SystemMenuDao {
	Log log = LogFactory.getLog(SystemMenuDaoImpl.class);
	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.SystemMenuDao#create(cn.fuego.misp.domain.po.SystemMenu)
	 */
	@Override
	public void create(SystemMenu menu) {
		log.debug("[DAO] Create a SystemMenu:" + menu.toString());
		try
		{
			HibernateUtil.add(menu);
		} catch (RuntimeException re)
		{
			throw re;
		} finally
		{
			HibernateUtil.closeSession();
		}
		log.debug("[DAO] Success! -Create a SystemMenu:" + menu.toString());

	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.SystemMenuDao#saveOrUpdate(cn.fuego.misp.domain.po.SystemMenu)
	 */
	@Override
	public void saveOrUpdate(SystemMenu menu) {
		log.debug("[DAO] Save a SystemMenu:" + menu.toString());
		try
		{
				HibernateUtil.update(menu);
		} catch (RuntimeException re)
		{
			throw re;
		} finally
		{
			HibernateUtil.closeSession();
		}
		log.debug("[DAO] Success! -Save a SystemMenu:" + menu.toString());

	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.SystemMenuDao#delete(cn.fuego.misp.domain.po.SystemMenu)
	 */
	@Override
	public void delete(SystemMenu menu) {
		log.debug("[DAO] Delete the SystemMenu:" + menu.toString());

		Session session = null;
		Transaction tx = null;
		try
		{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();

			Object classObj = session.load(SystemMenu.class, menu.getMenuID());

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


		log.debug("[DAO] Success!Delete the SystemMenu:" + menu.toString());

	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.SystemMenuDao#getMenuByParentID(int)
	 */
	@Override
	public List<SystemMenu> getMenuByParentID(int parentID)
	{
		
		log.debug("[DAO] get the SystemMenu by ParentID:" + parentID);
		Session s = null;
		List<SystemMenu> menu;
		try
		{
			s = HibernateUtil.getSession();
			Criteria c = s.createCriteria(SystemMenu.class);
			c.add(Restrictions.eq("parentID", parentID));
			menu =c.list();
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

		return menu;		

	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.SystemMenuDao#getAllMenu()
	 */
	@Override
	public List<SystemMenu> getAllMenu()
	{
		Session s = null;
		List<SystemMenu> menu;
		try
		{
			s = HibernateUtil.getSession();
			Criteria c = s.createCriteria(SystemMenu.class);
 
			menu =c.list();
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

		return menu;		
	}

}
