package com.qrms.dao.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.qrms.bean.UserNotValidatedInfo;
import com.qrms.dao.IUSerNotValidatedInfoDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * UserNotValidatedInfo entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.qrms.bean.UserNotValidatedInfo
 * @author MyEclipse Persistence Tools
 */

public class UserNotValidatedInfoDAOImpl extends HibernateDaoSupport implements
		IUSerNotValidatedInfoDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UserNotValidatedInfoDAOImpl.class);
	// property constants
	public static final String ENCRYPTKEY = "encryptkey";
	public static final String LOGIN_EMAIL = "loginEmail";
	public static final String PASSWORD = "password";
	public static final String NAME = "name";

	protected void initDao() {
		// do nothing
	}

	public static UserNotValidatedInfoDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (UserNotValidatedInfoDAOImpl) ctx
				.getBean("UserNotValidatedInfoDAO");
	}

	public void save(UserNotValidatedInfo transientInstance) {
		log.debug("saving UserNotValidatedInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UserNotValidatedInfo persistentInstance) {
		log.debug("deleting UserNotValidatedInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding UserNotValidatedInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from UserNotValidatedInfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<UserNotValidatedInfo> findByEncryptkey(Object encryptkey) {
		return findByProperty(ENCRYPTKEY, encryptkey);
	}

	@SuppressWarnings("unchecked")
	public List<UserNotValidatedInfo> findByLoginEmail(String loginEmail) {
		return findByProperty(LOGIN_EMAIL, loginEmail);
	}

	// public UserNotValidatedInfo findById(java.lang.Integer id) {
	// log.debug("getting UserNotValidatedInfo instance with id: " + id);
	// try {
	// UserNotValidatedInfo instance = (UserNotValidatedInfo)
	// getHibernateTemplate()
	// .get("com.qrms.bean.UserNotValidatedInfo", id);
	// return instance;
	// } catch (RuntimeException re) {
	// log.error("get failed", re);
	// throw re;
	// }
	// }

	// @SuppressWarnings("unchecked")
	// public List findByExample(UserNotValidatedInfo instance) {
	// log.debug("finding UserNotValidatedInfo instance by example");
	// try {
	// List results = getHibernateTemplate().findByExample(instance);
	// log.debug("find by example successful, result size: "
	// + results.size());
	// return results;
	// } catch (RuntimeException re) {
	// log.error("find by example failed", re);
	// throw re;
	// }
	// }

	// @SuppressWarnings("unchecked")
	// public List findByPassword(Object password) {
	// return findByProperty(PASSWORD, password);
	// }

	// @SuppressWarnings("unchecked")
	// public List findByName(Object name) {
	// return findByProperty(NAME, name);
	// }

	// @SuppressWarnings("unchecked")
	// public List findAll() {
	// log.debug("finding all UserNotValidatedInfo instances");
	// try {
	// String queryString = "from UserNotValidatedInfo";
	// return getHibernateTemplate().find(queryString);
	// } catch (RuntimeException re) {
	// log.error("find all failed", re);
	// throw re;
	// }
	// }

	// public UserNotValidatedInfo merge(
	// UserNotValidatedInfo detachedInstance) {
	// log.debug("merging UserNotValidatedInfo instance");
	// try {
	// UserNotValidatedInfo result = (UserNotValidatedInfo)
	// getHibernateTemplate()
	// .merge(detachedInstance);
	// log.debug("merge successful");
	// return result;
	// } catch (RuntimeException re) {
	// log.error("merge failed", re);
	// throw re;
	// }
	// }

	// public void attachDirty(UserNotValidatedInfo instance) {
	// log.debug("attaching dirty UserNotValidatedInfo instance");
	// try {
	// getHibernateTemplate().saveOrUpdate(instance);
	// log.debug("attach successful");
	// } catch (RuntimeException re) {
	// log.error("attach failed", re);
	// throw re;
	// }
	// }

	// public void attachClean(UserNotValidatedInfo instance) {
	// log.debug("attaching clean UserNotValidatedInfo instance");
	// try {
	// getHibernateTemplate().lock(instance, LockMode.NONE);
	// log.debug("attach successful");
	// } catch (RuntimeException re) {
	// log.error("attach failed", re);
	// throw re;
	// }
	// }
}