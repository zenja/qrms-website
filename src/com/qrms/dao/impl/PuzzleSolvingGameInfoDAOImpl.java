package com.qrms.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.qrms.bean.PuzzleSolvingGameInfo;
import com.qrms.dao.IPuzzleSolvingGameInfoDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * TblPuzzlesolvinggameinfo entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.qrms.bean.PuzzleSolvingGameInfo
 * @author MyEclipse Persistence Tools
 * 
 *         modified by wangxing at 2010-12-9 --delete several fields
 */

public class PuzzleSolvingGameInfoDAOImpl extends HibernateDaoSupport implements
		IPuzzleSolvingGameInfoDAO {
	private static final Log log = LogFactory
			.getLog(PuzzleSolvingGameInfoDAOImpl.class);
	// property constants
	public static final String GAME_NAME = "gameName";
	public static final String PICTURE_URL = "pictureUrl";
	public static final String NATION = "nation";
	public static final String PROVINCE = "province";
	public static final String DIFFICULTY_LEVEL = "difficultyLevel";
	public static final String TERRAIN_LEVEL = "terrainLevel";
	public static final String LONG_DESCRIPTION = "longDescription";
	public static final String HINT = "hint";
	public static final String LONGITUDE = "longitude";
	public static final String LATITUDE = "latitude";
	public static final String QR_NUM = "qrNum";
	public static final String CITY = "city";
	public static final String DEFAULT_LL = "defaultLL";

	public static final double EarthEquatorialRadiusInMeters = 6371000;

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seecom.qrms.dao.impl.IPuzzleSolvingGameInfoDAO#save(com.qrms.bean.
	 * PuzzleSolvingGameInfo)
	 */
	public void save(PuzzleSolvingGameInfo transientInstance) {
		log.debug("saving TblPuzzlesolvinggameinfo instance");
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
	 * @seecom.qrms.dao.impl.IPuzzleSolvingGameInfoDAO#delete(com.qrms.bean.
	 * PuzzleSolvingGameInfo)
	 */
	public void delete(PuzzleSolvingGameInfo persistentInstance) {
		log.debug("deleting TblPuzzlesolvinggameinfo instance");
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
	 * @see
	 * com.qrms.dao.impl.IPuzzleSolvingGameInfoDAO#findById(java.lang.Integer)
	 */
	public PuzzleSolvingGameInfo findById(java.lang.Integer id) {
		log.debug("getting TblPuzzlesolvinggameinfo instance with id: " + id);
		try {
			PuzzleSolvingGameInfo instance = (PuzzleSolvingGameInfo) getHibernateTemplate()
					.get("com.qrms.bean.PuzzleSolvingGameInfo", id);
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
	 * com.qrms.dao.impl.IPuzzleSolvingGameInfoDAO#findByExample(com.qrms.bean
	 * .PuzzleSolvingGameInfo)
	 */
	@SuppressWarnings("unchecked")
	public List findByExample(PuzzleSolvingGameInfo instance) {
		log.debug("finding TblPuzzlesolvinggameinfo instance by example");
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
	 * com.qrms.dao.impl.IPuzzleSolvingGameInfoDAO#findByProperty(java.lang.
	 * String, java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding PuzzleSolvingGameInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from PuzzleSolvingGameInfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByArea(double latitude, double longitude, double radius) {
		log.debug("finding puzzleSolvingGameInfo instance with area:latitude:"
				+ latitude + ",longitude:" + longitude + ",radians:" + radius);
		try {
			double theta = (1000 * radius * 360)
					/ (Math.PI * 2 * EarthEquatorialRadiusInMeters);
			double maxLat = latitude + theta;
			double minLat = latitude - theta;
			double maxLong = longitude + theta;
			double minLong = longitude - theta;
			String queryString = "from PuzzleSolvingGameInfo as model where model.latitude between "
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.IPuzzleSolvingGameInfoDAO#findByGameName(java.lang.
	 * Object)
	 */
	@SuppressWarnings("unchecked")
	public List findByGameName(Object gameName) {
		return findByProperty(GAME_NAME, gameName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.IPuzzleSolvingGameInfoDAO#findByPictureUrl(java.lang
	 * .Object)
	 */
	@SuppressWarnings("unchecked")
	public List findByPictureUrl(Object pictureUrl) {
		return findByProperty(PICTURE_URL, pictureUrl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.IPuzzleSolvingGameInfoDAO#findByNation(java.lang.Object
	 * )
	 */
	@SuppressWarnings("unchecked")
	public List findByNation(Object nation) {
		return findByProperty(NATION, nation);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.IPuzzleSolvingGameInfoDAO#findByProvince(java.lang.
	 * Object)
	 */
	@SuppressWarnings("unchecked")
	public List findByProvince(Object province) {
		return findByProperty(PROVINCE, province);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.IPuzzleSolvingGameInfoDAO#findByDifficultyLevel(java
	 * .lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public List findByDifficultyLevel(Object difficultyLevel) {
		return findByProperty(DIFFICULTY_LEVEL, difficultyLevel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.IPuzzleSolvingGameInfoDAO#findByTerrainLevel(java.lang
	 * .Object)
	 */
	@SuppressWarnings("unchecked")
	public List findByTerrainLevel(Object terrainLevel) {
		return findByProperty(TERRAIN_LEVEL, terrainLevel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.IPuzzleSolvingGameInfoDAO#findByLongDescription(java
	 * .lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public List findByLongDescription(Object longDescription) {
		return findByProperty(LONG_DESCRIPTION, longDescription);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.IPuzzleSolvingGameInfoDAO#findByHint(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public List findByHint(Object hint) {
		return findByProperty(HINT, hint);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.IPuzzleSolvingGameInfoDAO#findByLongitude(java.lang
	 * .Object)
	 */
	@SuppressWarnings("unchecked")
	public List findByLongitude(Object longitude) {
		return findByProperty(LONGITUDE, longitude);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.IPuzzleSolvingGameInfoDAO#findByLatitude(java.lang.
	 * Object)
	 */
	@SuppressWarnings("unchecked")
	public List findByLatitude(Object latitude) {
		return findByProperty(LATITUDE, latitude);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.IPuzzleSolvingGameInfoDAO#findByQrNum(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public List findByQrNum(Object qrNum) {
		return findByProperty(QR_NUM, qrNum);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qrms.dao.impl.IPuzzleSolvingGameInfoDAO#findByCity(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public List findByCity(Object city) {
		return findByProperty(CITY, city);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qrms.dao.impl.IPuzzleSolvingGameInfoDAO#findAll()
	 */
	@SuppressWarnings("unchecked")
	public List findAll() {
		log.debug("finding all PuzzleSolvingGameInfo instances");
		try {
			String queryString = "from PuzzleSolvingGameInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seecom.qrms.dao.impl.IPuzzleSolvingGameInfoDAO#merge(com.qrms.bean.
	 * PuzzleSolvingGameInfo)
	 */
	public PuzzleSolvingGameInfo merge(PuzzleSolvingGameInfo detachedInstance) {
		log.debug("merging PuzzleSolvingGameInfo instance");
		try {
			PuzzleSolvingGameInfo result = (PuzzleSolvingGameInfo) getHibernateTemplate()
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
	 * @see
	 * com.qrms.dao.impl.IPuzzleSolvingGameInfoDAO#attachDirty(com.qrms.bean
	 * .PuzzleSolvingGameInfo)
	 */
	public void attachDirty(PuzzleSolvingGameInfo instance) {
		log.debug("attaching dirty PuzzleSolvingGameInfo instance");
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
	 * com.qrms.dao.impl.IPuzzleSolvingGameInfoDAO#attachClean(com.qrms.bean
	 * .PuzzleSolvingGameInfo)
	 */
	public void attachClean(PuzzleSolvingGameInfo instance) {
		log.debug("attaching clean PuzzleSolvingGameInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IPuzzleSolvingGameInfoDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IPuzzleSolvingGameInfoDAO) ctx
				.getBean("PuzzleSolvingGameInfoDAO");
	}

	/**
	 * add by wangxing at 2010-12-9
	 */
	@SuppressWarnings("unchecked")
	public List<PuzzleSolvingGameInfo> findByUserId(Integer userId) {
		return (List<PuzzleSolvingGameInfo>) findByProperty("tblUserinfo.id",
				userId);
	}

	public void update(PuzzleSolvingGameInfo info) {
		this.getHibernateTemplate().update(info);
	}
}