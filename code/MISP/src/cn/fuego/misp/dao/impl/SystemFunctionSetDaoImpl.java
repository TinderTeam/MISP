/**   
* @Title: SystemFunctionSetDaoImpl.java 
* @Package cn.fuego.misp.dao.impl 
* @Description: TODO
* @author Zhu Liucao   
* @date 2014-3-22 下午11:55:12 
* @version V1.0   
*/ 
package cn.fuego.misp.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.fuego.misp.dao.SystemFunctionSetDao;
import cn.fuego.misp.dao.hibernate.util.HibernateUtil;
import cn.fuego.misp.domain.po.SystemFunctionSet;
import cn.fuego.misp.domain.po.SystemIDType;

/**   
 * @Title: SystemFunctionSetDaoImpl.java 
 * @Package cn.fuego.misp.dao.impl 
 * @Description: TODO
 * @author Zhu Liucao   
 * @date 2014-3-22 下午11:55:12 
 * @version V1.0   
 */

public class SystemFunctionSetDaoImpl implements SystemFunctionSetDao {
	
	Log log = LogFactory.getLog(SystemFunctionSetDaoImpl.class);
	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.SystemFunctionSetDao#create(cn.fuego.misp.domain.po.SystemFunctionSet)
	 */
	@Override
	public void create(SystemFunctionSet function) {

		log.debug("[DAO] Create a SystemFunctionSet:" + function.toString());
		try
		{
			HibernateUtil.add(function);
		} catch (RuntimeException re)
		{
			throw re;
		} finally
		{
			HibernateUtil.closeSession();
		}
		log.debug("[DAO] Success! -Create a SystemFunctionSet:" + function.toString());

	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.SystemFunctionSetDao#saveOrUpdate(cn.fuego.misp.domain.po.SystemFunctionSet)
	 */
	@Override
	public void saveOrUpdate(SystemFunctionSet function) {
		log.debug("[DAO] Save a SystemFunctionSet:" + function.toString());		
		try
		{
				HibernateUtil.update(function);
		} catch (RuntimeException re)
		{
			throw re;
		} finally
		{
			HibernateUtil.closeSession();
		}
		log.debug("[DAO] Success! -Save a SystemFunctionSet:" + function.toString());

	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.SystemFunctionSetDao#delete(cn.fuego.misp.domain.po.SystemFunctionSet)
	 */
	@Override
	public void delete(SystemFunctionSet function) {

		log.debug("[DAO] Delete the SystemFunctionSet:" + function.toString());

		Session session = null;
		Transaction tx = null;
		try
		{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();

			Object classObj = session.load(SystemFunctionSet.class, function.getFunctionID());

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


		log.debug("[DAO] Success!Delete the SystemFunctionSet:" + function.toString());

	}

	/* (non-Javadoc)
	 * @see cn.fuego.misp.dao.SystemFunctionSetDao#getByFilter(cn.fuego.misp.domain.po.SystemFunctionSet)
	 */
	@Override
	public List<SystemFunctionSet> getByFilter(SystemFunctionSet functionSet)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
