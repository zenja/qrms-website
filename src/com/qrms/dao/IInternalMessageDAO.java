package com.qrms.dao;

import java.util.List;

import com.qrms.bean.InternalMessage;

/**
 * Description: This is the interface of InternalMessageDAOImpl. It provides
 * methods to interact with the related tables
 * 
 * @author ZhangZu & Zhaolu
 * @version 1.0
 */
public interface IInternalMessageDAO {

	public abstract void save(InternalMessage transientInstance);

	public abstract void delete(InternalMessage persistentInstance);

	public abstract InternalMessage findById(java.lang.Integer id);

	public abstract List findByExample(InternalMessage instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByTitle(Object title);

	public abstract List findByContent(Object content);

	public abstract List findAll();

	public abstract InternalMessage merge(InternalMessage detachedInstance);

	public abstract void attachDirty(InternalMessage instance);

	public abstract void attachClean(InternalMessage instance);

	public abstract List<InternalMessage> findByReceiverId(Integer userId);

}