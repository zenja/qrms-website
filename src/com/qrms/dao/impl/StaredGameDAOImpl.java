package com.qrms.dao.impl;

// default package

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.qrms.bean.StaredGame;
import com.qrms.dao.IStaredGameDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * StaredGame entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see .StaredGame
 * @author MyEclipse Persistence Tools
 */

public class StaredGameDAOImpl extends HibernateDaoSupport implements
		IStaredGameDAO {
	private static final Logger log = LoggerFactory
			.getLogger(StaredGameDAOImpl.class);
	// property constants
	public static final String GAME_TYPE = "gameType";
	public static final String GAME_ID = "gameId";
	public static final String USER_ID = "user.id"; // added by wangxing

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IStaredGameDAO#save(com.qrms.bean.StaredGame)
	 */
	public void save(StaredGame transientInstance) {
		log.debug("saving StaredGame instance");
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
	 * @see com.qrms.dao.impl.IStaredGameDAO#delete(com.qrms.bean.StaredGame)
	 */
	public void delete(StaredGame persistentInstance) {
		log.debug("deleting StaredGame instance");
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
	 * @see com.qrms.dao.impl.IStaredGameDAO#findById(java.lang.Integer)
	 */
	public StaredGame findById(java.lang.Integer id) {
		log.debug("getting StaredGame instance with id: " + id);
		try {
			StaredGame instance = (StaredGame) getHibernateTemplate().get(
					"com.qrms.bean.StaredGame", id);
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
	 * com.qrms.dao.impl.IStaredGameDAO#findByExample(com.qrms.bean.StaredGame)
	 */
	public List findByExample(StaredGame instance) {
		log.debug("finding StaredGame instance by example");
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
	 * @see com.qrms.dao.impl.IStaredGameDAO#findByProperty(java.lang.String,
	 * java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding StaredGame instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from StaredGame as model where model."
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
	 * @see com.qrms.dao.impl.IStaredGameDAO#findByGameType(java.lang.Object)
	 */
	public List findByGameType(Object gameType) {
		return findByProperty(GAME_TYPE, gameType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IStaredGameDAO#findByGameId(java.lang.Object)
	 */
	public List findByGameId(Object gameId) {
		return findByProperty(GAME_ID, gameId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IStaredGameDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all StaredGame instances");
		try {
			String queryString = "from StaredGame";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IStaredGameDAO#merge(com.qrms.bean.StaredGame)
	 */
	public StaredGame merge(StaredGame detachedInstance) {
		log.debug("merging StaredGame instance");
		try {
			StaredGame result = (StaredGame) getHibernateTemplate().merge(
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
	 * com.qrms.dao.impl.IStaredGameDAO#attachDirty(com.qrms.bean.StaredGame)
	 */
	public void attachDirty(StaredGame instance) {
		log.debug("attaching dirty StaredGame instance");
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
	 * com.qrms.dao.impl.IStaredGameDAO#attachClean(com.qrms.bean.StaredGame)
	 */
	public void attachClean(StaredGame instance) {
		log.debug("attaching clean StaredGame instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IStaredGameDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IStaredGameDAO) ctx.getBean("StaredGameDAO");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.IStaredGameDAO#findByUserIdAndGameTypeAndGameId(java
	 * .lang.Integer, int, java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	public List<StaredGame> findByUserIdAndGameTypeAndGameId(Integer userId,
			int gameType, Integer gameId) {
		try {
			String queryString = "from StaredGame as model where " + "model."
					+ USER_ID + "= ? and " + "model." + GAME_TYPE + "= ? and "
					+ "model." + GAME_ID + "= ?";
			return (List<StaredGame>) getHibernateTemplate().find(queryString,
					userId, gameType, gameId);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<StaredGame> findByUserId(Integer userId) {
		return (List<StaredGame>) findByProperty(USER_ID, userId);
	}
}