/**   
* @Title: UserGroupDaoImpl.java 
* @Package cn.fuego.misp.dao.impl 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-22 下午8:49:33 
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

import cn.fuego.misp.dao.UserGroupDao;
import cn.fuego.misp.dao.hibernate.util.HibernateUtil;
import cn.fuego.misp.domain.po.UserGroup;

/**   
 * @Title: UserGroupDaoImpl.java 
 * @Package cn.fuego.misp.dao.impl 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-22 下午8:49:33 
 * @version V1.0   
 */

public class UserGroupDaoImpl implements UserGroupDao {
	Log log = LogFactory.getLog(UserGroupDaoImpl.class);
	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.UserGroupDao#create(cn.fuego.misp.domain.po.UserGroup)
	 */
	@Override
	public void create(UserGroup group) {
		log.debug("[DAO] Create a UserGroup:" + group.toString());
		try
		{
			HibernateUtil.add(group);
		} catch (RuntimeException re)
		{
			throw re;
		} finally
		{
			HibernateUtil.closeSession();
		}
		log.debug("[DAO] Success! -Create a UserGroup:" + group.toString());

	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.UserGroupDao#saveOrUpdate(cn.fuego.misp.domain.po.UserGroup)
	 */
	@Override
	public void saveOrUpdate(UserGroup group) {
		log.debug("[DAO] Save a UserGroup:" + group.toString());		
		try
		{
				HibernateUtil.update(group);
		} catch (RuntimeException re)
		{
			throw re;
		} finally
		{
			HibernateUtil.closeSession();
		}
		log.debug("[DAO] Success! -Save a UserGroup:" + group.toString());

	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.UserGroupDao#delete(cn.fuego.misp.domain.po.UserGroup)
	 */
	@Override
	public void delete(UserGroup group) {
		log.debug("[DAO] Delete the UserGroup:" + group.toString());

		Session session = null;
		Transaction tx = null;
		try
		{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();

			Object classObj = session.load(UserGroup.class, group.getGroupID());

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


		log.debug("[DAO] Success!Delete the UserGroup:" + group.toString());

	}
	@Override
	public void delete(String groupID) {
		log.debug("[DAO] Delete the UserGroup:" + groupID);

		Session session = null;
		Transaction tx = null;
		try
		{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();

			Object classObj = session.load(UserGroup.class, groupID);

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
 

	}
	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.UserGroupDao#getAll()
	 */
	@Override
	public List<UserGroup> getAll()
	{
 		Session s = null;
		List<UserGroup> userGroupList;
		try
		{
			s = HibernateUtil.getSession();
			Criteria c = s.createCriteria(UserGroup.class);
 			userGroupList = c.list();
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

		return userGroupList;	
		
	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.UserGroupDao#getGroupByID(java.lang.String)
	 */
	@Override
	public UserGroup getGroupByID(String groupID)
	{
		log.debug("get the user group by groupID:" + groupID);
		Session s = null;
		UserGroup userGroup;
		try
		{
			s = HibernateUtil.getSession();
			Criteria c = s.createCriteria(UserGroup.class);
			c.add(Restrictions.eq("groupID", groupID));
			userGroup =(UserGroup) c.uniqueResult();
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

		return userGroup;	
		
	}

}
