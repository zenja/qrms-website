package com.qrms.dao.impl;

// default package

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.qrms.bean.RankByExp;
import com.qrms.dao.IRankByExpDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * RankByExp entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see .RankByExp
 * @author MyEclipse Persistence Tools
 */

public class RankByExpDAOImpl extends HibernateDaoSupport implements
		IRankByExpDAO {
	private static final Logger log = LoggerFactory
			.getLogger(RankByExpDAOImpl.class);
	// property constants
	public static final String EXP = "exp";
	public static final String SETUPNUM = "setupnum";
	public static final String OCCUPYINGNUM = "occupyingnum";
	public static final String NAME = "name";

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IRankByExpDAO#save(com.qrms.bean.RankByExp)
	 */
	public void save(RankByExp transientInstance) {
		log.debug("saving RankByExp instance");
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
	 * @see IRankByExpDAO#delete(com.qrms.bean.RankByExp)
	 */
	public void delete(RankByExp persistentInstance) {
		log.debug("deleting RankByExp instance");
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
	 * @see IRankByExpDAO#findById(java.lang.Integer)
	 */
	public RankByExp findById(java.lang.Integer id) {
		log.debug("getting RankByExp instance with id: " + id);
		try {
			RankByExp instance = (RankByExp) getHibernateTemplate().get(
					"com.qrms.bean.RankByExp", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IRankByExpDAO#findByExample(com.qrms.bean.RankByExp)
	 */
	public List findByExample(RankByExp instance) {
		log.debug("finding RankByExp instance by example");
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
	 * @see IRankByExpDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding RankByExp instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from RankByExp as model where model."
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
	 * @see IRankByExpDAO#findByExp(java.lang.Object)
	 */
	public List findByExp(Object exp) {
		return findByProperty(EXP, exp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IRankByExpDAO#findBySetupnum(java.lang.Object)
	 */
	public List findBySetupnum(Object setupnum) {
		return findByProperty(SETUPNUM, setupnum);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IRankByExpDAO#findByOccupyingnum(java.lang.Object)
	 */
	public List findByOccupyingnum(Object occupyingnum) {
		return findByProperty(OCCUPYINGNUM, occupyingnum);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IRankByExpDAO#findByName(java.lang.Object)
	 */
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IRankByExpDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all RankByExp instances");
		try {
			String queryString = "from RankByExp";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IRankByExpDAO#merge(com.qrms.bean.RankByExp)
	 */
	public RankByExp merge(RankByExp detachedInstance) {
		log.debug("merging RankByExp instance");
		try {
			RankByExp result = (RankByExp) getHibernateTemplate().merge(
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
	 * @see IRankByExpDAO#attachDirty(com.qrms.bean.RankByExp)
	 */
	public void attachDirty(RankByExp instance) {
		log.debug("attaching dirty RankByExp instance");
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
	 * @see IRankByExpDAO#attachClean(com.qrms.bean.RankByExp)
	 */
	public void attachClean(RankByExp instance) {
		log.debug("attaching clean RankByExp instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IRankByExpDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IRankByExpDAO) ctx.getBean("RankByExpDAO");
	}
}