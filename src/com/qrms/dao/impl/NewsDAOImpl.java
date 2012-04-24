package com.qrms.dao.impl;

// default package

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.qrms.bean.News;
import com.qrms.dao.INewsDAO;

/**
 * A data access object (DAO) providing persistence and search support for News
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see .News
 * @author MyEclipse Persistence Tools
 */

public class NewsDAOImpl extends HibernateDaoSupport implements INewsDAO {
	private static final Logger log = LoggerFactory
			.getLogger(NewsDAOImpl.class);
	// property constants
	public static final String TITLE = "title";
	public static final String CONTENT = "content";

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.INewsDAO#save(com.qrms.bean.News)
	 */
	public void save(News transientInstance) {
		log.debug("saving News instance");
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
	 * @see com.qrms.dao.impl.INewsDAO#delete(com.qrms.bean.News)
	 */
	public void delete(News persistentInstance) {
		log.debug("deleting News instance");
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
	 * @see com.qrms.dao.impl.INewsDAO#findById(java.lang.Integer)
	 */
	public News findById(java.lang.Integer id) {
		log.debug("getting News instance with id: " + id);
		try {
			News instance = (News) getHibernateTemplate().get(
					"com.qrms.bean.News", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.INewsDAO#findByExample(com.qrms.bean.News)
	 */
	public List findByExample(News instance) {
		log.debug("finding News instance by example");
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
	 * @see com.qrms.dao.impl.INewsDAO#findByProperty(java.lang.String,
	 * java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding News instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from News as model where model."
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
	 * @see com.qrms.dao.impl.INewsDAO#findByTitle(java.lang.Object)
	 */
	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.INewsDAO#findByContent(java.lang.Object)
	 */
	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.INewsDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all News instances");
		try {
			String queryString = "from News as model order by model.date desc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.INewsDAO#merge(com.qrms.bean.News)
	 */
	public News merge(News detachedInstance) {
		log.debug("merging News instance");
		try {
			News result = (News) getHibernateTemplate().merge(detachedInstance);
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
	 * @see com.qrms.dao.impl.INewsDAO#attachDirty(com.qrms.bean.News)
	 */
	public void attachDirty(News instance) {
		log.debug("attaching dirty News instance");
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
	 * @see com.qrms.dao.impl.INewsDAO#attachClean(com.qrms.bean.News)
	 */
	public void attachClean(News instance) {
		log.debug("attaching clean News instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static INewsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (INewsDAO) ctx.getBean("NewsDAO");
	}
}