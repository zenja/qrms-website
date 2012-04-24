package com.qrms.dao.impl;

// default package

import com.qrms.bean.InspiringGameInfo;
import com.qrms.dao.IInspiringGameInfoDAO;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * InspiringGameInfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see .InspiringGameInfo
 * @author MyEclipse Persistence Tools
 */

public class InspiringGameInfoDAOImpl extends HibernateDaoSupport implements
		IInspiringGameInfoDAO {
	private static final Logger log = LoggerFactory
			.getLogger(InspiringGameInfoDAOImpl.class);
	// property constants
	public static final String GAME_NAME = "gameName";
	public static final String LATITUDE = "latitude";
	public static final String LONGITUDE = "longitude";
	public static final String HINT = "hint";
	public static final String CITY = "city";
	public static final String PROVINCE = "province";
	public static final String NATION = "nation";
	public static final String PICTURE_URL = "pictureUrl";

	public static final double EarthEquatorialRadiusInMeters = 6371000;

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.IInspiringGameInfoDAO#save(com.qrms.bean.InspiringGameInfo
	 * )
	 */
	public void save(InspiringGameInfo transientInstance) {
		log.debug("saving InspiringGameInfo instance");
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
	 * @seecom.qrms.dao.impl.IInspiringGameInfoDAO#delete(com.qrms.bean.
	 * InspiringGameInfo)
	 */
	public void delete(InspiringGameInfo persistentInstance) {
		log.debug("deleting InspiringGameInfo instance");
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
	 * @see com.qrms.dao.impl.IInspiringGameInfoDAO#findById(java.lang.Integer)
	 */
	public InspiringGameInfo findById(java.lang.Integer id) {
		log.debug("getting InspiringGameInfo instance with id: " + id);
		try {
			InspiringGameInfo instance = (InspiringGameInfo) getHibernateTemplate()
					.get("com.qrms.bean.InspiringGameInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seecom.qrms.dao.impl.IInspiringGameInfoDAO#findByExample(com.qrms.bean.
	 * InspiringGameInfo)
	 */
	public List findByExample(InspiringGameInfo instance) {
		log.debug("finding InspiringGameInfo instance by example");
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
	 * com.qrms.dao.impl.IInspiringGameInfoDAO#findByProperty(java.lang.String,
	 * java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding InspiringGameInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from InspiringGameInfo as model where model."
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
	 * com.qrms.dao.impl.IInspiringGameInfoDAO#findByGameName(java.lang.Object)
	 */
	public List findByGameName(Object gameName) {
		return findByProperty(GAME_NAME, gameName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.IInspiringGameInfoDAO#findByLatitude(java.lang.Object)
	 */
	public List findByLatitude(Object latitude) {
		return findByProperty(LATITUDE, latitude);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.IInspiringGameInfoDAO#findByLongitude(java.lang.Object)
	 */
	public List findByLongitude(Object longitude) {
		return findByProperty(LONGITUDE, longitude);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IInspiringGameInfoDAO#findByHint(java.lang.Object)
	 */
	public List findByHint(Object hint) {
		return findByProperty(HINT, hint);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IInspiringGameInfoDAO#findByCity(java.lang.Object)
	 */
	public List findByCity(Object city) {
		return findByProperty(CITY, city);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.IInspiringGameInfoDAO#findByProvince(java.lang.Object)
	 */
	public List findByProvince(Object province) {
		return findByProperty(PROVINCE, province);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.IInspiringGameInfoDAO#findByNation(java.lang.Object)
	 */
	public List findByNation(Object nation) {
		return findByProperty(NATION, nation);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.IInspiringGameInfoDAO#findByPictureUrl(java.lang.Object
	 * )
	 */
	public List findByPictureUrl(Object pictureUrl) {
		return findByProperty(PICTURE_URL, pictureUrl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IInspiringGameInfoDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all InspiringGameInfo instances");
		try {
			String queryString = "from InspiringGameInfo";
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
	 * com.qrms.dao.impl.IInspiringGameInfoDAO#merge(com.qrms.bean.InspiringGameInfo
	 * )
	 */
	public InspiringGameInfo merge(InspiringGameInfo detachedInstance) {
		log.debug("merging InspiringGameInfo instance");
		try {
			InspiringGameInfo result = (InspiringGameInfo) getHibernateTemplate()
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
	 * @seecom.qrms.dao.impl.IInspiringGameInfoDAO#attachDirty(com.qrms.bean.
	 * InspiringGameInfo)
	 */
	public void attachDirty(InspiringGameInfo instance) {
		log.debug("attaching dirty InspiringGameInfo instance");
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
	 * @seecom.qrms.dao.impl.IInspiringGameInfoDAO#attachClean(com.qrms.bean.
	 * InspiringGameInfo)
	 */
	public void attachClean(InspiringGameInfo instance) {
		log.debug("attaching clean InspiringGameInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IInspiringGameInfoDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IInspiringGameInfoDAO) ctx.getBean("InspiringGameInfoDAO");
	}

	/*
	 * (non-Javadoc) extra methods
	 */

	public List findByArea(double latitude, double longitude, double radius) {
		log.debug("finding InspiringGameInfo instance with area:latitude:"
				+ latitude + ",longitude:" + longitude + ",radians:" + radius);
		try {
			double theta = (1000 * radius * 360)
					/ (Math.PI * 2 * EarthEquatorialRadiusInMeters);
			double maxLat = latitude + theta;
			double minLat = latitude - theta;
			double maxLong = longitude + theta;
			double minLong = longitude - theta;
			String queryString = "from InspiringGameInfo as model where model.latitude between "
					+ minLat
					+ " and "
					+ maxLat
					+ " and model.longitude between "
					+ minLong
					+ " and "
					+ maxLong;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/**
	 * add by wangxing at 2010-12-9
	 */
	@SuppressWarnings("unchecked")
	public List<InspiringGameInfo> findByUserId(Integer userId) {
		return (List<InspiringGameInfo>) findByProperty("user.id", userId);
	}

	public void update(InspiringGameInfo gameInfo) {
		this.getHibernateTemplate().update(gameInfo);
	}
}