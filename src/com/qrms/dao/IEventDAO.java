package com.qrms.dao;

import java.util.List;

import com.qrms.bean.Event;

/**
 * Description: This is the interface of CityBroadcastDAOImpl. It provides
 * methods to interact with the related tables
 * 
 * @author Zhangzu & Zhaolu
 * @version 1.0
 */
public interface IEventDAO {

	public abstract void save(Event transientInstance);

	public abstract void delete(Event persistentInstance);

	public abstract Event findById(java.lang.Integer id);

	public abstract List findByExample(Event instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByTitle(Object title);

	public abstract List findByContent(Object content);

	public abstract List findAll();

	public abstract Event merge(Event detachedInstance);

	public abstract void attachDirty(Event instance);

	public abstract void attachClean(Event instance);

}