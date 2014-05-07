/**   
* @Title: UserMapGroupDaoImpl.java 
* @Package cn.fuego.misp.dao.impl 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-22 下午11:14:15 
* @version V1.0   
*/ 
package cn.fuego.misp.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
			query.setInteger(1, map.getGroupID());

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

}
