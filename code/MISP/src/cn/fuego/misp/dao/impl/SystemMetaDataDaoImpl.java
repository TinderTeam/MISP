/**   
* @Title: SystemMetaDataDaoImpl.java 
* @Package cn.fuego.misp.dao.impl 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-22 下午8:13:59 
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
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import cn.fuego.misp.dao.SystemMetaDataDao;
import cn.fuego.misp.dao.hibernate.util.HibernateUtil;
import cn.fuego.misp.domain.po.SystemMetaData;
import cn.fuego.misp.domain.po.SystemUser;
import cn.fuego.misp.util.validate.ValidatorUtil;

/**   
 * @Title: SystemMetaDataDaoImpl.java 
 * @Package cn.fuego.misp.dao.impl 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-22 下午8:13:59 
 * @version V1.0   
 */

public class SystemMetaDataDaoImpl implements SystemMetaDataDao {
	Log log = LogFactory.getLog(SystemMetaDataDaoImpl.class);
	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.SystemMetaDataDao#create(cn.fuego.misp.domain.po.SystemMetaData)
	 */
	@Override
	public void create(SystemMetaData meta) {
		log.debug("[DAO] Create a SystemMetaData:" + meta.toString());
		try
		{
			HibernateUtil.add(meta);
		} catch (RuntimeException re)
		{
			throw re;
		} finally
		{
			HibernateUtil.closeSession();
		}
		log.debug("[DAO] Success! -Create a SystemMetaData:" + meta.toString());

	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.SystemMetaDataDao#saveOrUpdate(cn.fuego.misp.domain.po.SystemMetaData)
	 */
	@Override
	public void saveOrUpdate(SystemMetaData meta) {
		log.debug("[DAO] Save a SystemMetaData:" + meta.toString());		
		try
		{
				delete(meta);
				create(meta);
		} catch (RuntimeException re)
		{
			throw re;
		} finally
		{
			HibernateUtil.closeSession();
		}
		log.debug("[DAO] Success! -Save a SystemMetaData:" + meta.toString());

	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.SystemMetaDataDao#delete(cn.fuego.misp.domain.po.SystemMetaData)
	 */
	@Override
	public void delete(SystemMetaData meta) {
		log.debug("[DAO] Delete the SystemMetaData:" + meta.toString());

		Session session = null;
		Transaction tx = null;
		String hql = null;

		try
		{
			session = HibernateUtil.getSession();

			tx = session.beginTransaction();

			hql = "delete from SystemMetaData where table_name=? and attr_name = ?";
			Query query = session.createQuery(hql);
			query.setString(0, meta.getTableName());
			query.setString(1, meta.getAttrName());

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

		log.debug("[DAO] Success!Delete the SystemMetaData:" + meta.toString());

	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.SystemMetaDataDao#getMetaDataByTableName(java.lang.String)
	 */
	@Override
	public List<SystemMetaData> getMetaDataByTableName(String tableName)
	{
		log.debug("[DAO] get the getMetaDataByTableName by filter:" +tableName );
		//根据userID列表信息和 userName列表信息 共同查找systemUser信息
		List<SystemMetaData> metaDataList;
		Session s = null;

		try
		{
			s = HibernateUtil.getSession();

			Criteria c = s.createCriteria(SystemMetaData.class);		
			c.add(Restrictions.eq("tableName", tableName));
			c.addOrder(Order.desc("sortOrder"));
		 
			metaDataList = c.list();

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
		
		return metaDataList;

	}

}
