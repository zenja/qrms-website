package com.qrms.dao.impl;

// default package

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.qrms.bean.BattleEvent;
import com.qrms.dao.IBattleEventDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * BattleEvent entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see .BattleEvent
 * @author MyEclipse Persistence Tools
 */

public class BattleEventDAOImpl extends HibernateDaoSupport implements
		IBattleEventDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BattleEventDAOImpl.class);
	// property constants
	public static final String ATTACKERID = "attackerid";
	public static final String DEFENDERID = "defenderid";
	public static final String STRONGHOLDID = "strongholdid";
	public static final String EVENTTYPE = "eventtype";

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IBattleEventDAO#save(com.qrms.bean.BattleEvent)
	 */
	public void save(BattleEvent transientInstance) {
		log.debug("saving BattleEvent instance");
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
	 * @see com.qrms.dao.impl.IBattleEventDAO#delete(com.qrms.bean.BattleEvent)
	 */
	public void delete(BattleEvent persistentInstance) {
		log.debug("deleting BattleEvent instance");
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
	 * @see com.qrms.dao.impl.IBattleEventDAO#findById(java.lang.Integer)
	 */
	public BattleEvent findById(java.lang.Integer id) {
		log.debug("getting BattleEvent instance with id: " + id);
		try {
			BattleEvent instance = (BattleEvent) getHibernateTemplate().get(
					"com.qrms.bean.BattleEvent", id);
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
	 * com.qrms.dao.impl.IBattleEventDAO#findByExample(com.qrms.bean.BattleEvent
	 * )
	 */
	public List findByExample(BattleEvent instance) {
		log.debug("finding BattleEvent instance by example");
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
	 * @see com.qrms.dao.impl.IBattleEventDAO#findByProperty(java.lang.String,
	 * java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding BattleEvent instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from BattleEvent as model where model."
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
	 * @see com.qrms.dao.impl.IBattleEventDAO#findByAttackerid(java.lang.Object)
	 */
	public List findByAttackerid(Object attackerid) {
		return findByProperty(ATTACKERID, attackerid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IBattleEventDAO#findByDefenderid(java.lang.Object)
	 */
	public List findByDefenderid(Object defenderid) {
		return findByProperty(DEFENDERID, defenderid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.IBattleEventDAO#findByStrongholdid(java.lang.Object)
	 */
	public List findByStrongholdid(Object strongholdid) {
		return findByProperty(STRONGHOLDID, strongholdid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IBattleEventDAO#findByEventtype(java.lang.Object)
	 */
	public List findByEventtype(Object eventtype) {
		return findByProperty(EVENTTYPE, eventtype);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IBattleEventDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all BattleEvent instances");
		try {
			String queryString = "from BattleEvent";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IBattleEventDAO#merge(com.qrms.bean.BattleEvent)
	 */
	public BattleEvent merge(BattleEvent detachedInstance) {
		log.debug("merging BattleEvent instance");
		try {
			BattleEvent result = (BattleEvent) getHibernateTemplate().merge(
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
	 * com.qrms.dao.impl.IBattleEventDAO#attachDirty(com.qrms.bean.BattleEvent)
	 */
	public void attachDirty(BattleEvent instance) {
		log.debug("attaching dirty BattleEvent instance");
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
	 * com.qrms.dao.impl.IBattleEventDAO#attachClean(com.qrms.bean.BattleEvent)
	 */
	public void attachClean(BattleEvent instance) {
		log.debug("attaching clean BattleEvent instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IBattleEventDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IBattleEventDAO) ctx.getBean("BattleEventDAO");
	}
}