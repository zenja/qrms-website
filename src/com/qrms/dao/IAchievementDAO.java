package com.qrms.dao;

import java.util.List;

import com.qrms.bean.Achievement;

/**
 * Description:This is the interface of achievement Dao. It provides some
 * methods to interact with the database
 * 
 * @author YinShunMing & ZhangZu
 * @version 1.0
 */
public interface IAchievementDAO {

	public abstract void save(Achievement transientInstance);

	public abstract void delete(Achievement persistentInstance);

	public abstract Achievement findById(java.lang.Integer id);

	public abstract List findByExample(Achievement instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByUserid(Object userid);

	public abstract List findByLevel(Object level);

	public abstract List findByMoney(Object money);

	public abstract List findAll();

	public abstract Achievement merge(Achievement detachedInstance);

	public abstract void attachDirty(Achievement instance);

	public abstract void attachClean(Achievement instance);

	public abstract void update(Achievement instance);
}