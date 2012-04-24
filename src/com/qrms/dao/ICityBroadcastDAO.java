package com.qrms.dao;

import java.util.List;

import com.qrms.bean.CityBroadcast;

/**
 * Description: This is the interface of CityBroadcastDAOImpl. It provides
 * methods to interact with the related tables
 * 
 * @author Zhangzu & Zhaolu
 * @version 1.0
 */
public interface ICityBroadcastDAO {

	public abstract void save(CityBroadcast transientInstance);

	public abstract void delete(CityBroadcast persistentInstance);

	public abstract CityBroadcast findById(java.lang.Integer id);

	public abstract List findByExample(CityBroadcast instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findBySpeakerid(Object speakerid);

	public abstract List findByCity(Object city);

	public abstract List findByContent(Object content);

	public abstract List findAll();

	public abstract CityBroadcast merge(CityBroadcast detachedInstance);

	public abstract void attachDirty(CityBroadcast instance);

	public abstract void attachClean(CityBroadcast instance);

}