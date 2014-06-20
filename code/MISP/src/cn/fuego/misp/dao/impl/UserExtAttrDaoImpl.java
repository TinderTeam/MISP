/**   
* @Title: UserExtAttrDaoImpl.java 
* @Package cn.fuego.misp.dao.impl 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-22 上午12:31:59 
* @version V1.0   
*/ 
package cn.fuego.misp.dao.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import cn.fuego.misp.dao.UserExtAttrDao;
import cn.fuego.misp.dao.hibernate.util.HibernateUtil;
import cn.fuego.misp.domain.base.AttributeBean;
import cn.fuego.misp.domain.po.UserExtAttr;
import cn.fuego.misp.util.validate.ValidatorUtil;

/**   
 * @Title: UserExtAttrDaoImpl.java 
 * @Package cn.fuego.misp.dao.impl 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-22 上午12:31:59 
 * @version V1.0   
 */

public class UserExtAttrDaoImpl implements UserExtAttrDao {

	Log log = LogFactory.getLog(UserExtAttrDaoImpl.class);
	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.UserExtAttrDao#create(cn.fuego.misp.domain.po.UserExtAttr)
	 */
	@Override
	public void create(UserExtAttr attr) {
		log.debug("[DAO] Create a UserExtAttr:" + attr.toString());
		try
		{
			HibernateUtil.add(attr);
		} catch (RuntimeException re)
		{
			throw re;
		} finally
		{
			HibernateUtil.closeSession();
		}
		log.debug("[DAO] Success! -Create a UserExtAttr:" + attr.toString());

	}
	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.UserExtAttrDao#create(java.util.List)
	 */
	@Override
	public void create(List<UserExtAttr> attrList)
	{
		if(ValidatorUtil.isEmpty(attrList))
		{	
			log.warn("the attr list is empty");
			return;
		}
		Session session = null;
		Transaction tx = null;
		try
		{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			for(UserExtAttr attr : attrList)
			{
				session.save(attr);
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
	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.UserExtAttrDao#saveOrUpdate(cn.fuego.misp.domain.po.UserExtAttr)
	 */
	@Override
	public void saveOrUpdate(UserExtAttr attr) {
		log.debug("[DAO] Save a UserExtAttr:" + attr.toString());		
		try
		{
				delete(attr);
				create(attr);
		} catch (RuntimeException re)
		{
			throw re;
		} finally
		{
			HibernateUtil.closeSession();
		}
		log.debug("[DAO] Success! -Save a UserExtAttr:" + attr.toString());
	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.UserExtAttrDao#delete(cn.fuego.misp.domain.po.UserExtAttr)
	 */
	@Override
	public void delete(UserExtAttr attr) {
		log.debug("[DAO] Delete the UserExtAttr:" + attr.toString());

		Session session = null;
		Transaction tx = null;
		String hql = null;

		try
		{
			session = HibernateUtil.getSession();

			tx = session.beginTransaction();

			hql = "delete from UserExtAttr where user_id=? and attr_name = ?";
			Query query = session.createQuery(hql);
			query.setString(0, attr.getUserID());
			query.setString(1, attr.getAttrName());

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

		log.debug("[DAO] Success!Delete the UserExtAttr:" + attr.toString());		

	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.UserExtAttrDao#getByFilter()
	 */
	public List<UserExtAttr> getByFilter(Set<String> userIDList,AttributeBean attr)
	{
		log.debug("[DAO] get the UserExtAttr by attr:" +attr );
		
		List<UserExtAttr> extList= new ArrayList<UserExtAttr>();
		Session s=null;
		try
		{
			s = HibernateUtil.getSession();
			Criteria c = s.createCriteria(UserExtAttr.class);	
			
			if(!ValidatorUtil.isEmpty(userIDList))
			{
				c.add(Restrictions.in("userID", userIDList));
			}
            
			if(null != attr)
			{
				if (!ValidatorUtil.isEmpty(attr.getAttrName()))
				{
					c.add(Restrictions.eq("attrName", attr.getAttrName()));
				}
				if (!ValidatorUtil.isEmpty(attr.getAttrValue()))
				{
					c.add(Restrictions.like("attrValue", "%" + attr.getAttrValue() + "%"));
				}				
			}

			extList = c.list();

		} catch (RuntimeException e)
		{
			
			throw e;
		} finally
		{
			if (s != null)
			{
				s.close();
			}
		}
		return extList;
		
	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.UserExtAttrDao#delete(java.util.List)
	 */
	@Override
	public void delete(List<String> userIDList)
	{
		log.debug("delete by user id list. " + userIDList );

		if(ValidatorUtil.isEmpty(userIDList))
		{
			log.warn("the user id lis is empty");
			return;
		}
		
		Session session = null;
		Transaction tx = null;
		String hql = null;
		// SystemUser user = null;
		try
		{
			session = HibernateUtil.getSession();

			tx = session.beginTransaction();

 
			for(String userID : userIDList)
			{	
				hql = "delete from UserExtAttr where user_id =?";
				Query query = session.createQuery(hql);
				query.setString(0, userID);
				query.executeUpdate();
			}
 
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


	


}
