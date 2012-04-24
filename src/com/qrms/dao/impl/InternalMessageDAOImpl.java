package com.qrms.dao.impl;

// default package

import com.qrms.bean.InternalMessage;
import com.qrms.dao.IInternalMessageDAO;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * InternalMessage entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see .InternalMessage
 * @author MyEclipse Persistence Tools
 */

public class InternalMessageDAOImpl extends HibernateDaoSupport implements
		IInternalMessageDAO {
	private static final Logger log = LoggerFactory
			.getLogger(InternalMessageDAOImpl.class);
	// property constants
	public static final String TITLE = "title";
	public static final String CONTENT = "content";
	public static final String RECEIVER_ID = "userByUserTo.id";

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.IInternalMessageDAO#save(com.qrms.bean.InternalMessage)
	 */
	public void save(InternalMessage transientInstance) {
		log.debug("saving InternalMessage instance");
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
	 * @see
	 * com.qrms.dao.impl.IInternalMessageDAO#delete(com.qrms.bean.InternalMessage
	 * )
	 */
	public void delete(InternalMessage persistentInstance) {
		log.debug("deleting InternalMessage instance");
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
	 * @see com.qrms.dao.impl.IInternalMessageDAO#findById(java.lang.Integer)
	 */
	public InternalMessage findById(java.lang.Integer id) {
		log.debug("getting InternalMessage instance with id: " + id);
		try {
			InternalMessage instance = (InternalMessage) getHibernateTemplate()
					.get("com.qrms.bean.InternalMessage", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seecom.qrms.dao.impl.IInternalMessageDAO#findByExample(com.qrms.bean.
	 * InternalMessage)
	 */
	public List findByExample(InternalMessage instance) {
		log.debug("finding InternalMessage instance by example");
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
	 * @see
	 * com.qrms.dao.impl.IInternalMessageDAO#findByProperty(java.lang.String,
	 * java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding InternalMessage instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from InternalMessage as model where model."
					+ propertyName + "= ? order by model.time desc";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IInternalMessageDAO#findByTitle(java.lang.Object)
	 */
	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.IInternalMessageDAO#findByContent(java.lang.Object)
	 */
	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IInternalMessageDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all InternalMessage instances");
		try {
			String queryString = "from InternalMessage";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.IInternalMessageDAO#merge(com.qrms.bean.InternalMessage
	 * )
	 */
	public InternalMessage merge(InternalMessage detachedInstance) {
		log.debug("merging InternalMessage instance");
		try {
			InternalMessage result = (InternalMessage) getHibernateTemplate()
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
	 * @seecom.qrms.dao.impl.IInternalMessageDAO#attachDirty(com.qrms.bean.
	 * InternalMessage)
	 */
	public void attachDirty(InternalMessage instance) {
		log.debug("attaching dirty InternalMessage instance");
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
	 * @seecom.qrms.dao.impl.IInternalMessageDAO#attachClean(com.qrms.bean.
	 * InternalMessage)
	 */
	public void attachClean(InternalMessage instance) {
		log.debug("attaching clean InternalMessage instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IInternalMessageDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IInternalMessageDAO) ctx.getBean("InternalMessageDAO");
	}

	@SuppressWarnings("unchecked")
	public List<InternalMessage> findByReceiverId(Integer userId) {
		return findByProperty(RECEIVER_ID, userId);
	}
}