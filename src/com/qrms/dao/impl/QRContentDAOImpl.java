package com.qrms.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.qrms.bean.QRContent;
import com.qrms.dao.IQRContentDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * QRContent entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see .QRContent
 * @author MyEclipse Persistence Tools
 */

public class QRContentDAOImpl extends HibernateDaoSupport implements
		IQRContentDAO {
	private static final Logger log = LoggerFactory
			.getLogger(QRContentDAOImpl.class);
	// property constants
	public static final String TYPE = "type";
	public static final String CODE = "code";
	public static final String CONTENT = "content";
	public static final String GAME_ID = "gameId";
	public static final String SEQUENCE = "sequence";

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IQRContentDAO#save(com.qrms.bean.QRContent)
	 */
	public void save(QRContent transientInstance) {
		log.debug("saving QRContent instance");
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
	 * @see com.qrms.dao.impl.IQRContentDAO#delete(com.qrms.bean.QRContent)
	 */
	public void delete(QRContent persistentInstance) {
		log.debug("deleting QRContent instance");
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
	 * @see com.qrms.dao.impl.IQRContentDAO#findById(java.lang.Integer)
	 */
	public QRContent findById(java.lang.Integer id) {
		log.debug("getting QRContent instance with id: " + id);
		try {
			QRContent instance = (QRContent) getHibernateTemplate().get(
					"com.qrms.bean.QRContent", id);
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
	 * com.qrms.dao.impl.IQRContentDAO#findByExample(com.qrms.bean.QRContent)
	 */
	public List findByExample(QRContent instance) {
		log.debug("finding QRContent instance by example");
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
	 * @see com.qrms.dao.impl.IQRContentDAO#findByProperty(java.lang.String,
	 * java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding QRContent instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from QRContent as model where model."
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
	 * @see com.qrms.dao.impl.IQRContentDAO#findByType(java.lang.Object)
	 */
	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IQRContentDAO#findByCode(java.lang.Object)
	 */
	public List findByCode(Object code) {
		return findByProperty(CODE, code);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IQRContentDAO#findByContent(java.lang.Object)
	 */
	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IQRContentDAO#findByGameId(java.lang.Object)
	 */
	public List findByGameId(Object gameId) {
		return findByProperty(GAME_ID, gameId);
	}

	public List findBySequence(Object sequence) {
		return findByProperty(SEQUENCE, sequence);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IQRContentDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all QRContent instances");
		try {
			String queryString = "from QRContent";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IQRContentDAO#merge(com.qrms.bean.QRContent)
	 */
	public QRContent merge(QRContent detachedInstance) {
		log.debug("merging QRContent instance");
		try {
			QRContent result = (QRContent) getHibernateTemplate().merge(
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
	 * @see com.qrms.dao.impl.IQRContentDAO#attachDirty(com.qrms.bean.QRContent)
	 */
	public void attachDirty(QRContent instance) {
		log.debug("attaching dirty QRContent instance");
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
	 * @see com.qrms.dao.impl.IQRContentDAO#attachClean(com.qrms.bean.QRContent)
	 */
	public void attachClean(QRContent instance) {
		log.debug("attaching clean QRContent instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IQRContentDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IQRContentDAO) ctx.getBean("QRContentDAO");
	}

	public void update(QRContent theQRContent) {
		this.getHibernateTemplate().update(theQRContent);
	}

	@SuppressWarnings("unchecked")
	public List<QRContent> findByGameTypeAndGameId(Integer gameType,
			Integer gameId) {
		try {
			String queryString = "from QRContent as model where " + "model."
					+ TYPE + "= ? and " + "model." + GAME_ID + "= ?";
			return (List<QRContent>) getHibernateTemplate().find(queryString,
					gameType, gameId);
		} catch (RuntimeException re) {
			throw re;
		}
	}
}