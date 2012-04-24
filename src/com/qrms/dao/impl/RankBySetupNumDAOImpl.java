package com.qrms.dao.impl;

// default package

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.qrms.bean.RankBySetupNum;
import com.qrms.dao.IRankBySetupNumDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * RankBySetupNum entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see .RankBySetupNum
 * @author MyEclipse Persistence Tools
 */

public class RankBySetupNumDAOImpl extends HibernateDaoSupport implements
		IRankBySetupNumDAO {
	private static final Logger log = LoggerFactory
			.getLogger(RankBySetupNumDAOImpl.class);
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
	 * @see IRankBySetupNumDAO#save(com.qrms.bean.RankBySetupNum)
	 */
	public void save(RankBySetupNum transientInstance) {
		log.debug("saving RankBySetupNum instance");
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
	 * @see IRankBySetupNumDAO#delete(com.qrms.bean.RankBySetupNum)
	 */
	public void delete(RankBySetupNum persistentInstance) {
		log.debug("deleting RankBySetupNum instance");
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
	 * @see IRankBySetupNumDAO#findById(java.lang.Integer)
	 */
	public RankBySetupNum findById(java.lang.Integer id) {
		log.debug("getting RankBySetupNum instance with id: " + id);
		try {
			RankBySetupNum instance = (RankBySetupNum) getHibernateTemplate()
					.get("com.qrms.bean.RankBySetupNum", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IRankBySetupNumDAO#findByExample(com.qrms.bean.RankBySetupNum)
	 */
	public List findByExample(RankBySetupNum instance) {
		log.debug("finding RankBySetupNum instance by example");
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
	 * @see IRankBySetupNumDAO#findByProperty(java.lang.String,
	 * java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding RankBySetupNum instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from RankBySetupNum as model where model."
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
	 * @see IRankBySetupNumDAO#findByExp(java.lang.Object)
	 */
	public List findByExp(Object exp) {
		return findByProperty(EXP, exp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IRankBySetupNumDAO#findBySetupnum(java.lang.Object)
	 */
	public List findBySetupnum(Object setupnum) {
		return findByProperty(SETUPNUM, setupnum);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IRankBySetupNumDAO#findByOccupyingnum(java.lang.Object)
	 */
	public List findByOccupyingnum(Object occupyingnum) {
		return findByProperty(OCCUPYINGNUM, occupyingnum);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IRankBySetupNumDAO#findByName(java.lang.Object)
	 */
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IRankBySetupNumDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all RankBySetupNum instances");
		try {
			String queryString = "from RankBySetupNum";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IRankBySetupNumDAO#merge(com.qrms.bean.RankBySetupNum)
	 */
	public RankBySetupNum merge(RankBySetupNum detachedInstance) {
		log.debug("merging RankBySetupNum instance");
		try {
			RankBySetupNum result = (RankBySetupNum) getHibernateTemplate()
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
	 * @see IRankBySetupNumDAO#attachDirty(com.qrms.bean.RankBySetupNum)
	 */
	public void attachDirty(RankBySetupNum instance) {
		log.debug("attaching dirty RankBySetupNum instance");
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
	 * @see IRankBySetupNumDAO#attachClean(com.qrms.bean.RankBySetupNum)
	 */
	public void attachClean(RankBySetupNum instance) {
		log.debug("attaching clean RankBySetupNum instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IRankBySetupNumDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IRankBySetupNumDAO) ctx.getBean("RankBySetupNumDAO");
	}
}