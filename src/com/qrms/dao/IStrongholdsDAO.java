package com.qrms.dao;

import java.util.List;

import com.qrms.bean.Strongholds;

/**
 * Description: This is the interface of StrongholdsDAOImpl. It provides methods
 * to interact with the related tables
 * 
 * @author Zhaolu & Zhangzu
 * @version 1.0
 */
public interface IStrongholdsDAO {

	public abstract void save(Strongholds transientInstance);

	public abstract void delete(Strongholds persistentInstance);

	public abstract Strongholds findById(java.lang.Integer id);

	public abstract List findByExample(Strongholds instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByPropertyLike(String propertyName, Object value);

	public abstract List findByQrinfo(Object qrinfo);

	public abstract List findByLatitude(Object latitude);

	public abstract List findByLongitude(Object longitude);

	public abstract List findByName(Object name);

	public abstract List findByNameLike(Object city);

	public abstract List findByCity(Object city);

	public abstract List findByCityLike(Object city);

	public abstract List findByProvince(Object province);

	public abstract List findByNation(Object nation);

	public abstract List findBySetby(Object setby);

	public abstract List findByOwnerid(Object ownerid);

	public abstract List findByHealth(Object health);

	public abstract List findAll();

	public abstract Strongholds merge(Strongholds detachedInstance);

	public abstract void attachDirty(Strongholds instance);

	public abstract void attachClean(Strongholds instance);

	public abstract void update(Strongholds strongholds);

}