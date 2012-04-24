package com.qrms.dao.impl;

// default package

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.qrms.bean.RankByOccupyingNum;
import com.qrms.dao.IRankByOccupyingNumDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * RankByOccupyingNum entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see .RankByOccupyingNum
 * @author MyEclipse Persistence Tools
 */

public class RankByOccupyingNumDAOImpl extends HibernateDaoSupport implements
		IRankByOccupyingNumDAO {
	private static final Logger log = LoggerFactory
			.getLogger(RankByOccupyingNumDAOImpl.class);
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
	 * @see IRankByOccupyingNumDAO#save(com.qrms.bean.RankByOccupyingNum)
	 */
	public void save(RankByOccupyingNum transientInstance) {
		log.debug("saving RankByOccupyingNum instance");
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
	 * @see IRankByOccupyingNumDAO#delete(com.qrms.bean.RankByOccupyingNum)
	 */
	public void delete(RankByOccupyingNum persistentInstance) {
		log.debug("deleting RankByOccupyingNum instance");
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
	 * @see IRankByOccupyingNumDAO#findById(java.lang.Integer)
	 */
	public RankByOccupyingNum findById(java.lang.Integer id) {
		log.debug("getting RankByOccupyingNum instance with id: " + id);
		try {
			RankByOccupyingNum instance = (RankByOccupyingNum) getHibernateTemplate()
					.get("com.qrms.bean.RankByOccupyingNum", id);
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
	 * IRankByOccupyingNumDAO#findByExample(com.qrms.bean.RankByOccupyingNum)
	 */
	public List findByExample(RankByOccupyingNum instance) {
		log.debug("finding RankByOccupyingNum instance by example");
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
	 * @see IRankByOccupyingNumDAO#findByProperty(java.lang.String,
	 * java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding RankByOccupyingNum instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from RankByOccupyingNum as model where model."
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
	 * @see IRankByOccupyingNumDAO#findByExp(java.lang.Object)
	 */
	public List findByExp(Object exp) {
		return findByProperty(EXP, exp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IRankByOccupyingNumDAO#findBySetupnum(java.lang.Object)
	 */
	public List findBySetupnum(Object setupnum) {
		return findByProperty(SETUPNUM, setupnum);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IRankByOccupyingNumDAO#findByOccupyingnum(java.lang.Object)
	 */
	public List findByOccupyingnum(Object occupyingnum) {
		return findByProperty(OCCUPYINGNUM, occupyingnum);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IRankByOccupyingNumDAO#findByName(java.lang.Object)
	 */
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IRankByOccupyingNumDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all RankByOccupyingNum instances");
		try {
			String queryString = "from RankByOccupyingNum";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IRankByOccupyingNumDAO#merge(com.qrms.bean.RankByOccupyingNum)
	 */
	public RankByOccupyingNum merge(RankByOccupyingNum detachedInstance) {
		log.debug("merging RankByOccupyingNum instance");
		try {
			RankByOccupyingNum result = (RankByOccupyingNum) getHibernateTemplate()
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
	 * @see IRankByOccupyingNumDAO#attachDirty(com.qrms.bean.RankByOccupyingNum)
	 */
	public void attachDirty(RankByOccupyingNum instance) {
		log.debug("attaching dirty RankByOccupyingNum instance");
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
	 * @see IRankByOccupyingNumDAO#attachClean(com.qrms.bean.RankByOccupyingNum)
	 */
	public void attachClean(RankByOccupyingNum instance) {
		log.debug("attaching clean RankByOccupyingNum instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IRankByOccupyingNumDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IRankByOccupyingNumDAO) ctx.getBean("RankByOccupyingNumDAO");
	}
}