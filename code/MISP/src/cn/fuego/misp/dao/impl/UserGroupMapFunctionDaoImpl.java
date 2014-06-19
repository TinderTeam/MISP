/**   
* @Title: UserGroupMapFunctionDaoImpl.java 
* @Package cn.fuego.misp.dao.impl 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-23 上午12:24:45 
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

import cn.fuego.misp.dao.UserGroupMapFunctionDao;
import cn.fuego.misp.dao.hibernate.util.HibernateUtil;
import cn.fuego.misp.domain.po.UserGroup;
import cn.fuego.misp.domain.po.UserGroupMapFunction;

/**   
 * @Title: UserGroupMapFunctionDaoImpl.java 
 * @Package cn.fuego.misp.dao.impl 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-23 上午12:24:45 
 * @version V1.0   
 */

public class UserGroupMapFunctionDaoImpl implements UserGroupMapFunctionDao {
	Log log = LogFactory.getLog(UserGroupMapFunctionDaoImpl.class);
	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.UserGroupMapFunctionDao#create(cn.fuego.misp.domain.po.UserGroupMapFunction)
	 */
	@Override
	public void create(UserGroupMapFunction usermap) {
		log.debug("[DAO] Create a UserGroupMapFunction:" + usermap.toString());
		try
		{
			HibernateUtil.add(usermap);
		} catch (RuntimeException re)
		{
			throw re;
		} finally
		{
			HibernateUtil.closeSession();
		}
		log.debug("[DAO] Success! -Create a UserGroupMapFunction:" + usermap.toString());

	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.UserGroupMapFunctionDao#saveOrUpdate(cn.fuego.misp.domain.po.UserGroupMapFunction)
	 */
	@Override
	public void saveOrUpdate(UserGroupMapFunction usermap) {
		log.debug("[DAO] Save a UserGroupMapFunction:" + usermap.toString());		
		try
		{
				delete(usermap);
				create(usermap);
		} catch (RuntimeException re)
		{
			throw re;
		} finally
		{
			HibernateUtil.closeSession();
		}
		log.debug("[DAO] Success! -Save a UserGroupMapFunction:" + usermap.toString());

	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.UserGroupMapFunctionDao#delete(cn.fuego.misp.domain.po.UserGroupMapFunction)
	 */
	@Override
	public void delete(UserGroupMapFunction usermap) {
		log.debug("[DAO] Delete the UserGroupMapFunction:" + usermap.toString());

		Session session = null;
		Transaction tx = null;
		String hql = null;

		try
		{
			session = HibernateUtil.getSession();

			tx = session.beginTransaction();

			hql = "delete from UserGroupMapFunction where group_id=? and function_id = ?";
			Query query = session.createQuery(hql);
			query.setString(0,usermap.getGroupID());
			query.setString(1,usermap.getFunctionID());


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

		log.debug("[DAO] Success!Delete the UserGroupMapFunction:" + usermap.toString());

	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.UserGroupMapFunctionDao#getByGroupID(int)
	 */
	@Override
	public List<UserGroupMapFunction> getByGroupID(String groupID)
	{
		Session s = null;
		List<UserGroupMapFunction> groupFunctionList;
		try
		{
			s = HibernateUtil.getSession();
			Criteria c = s.createCriteria(UserGroupMapFunction.class);
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
	 * @see cn.fuego.misp.dao.UserGroupMapFunctionDao#getAll()
	 */
	@Override
	public List<UserGroupMapFunction> getAll()
	{
		Session s = null;
		List<UserGroupMapFunction> groupFunctionList;
		try
		{
			s = HibernateUtil.getSession();
			Criteria c = s.createCriteria(UserGroupMapFunction.class);
 
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
	 * @see cn.fuego.misp.dao.UserGroupMapFunctionDao#deleteByGroupID(java.lang.String)
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

			hql = "delete from UserGroupMapFunction where group_id=?";
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
	
	

}
