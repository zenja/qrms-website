package com.qrms.dao.impl;

// default package

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.qrms.bean.ErrorReport;
import com.qrms.dao.IErrorReportDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * ErrorReport entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see .ErrorReport
 * @author MyEclipse Persistence Tools
 */

public class ErrorReportDAOImpl extends HibernateDaoSupport implements
		IErrorReportDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ErrorReportDAOImpl.class);
	// property constants
	public static final String STRONGHOLDID = "strongholdid";
	public static final String REPORTERID = "reporterid";
	public static final String ERRORMSG = "errormsg";

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IErrorReportDAO#save(com.qrms.bean.ErrorReport)
	 */
	public void save(ErrorReport transientInstance) {
		log.debug("saving ErrorReport instance");
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
	 * @see com.qrms.dao.impl.IErrorReportDAO#delete(com.qrms.bean.ErrorReport)
	 */
	public void delete(ErrorReport persistentInstance) {
		log.debug("deleting ErrorReport instance");
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
	 * @see com.qrms.dao.impl.IErrorReportDAO#findById(java.lang.Integer)
	 */
	public ErrorReport findById(java.lang.Integer id) {
		log.debug("getting ErrorReport instance with id: " + id);
		try {
			ErrorReport instance = (ErrorReport) getHibernateTemplate().get(
					"com.qrms.bean.ErrorReport", id);
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
	 * com.qrms.dao.impl.IErrorReportDAO#findByExample(com.qrms.bean.ErrorReport
	 * )
	 */
	public List findByExample(ErrorReport instance) {
		log.debug("finding ErrorReport instance by example");
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
	 * @see com.qrms.dao.impl.IErrorReportDAO#findByProperty(java.lang.String,
	 * java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding ErrorReport instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ErrorReport as model where model."
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
	 * @see
	 * com.qrms.dao.impl.IErrorReportDAO#findByStrongholdid(java.lang.Object)
	 */
	public List findByStrongholdid(Object strongholdid) {
		return findByProperty(STRONGHOLDID, strongholdid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IErrorReportDAO#findByReporterid(java.lang.Object)
	 */
	public List findByReporterid(Object reporterid) {
		return findByProperty(REPORTERID, reporterid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IErrorReportDAO#findByErrormsg(java.lang.Object)
	 */
	public List findByErrormsg(Object errormsg) {
		return findByProperty(ERRORMSG, errormsg);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IErrorReportDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all ErrorReport instances");
		try {
			String queryString = "from ErrorReport";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IErrorReportDAO#merge(com.qrms.bean.ErrorReport)
	 */
	public ErrorReport merge(ErrorReport detachedInstance) {
		log.debug("merging ErrorReport instance");
		try {
			ErrorReport result = (ErrorReport) getHibernateTemplate().merge(
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
	 * com.qrms.dao.impl.IErrorReportDAO#attachDirty(com.qrms.bean.ErrorReport)
	 */
	public void attachDirty(ErrorReport instance) {
		log.debug("attaching dirty ErrorReport instance");
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
	 * com.qrms.dao.impl.IErrorReportDAO#attachClean(com.qrms.bean.ErrorReport)
	 */
	public void attachClean(ErrorReport instance) {
		log.debug("attaching clean ErrorReport instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IErrorReportDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IErrorReportDAO) ctx.getBean("ErrorReportDAO");
	}
}