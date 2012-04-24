package com.qrms.dao.impl;

// default package

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.qrms.bean.CityBroadcast;
import com.qrms.dao.ICityBroadcastDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * CityBroadcast entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see .CityBroadcast
 * @author MyEclipse Persistence Tools
 */

public class CityBroadcastDAOImpl extends HibernateDaoSupport implements
		ICityBroadcastDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CityBroadcastDAOImpl.class);
	// property constants
	public static final String SPEAKERID = "speakerid";
	public static final String CITY = "city";
	public static final String CONTENT = "content";

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.ICityBroadcastDAO#save(com.qrms.bean.CityBroadcast)
	 */
	public void save(CityBroadcast transientInstance) {
		log.debug("saving CityBroadcast instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.ICityBroadcastDAO#delete(com.qrms.bean.CityBroadcast)
	 */
	public void delete(CityBroadcast persistentInstance) {
		log.debug("deleting CityBroadcast instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.ICityBroadcastDAO#findById(java.lang.Integer)
	 */
	public CityBroadcast findById(java.lang.Integer id) {
		log.debug("getting CityBroadcast instance with id: " + id);
		try {
			CityBroadcast instance = (CityBroadcast) getHibernateTemplate()
					.get("com.qrms.bean.CityBroadcast", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.ICityBroadcastDAO#findByExample(com.qrms.bean.CityBroadcast
	 * )
	 */
	public List findByExample(CityBroadcast instance) {
		log.debug("finding CityBroadcast instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.ICityBroadcastDAO#findByProperty(java.lang.String,
	 * java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding CityBroadcast instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CityBroadcast as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.ICityBroadcastDAO#findBySpeakerid(java.lang.Object)
	 */
	public List findBySpeakerid(Object speakerid) {
		return findByProperty(SPEAKERID, speakerid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.ICityBroadcastDAO#findByCity(java.lang.Object)
	 */
	public List findByCity(Object city) {
		return findByProperty(CITY, city);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.ICityBroadcastDAO#findByContent(java.lang.Object)
	 */
	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.ICityBroadcastDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all CityBroadcast instances");
		try {
			String queryString = "from CityBroadcast";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.ICityBroadcastDAO#merge(com.qrms.bean.CityBroadcast)
	 */
	public CityBroadcast merge(CityBroadcast detachedInstance) {
		log.debug("merging CityBroadcast instance");
		try {
			CityBroadcast result = (CityBroadcast) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.ICityBroadcastDAO#attachDirty(com.qrms.bean.CityBroadcast
	 * )
	 */
	public void attachDirty(CityBroadcast instance) {
		log.debug("attaching dirty CityBroadcast instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.ICityBroadcastDAO#attachClean(com.qrms.bean.CityBroadcast
	 * )
	 */
	public void attachClean(CityBroadcast instance) {
		log.debug("attaching clean CityBroadcast instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ICityBroadcastDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ICityBroadcastDAO) ctx.getBean("CityBroadcastDAO");
	}
}