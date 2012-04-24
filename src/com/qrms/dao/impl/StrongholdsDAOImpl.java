package com.qrms.dao.impl;

// default package

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.qrms.bean.Strongholds;
import com.qrms.dao.IStrongholdsDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * Strongholds entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see .Strongholds
 * @author MyEclipse Persistence Tools
 */

public class StrongholdsDAOImpl extends HibernateDaoSupport implements
		IStrongholdsDAO {
	private static final Logger log = LoggerFactory
			.getLogger(StrongholdsDAOImpl.class);
	// property constants
	public static final String QRINFO = "qrinfo";
	public static final String LATITUDE = "latitude";
	public static final String LONGITUDE = "longitude";
	public static final String NAME = "name";
	public static final String CITY = "city";
	public static final String PROVINCE = "province";
	public static final String NATION = "nation";
	public static final String SETBY = "setby";
	public static final String OWNERID = "ownerid";
	public static final String HEALTH = "health";

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IStrongholdsDao#save(Strongholds)
	 */
	public void save(Strongholds transientInstance) {
		log.debug("saving Strongholds instance");
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
	 * @see IStrongholdsDao#delete(Strongholds)
	 */
	public void delete(Strongholds persistentInstance) {
		log.debug("deleting Strongholds instance");
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
	 * @see IStrongholdsDao#findById(java.lang.Integer)
	 */
	public Strongholds findById(java.lang.Integer id) {
		log.debug("getting Strongholds instance with id: " + id);
		try {
			Strongholds instance = (Strongholds) getHibernateTemplate().get(
					"com.qrms.bean.Strongholds", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IStrongholdsDao#findByExample(Strongholds)
	 */
	public List findByExample(Strongholds instance) {
		log.debug("finding Strongholds instance by example");
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
	 * @see IStrongholdsDao#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Strongholds instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Strongholds as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPropertyLike(String propertyName, Object value) {
		log.debug("finding Strongholds instance by property" + propertyName
				+ ", like: " + value);
		try {
			String queryString = "from Strongholds as model where model."
					+ propertyName + " like '%" + value + "%'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IStrongholdsDao#findByQrinfo(java.lang.Object)
	 */
	public List findByQrinfo(Object qrinfo) {
		return findByProperty(QRINFO, qrinfo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IStrongholdsDao#findByLatitude(java.lang.Object)
	 */
	public List findByLatitude(Object latitude) {
		return findByProperty(LATITUDE, latitude);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IStrongholdsDao#findByLongitude(java.lang.Object)
	 */
	public List findByLongitude(Object longitude) {
		return findByProperty(LONGITUDE, longitude);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IStrongholdsDao#findByName(java.lang.Object)
	 */
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByNameLike(Object name) {
		return findByPropertyLike(NAME, name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IStrongholdsDao#findByCity(java.lang.Object)
	 */
	public List findByCity(Object city) {
		return findByProperty(CITY, city);
	}

	public List findByCityLike(Object city) {
		return findByPropertyLike(CITY, city);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IStrongholdsDao#findByProvince(java.lang.Object)
	 */
	public List findByProvince(Object province) {
		return findByProperty(PROVINCE, province);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IStrongholdsDao#findByNation(java.lang.Object)
	 */
	public List findByNation(Object nation) {
		return findByProperty(NATION, nation);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IStrongholdsDao#findBySetby(java.lang.Object)
	 */
	public List findBySetby(Object setby) {
		return findByProperty(SETBY, setby);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IStrongholdsDao#findByOwnerid(java.lang.Object)
	 */
	public List findByOwnerid(Object ownerid) {
		return findByProperty(OWNERID, ownerid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IStrongholdsDao#findByHealth(java.lang.Object)
	 */
	public List findByHealth(Object health) {
		return findByProperty(HEALTH, health);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IStrongholdsDao#findAll()
	 */
	public List findAll() {
		log.debug("finding all Strongholds instances");
		try {
			String queryString = "from Strongholds";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IStrongholdsDao#merge(Strongholds)
	 */
	public Strongholds merge(Strongholds detachedInstance) {
		log.debug("merging Strongholds instance");
		try {
			Strongholds result = (Strongholds) getHibernateTemplate().merge(
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
	 * @see IStrongholdsDao#attachDirty(Strongholds)
	 */
	public void attachDirty(Strongholds instance) {
		log.debug("attaching dirty Strongholds instance");
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
	 * @see IStrongholdsDao#attachClean(Strongholds)
	 */
	public void attachClean(Strongholds instance) {
		log.debug("attaching clean Strongholds instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IStrongholdsDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IStrongholdsDAO) ctx.getBean("StrongholdsDAO");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IStrongholdsDao#update(Strongholds)
	 */
	public void update(Strongholds strongholds) {
		this.getHibernateTemplate().update(strongholds);
	}
}