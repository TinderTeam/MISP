/**   
* @Title: UserMapGroupDaoImpl.java 
* @Package cn.fuego.misp.dao.impl 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-22 下午11:14:15 
* @version V1.0   
*/ 
package cn.fuego.misp.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import cn.fuego.misp.dao.UserMapGroupDao;
import cn.fuego.misp.dao.hibernate.util.HibernateUtil;
import cn.fuego.misp.domain.po.UserMapGroup;

/**   
 * @Title: UserMapGroupDaoImpl.java 
 * @Package cn.fuego.misp.dao.impl 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-22 下午11:14:15 
 * @version V1.0   
 */

public class UserMapGroupDaoImpl implements UserMapGroupDao {
	Log log = LogFactory.getLog(UserMapGroupDaoImpl.class);
	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.UserMapGroupDao#create(cn.fuego.misp.domain.po.UserMapGroup)
	 */
	@Override
	public void create(UserMapGroup map) {
		log.debug("[DAO] Create a UserMapGroup:" + map.toString());
		try
		{
			HibernateUtil.add(map);
		} catch (RuntimeException re)
		{
			throw re;
		} finally
		{
			HibernateUtil.closeSession();
		}
		log.debug("[DAO] Success! -Create a UserMapGroup:" + map.toString());

	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.UserMapGroupDao#saveOrUpdate(cn.fuego.misp.domain.po.UserMapGroup)
	 */
	@Override
	public void saveOrUpdate(UserMapGroup map) {
		log.debug("[DAO] Save a UserMapGroup:" + map.toString());		
		try
		{
				delete(map);
				create(map);
		} catch (RuntimeException re)
		{
			throw re;
		} finally
		{
			HibernateUtil.closeSession();
		}
		log.debug("[DAO] Success! -Save a UserMapGroup:" + map.toString());

	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.UserMapGroupDao#delete(cn.fuego.misp.domain.po.UserMapGroup)
	 */
	@Override
	public void delete(UserMapGroup map) {
		log.debug("[DAO] Delete the UserMapGroup:" + map.toString());

		Session session = null;
		Transaction tx = null;
		String hql = null;

		try
		{
			session = HibernateUtil.getSession();

			tx = session.beginTransaction();

			hql = "delete from UserMapGroup where user_id=? and group_id = ?";
			Query query = session.createQuery(hql);
			query.setString(0, map.getUserID());
			query.setString(1, map.getGroupID());

			query.executeUpdate();

			tx.commit();
		} catch (RuntimeException re)
		{
			throw re;
		} finally
		{
			if(null != session)
			{
				session.close();
			}
		}

		log.debug("[DAO] Success!Delete the UserMapGroup:" + map.toString());

	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.UserMapGroupDao#getByGroupID(java.lang.String)
	 */
	@Override
	public List<UserMapGroup> getByGroupID(String groupID)
	{
		Session s = null;
		List<UserMapGroup> groupFunctionList;
		try
		{
			s = HibernateUtil.getSession();
			Criteria c = s.createCriteria(UserMapGroup.class);
			c.add(Restrictions.eq("groupID", groupID));

 			groupFunctionList = c.list();
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

		return groupFunctionList;	
	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.UserMapGroupDao#getAll()
	 */
	@Override
	public List<UserMapGroup> getAll()
	{
		Session s = null;
		List<UserMapGroup> groupFunctionList;
		try
		{
			s = HibernateUtil.getSession();
			Criteria c = s.createCriteria(UserMapGroup.class);
 
 			groupFunctionList = c.list();
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

		return groupFunctionList;
	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.UserMapGroupDao#deleteByGroupID(java.lang.String)
	 */
	@Override
	public void deleteByGroupID(String groupID)
	{
		Session session = null;
		Transaction tx = null;
		String hql = null;
		// SystemUser user = null;
		try
		{
			session = HibernateUtil.getSession();

			tx = session.beginTransaction();

			hql = "delete from UserMapGroup where group_id=?";
			Query query = session.createQuery(hql);
			query.setString(0, groupID);

			query.executeUpdate();

			tx.commit();
		} catch (RuntimeException re)
		{
			throw re;
		} finally
		{
			if(null != session)
			{
				session.close();
			}
		}
		
	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.UserMapGroupDao#deleteByUserID(java.lang.String)
	 */
	@Override
	public void deleteByUserID(String userID)
	{
		Session session = null;
		Transaction tx = null;
		String hql = null;
		// SystemUser user = null;
		try
		{
			session = HibernateUtil.getSession();

			tx = session.beginTransaction();

			hql = "delete from UserMapGroup where user_id=?";
			Query query = session.createQuery(hql);
			query.setString(0, userID);

			query.executeUpdate();

			tx.commit();
		} catch (RuntimeException re)
		{
			throw re;
		} finally
		{
			if(null != session)
			{
				session.close();
			}
		}
		
	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.UserMapGroupDao#getByPrimary(cn.fuego.misp.domain.po.UserMapGroup)
	 */
	@Override
	public UserMapGroup getByPrimary(UserMapGroup map)
	{
		log.debug("get the user group by groupID:" + map);
		Session s = null;
		UserMapGroup userMapGroup;
		try
		{
			s = HibernateUtil.getSession();
			Criteria c = s.createCriteria(UserMapGroup.class);
			c.add(Restrictions.eq("groupID", map.getGroupID()));
			c.add(Restrictions.eq("userID", map.getUserID()));

			userMapGroup =(UserMapGroup) c.uniqueResult();
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

		return userMapGroup;	
	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.UserMapGroupDao#create(java.util.List)
	 */
	@Override
	public void create(List<UserMapGroup> mapList)
	{
		Session session = null;
		Transaction tx = null;
		try
		{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			for(UserMapGroup map : mapList)
			{
				session.save(map);
			}
 			tx.commit();
			
		} catch (RuntimeException re)
		{
			throw re;
		} finally
		{
			//  HibernateUtil.closeSession();
			if (session != null)
			{
				session.close();
			}
		}
		
	}

}
