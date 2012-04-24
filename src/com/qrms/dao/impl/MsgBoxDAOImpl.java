package com.qrms.dao.impl;

// default package

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.qrms.bean.MsgBox;
import com.qrms.dao.IMsgBoxDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * MsgBox entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see .MsgBox
 * @author MyEclipse Persistence Tools
 */

public class MsgBoxDAOImpl extends HibernateDaoSupport implements IMsgBoxDAO {
	private static final Logger log = LoggerFactory
			.getLogger(MsgBoxDAOImpl.class);
	// property constants
	public static final String RECEIVERID = "receiverid";
	public static final String CONTENT = "content";
	public static final String CHECKED = "checked";

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IMsgBoxDAO#save(com.qrms.bean.MsgBox)
	 */
	public void save(MsgBox transientInstance) {
		log.debug("saving MsgBox instance");
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
	 * @see IMsgBoxDAO#delete(com.qrms.bean.MsgBox)
	 */
	public void delete(MsgBox persistentInstance) {
		log.debug("deleting MsgBox instance");
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
	 * @see IMsgBoxDAO#findById(java.lang.Integer)
	 */
	public MsgBox findById(java.lang.Integer id) {
		log.debug("getting MsgBox instance with id: " + id);
		try {
			MsgBox instance = (MsgBox) getHibernateTemplate().get(
					"com.qrms.bean.MsgBox", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IMsgBoxDAO#findByExample(com.qrms.bean.MsgBox)
	 */
	public List findByExample(MsgBox instance) {
		log.debug("finding MsgBox instance by example");
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
	 * @see IMsgBoxDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding MsgBox instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from MsgBox as model where model."
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
	 * @see IMsgBoxDAO#findByReceiverid(java.lang.Object)
	 */
	public List findByReceiverid(Object receiverid) {
		return findByProperty(RECEIVERID, receiverid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IMsgBoxDAO#findByContent(java.lang.Object)
	 */
	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IMsgBoxDAO#findByChecked(java.lang.Object)
	 */
	public List findByChecked(Object checked) {
		return findByProperty(CHECKED, checked);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IMsgBoxDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all MsgBox instances");
		try {
			String queryString = "from MsgBox";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IMsgBoxDAO#merge(com.qrms.bean.MsgBox)
	 */
	public MsgBox merge(MsgBox detachedInstance) {
		log.debug("merging MsgBox instance");
		try {
			MsgBox result = (MsgBox) getHibernateTemplate().merge(
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
	 * @see IMsgBoxDAO#attachDirty(com.qrms.bean.MsgBox)
	 */
	public void attachDirty(MsgBox instance) {
		log.debug("attaching dirty MsgBox instance");
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
	 * @see IMsgBoxDAO#attachClean(com.qrms.bean.MsgBox)
	 */
	public void attachClean(MsgBox instance) {
		log.debug("attaching clean MsgBox instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IMsgBoxDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IMsgBoxDAO) ctx.getBean("MsgBoxDAO");
	}
}