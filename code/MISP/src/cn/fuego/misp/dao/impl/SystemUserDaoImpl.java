/**   
 * @Title: SystemUserDaoImpl.java 
 * @Package cn.fuego.misp.dao.impl 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-21 下午11:01:16 
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

import cn.fuego.misp.dao.SystemUserDao;
import cn.fuego.misp.dao.hibernate.util.HibernateUtil;
import cn.fuego.misp.domain.po.SystemUser;
import cn.fuego.misp.util.validate.ValidatorUtil;

/**
 * @Title: SystemUserDaoImpl.java
 * @Package cn.fuego.misp.dao.impl
 * @Description: TODO
 * @author Zhu Liucao
 * @date 2014-3-21 下午11:01:16
 * @version V1.0
 */

public class SystemUserDaoImpl implements SystemUserDao
{

	Log log = LogFactory.getLog(SystemUserDaoImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.fuego.misp.dao.SystemUserDao#create(cn.fuego.misp.domain.po.SystemUser
	 * )
	 */
	@Override
	public void create(SystemUser user)
	{
		log.debug("[DAO] Create a SystemUser:" + user.toString());
		try
		{
			HibernateUtil.add(user);
		} catch (RuntimeException re)
		{
			throw re;
		} finally
		{
			HibernateUtil.closeSession();
		}
		log.debug("[DAO] Success! -Create a SystemUser:" + user.toString());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.fuego.misp.dao.SystemUserDao#saveOrUpdate(cn.fuego.misp.domain.po.
	 * SystemUser)
	 */
	@Override
	public void saveOrUpdate(SystemUser user)
	{
		log.debug("[DAO] Save a SystemUser:" + user.toString());
		try
		{
			HibernateUtil.update(user);
		} catch (RuntimeException re)
		{
			throw re;
		} finally
		{
			HibernateUtil.closeSession();
		}
		log.debug("[DAO] Success! -Save a SystemUser:" + user.toString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.fuego.misp.dao.SystemUserDao#delete(cn.fuego.misp.domain.po.SystemUser
	 * )
	 */
	@Override
	public void delete(SystemUser user)
	{
		log.debug("[DAO] Delete the SystemUser:" + user.toString());

		Session session = null;
		Transaction tx = null;
		try
		{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();

			Object classObj = session.load(SystemUser.class, user.getUserID());

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

		log.debug("[DAO] Success!Delete the SystemUser:" + user.toString());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.fuego.misp.dao.SystemUserDao#getByFilter(java.util.List,
	 * java.util.List)
	 */
	@Override
	public List<SystemUser> getByFilter(List<String> userIDList,
			List<String> userNameList)
	{
		log.debug("[DAO] get the SystemUser by UserID and UserName:" +userIDList+userNameList );
		//根据userID列表信息和 userName列表信息 共同查找systemUser信息
		List<SystemUser> userList;
		Session s = null;

		try
		{
			s = HibernateUtil.getSession();

			Criteria c = s.createCriteria(SystemUser.class);		
			if (null!=userIDList)
			{
				c.add(Restrictions.in("userID", userIDList));
				
			}	
				if(null!=userNameList)
				{
					c.add(Restrictions.in("userName", userNameList));
				}
					
					
			

			userList = c.list();

		} catch (RuntimeException e)
		{
			//log.error("get the SystemUser by UserID and UserName failed." + userList, e);
			throw e;
		} finally
		{
			if (s != null)
			{
				s.close();
			}
		}

		return userList;		

	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.SystemUserDao#getByFilter(cn.fuego.misp.domain.po.SystemUser)
	 */
	@Override
	public List<SystemUser> getByFilter(SystemUser filter)
	{
		log.debug("[DAO] get the SystemUser by filter:" +filter );
		//根据userID列表信息和 userName列表信息 共同查找systemUser信息
		List<SystemUser> userList;
		Session s = null;

		try
		{
			s = HibernateUtil.getSession();

			Criteria c = s.createCriteria(SystemUser.class);		
			if (!ValidatorUtil.isEmpty(filter.getUserID()))
			{
				c.add(Restrictions.like("userID", "%"+filter.getUserID()+"%"));
				
			}	
			userList = c.list();

		} catch (RuntimeException e)
		{
			//log.error("get the SystemUser by UserID and UserName failed." + userList, e);
			throw e;
		} finally
		{
			if (s != null)
			{
				s.close();
			}
		}

		return userList;	
	}

	@Override
	public SystemUser getByID(String id)
	{
		SystemUser filter = new SystemUser();
		filter.setUserID(id);
		List<SystemUser> list =getByFilter(filter);
		/*
		 * 默认
		 */
		return list.get(0);
	}

}
