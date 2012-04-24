package com.qrms.dao;

import java.util.List;

import com.qrms.bean.InspiringGameInfo;

/**
 * Description: This is the interface of InspiringGameInfoImpl. It provides
 * methods to interact with the related tables
 * 
 * @author Wangxing & Zhaolu
 * @version 1.0
 */
public interface IInspiringGameInfoDAO {

	public abstract void save(InspiringGameInfo transientInstance);

	public abstract void delete(InspiringGameInfo persistentInstance);

	public abstract InspiringGameInfo findById(java.lang.Integer id);

	public abstract List findByExample(InspiringGameInfo instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByGameName(Object gameName);

	public abstract List findByLatitude(Object latitude);

	public abstract List findByLongitude(Object longitude);

	public abstract List findByHint(Object hint);

	public abstract List findByCity(Object city);

	public abstract List findByProvince(Object province);

	public abstract List findByNation(Object nation);

	public abstract List findByPictureUrl(Object pictureUrl);

	public abstract List findAll();

	public abstract InspiringGameInfo merge(InspiringGameInfo detachedInstance);

	public abstract void attachDirty(InspiringGameInfo instance);

	public abstract void attachClean(InspiringGameInfo instance);

	// extra methods
	public List findByArea(double latitude, double longitude, double radius);

	/**
	 * add by wangxing at 2010-12-9
	 */
	public List<InspiringGameInfo> findByUserId(Integer userId);

	public void update(InspiringGameInfo gameInfo);

}