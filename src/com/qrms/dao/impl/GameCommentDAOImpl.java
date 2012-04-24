package com.qrms.dao.impl;

// default package

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.qrms.bean.GameComment;
import com.qrms.dao.IGameCommentDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * GameComment entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see .GameComment
 * @author MyEclipse Persistence Tools
 */

public class GameCommentDAOImpl extends HibernateDaoSupport implements
		IGameCommentDAO {
	private static final Logger log = LoggerFactory
			.getLogger(GameCommentDAOImpl.class);
	// property constants
	public static final String GAME_ID = "gameId";
	public static final String GAME_TYPE = "gameType";
	public static final String COMMENT_TYPE = "commentType";

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IGameCommentDAO#save(com.qrms.bean.GameComment)
	 */
	public void save(GameComment transientInstance) {
		log.debug("saving GameComment instance");
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
	 * @see com.qrms.dao.impl.IGameCommentDAO#delete(com.qrms.bean.GameComment)
	 */
	public void delete(GameComment persistentInstance) {
		log.debug("deleting GameComment instance");
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
	 * @see com.qrms.dao.impl.IGameCommentDAO#findById(java.lang.Integer)
	 */
	public GameComment findById(java.lang.Integer id) {
		log.debug("getting GameComment instance with id: " + id);
		try {
			GameComment instance = (GameComment) getHibernateTemplate().get(
					"com.qrms.bean.GameComment", id);
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
	 * com.qrms.dao.impl.IGameCommentDAO#findByExample(com.qrms.bean.GameComment
	 * )
	 */
	public List findByExample(GameComment instance) {
		log.debug("finding GameComment instance by example");
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
	 * @see com.qrms.dao.impl.IGameCommentDAO#findByProperty(java.lang.String,
	 * java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding GameComment instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from GameComment as model where model."
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
	 * @see com.qrms.dao.impl.IGameCommentDAO#findByGameId(java.lang.Object)
	 */
	public List findByGameId(Object gameId) {
		return findByProperty(GAME_ID, gameId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.IGameCommentDAO#findByTextcomment(java.lang.Object)
	 */
	public List findByTextcomment(Object textcomment) {
		return findByProperty(TEXTCOMMENT, textcomment);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IGameCommentDAO#findByPhoto(java.lang.Object)
	 */
	public List findByPhoto(Object photo) {
		return findByProperty(PHOTO, photo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IGameCommentDAO#findByGameType(java.lang.Object)
	 */
	public List findByGameType(Object gameType) {
		return findByProperty(GAME_TYPE, gameType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.IGameCommentDAO#findByCommentType(java.lang.Object)
	 */
	public List findByCommentType(Object commentType) {
		return findByProperty(COMMENT_TYPE, commentType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IGameCommentDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all GameComment instances");
		try {
			String queryString = "from GameComment";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IGameCommentDAO#merge(com.qrms.bean.GameComment)
	 */
	public GameComment merge(GameComment detachedInstance) {
		log.debug("merging GameComment instance");
		try {
			GameComment result = (GameComment) getHibernateTemplate().merge(
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
	 * com.qrms.dao.impl.IGameCommentDAO#attachDirty(com.qrms.bean.GameComment)
	 */
	public void attachDirty(GameComment instance) {
		log.debug("attaching dirty GameComment instance");
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
	 * com.qrms.dao.impl.IGameCommentDAO#attachClean(com.qrms.bean.GameComment)
	 */
	public void attachClean(GameComment instance) {
		log.debug("attaching clean GameComment instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IGameCommentDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IGameCommentDAO) ctx.getBean("gameCommentDAO");
	}

	@SuppressWarnings("unchecked")
	public List<GameComment> findByGameTypeAndGameId(Integer gameType,
			Integer gameId) {
		try {
			String queryString = "from GameComment as model where " + "model."
					+ GAME_TYPE + "= ? and " + "model." + GAME_ID + "= ?";
			return (List<GameComment>) getHibernateTemplate().find(queryString,
					gameType, gameId);
		} catch (RuntimeException re) {
			throw re;
		}
	}
}