package com.qrms.dao.impl;

// default package

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.qrms.bean.Achievement;
import com.qrms.dao.IAchievementDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * Achievement entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see .Achievement
 * @author MyEclipse Persistence Tools
 */

public class AchievementDAOImpl extends HibernateDaoSupport implements
		IAchievementDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AchievementDAOImpl.class);
	// property constants
	public static final String USERID = "userid";
	public static final String LEVEL = "level";
	public static final String MONEY = "money";

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IAchievementDAO#save(com.qrms.bean.Achievement)
	 */
	public void save(Achievement transientInstance) {
		log.debug("saving Achievement instance");
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
	 * @see com.qrms.dao.impl.IAchievementDAO#delete(com.qrms.bean.Achievement)
	 */
	public void delete(Achievement persistentInstance) {
		log.debug("deleting Achievement instance");
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
	 * @see com.qrms.dao.impl.IAchievementDAO#findById(java.lang.Integer)
	 */
	public Achievement findById(java.lang.Integer id) {
		log.debug("getting Achievement instance with id: " + id);
		try {
			Achievement instance = (Achievement) getHibernateTemplate().get(
					"com.qrms.bean.Achievement", id);
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
	 * com.qrms.dao.impl.IAchievementDAO#findByExample(com.qrms.bean.Achievement
	 * )
	 */
	public List findByExample(Achievement instance) {
		log.debug("finding Achievement instance by example");
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
	 * @see com.qrms.dao.impl.IAchievementDAO#findByProperty(java.lang.String,
	 * java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Achievement instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Achievement as model where model."
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
	 * @see com.qrms.dao.impl.IAchievementDAO#findByUserid(java.lang.Object)
	 */
	public List findByUserid(Object userid) {
		return findByProperty(USERID, userid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IAchievementDAO#findByLevel(java.lang.Object)
	 */
	public List findByLevel(Object level) {
		return findByProperty(LEVEL, level);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IAchievementDAO#findByMoney(java.lang.Object)
	 */
	public List findByMoney(Object money) {
		return findByProperty(MONEY, money);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IAchievementDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all Achievement instances");
		try {
			String queryString = "from Achievement";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IAchievementDAO#merge(com.qrms.bean.Achievement)
	 */
	public Achievement merge(Achievement detachedInstance) {
		log.debug("merging Achievement instance");
		try {
			Achievement result = (Achievement) getHibernateTemplate().merge(
					detachedInstance);
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
	 * com.qrms.dao.impl.IAchievementDAO#attachDirty(com.qrms.bean.Achievement)
	 */
	public void attachDirty(Achievement instance) {
		log.debug("attaching dirty Achievement instance");
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
	 * com.qrms.dao.impl.IAchievementDAO#attachClean(com.qrms.bean.Achievement)
	 */
	public void attachClean(Achievement instance) {
		log.debug("attaching clean Achievement instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IAchievementDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IAchievementDAO) ctx.getBean("AchievementDAO");
	}

	public void update(Achievement instance) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(instance);
	}
}