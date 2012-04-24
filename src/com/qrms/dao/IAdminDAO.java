package com.qrms.dao;

import java.util.List;

import com.qrms.bean.Admin;

/**
 * Description: This is the interface of IAdmin DAO.It provides some methods to
 * interact with the database related to admin.
 * 
 * @author YinShunMing & WangXing
 * @version 1.0
 */
public interface IAdminDAO {

	public abstract void save(Admin transientInstance);

	public abstract void delete(Admin persistentInstance);

	public abstract Admin findById(java.lang.Integer id);

	public abstract List findByExample(Admin instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByUsername(Object username);

	public abstract List findByPassword(Object password);

	public abstract List findByEmail(Object email);

	public abstract List findAll();

	public abstract Admin merge(Admin detachedInstance);

	public abstract void attachDirty(Admin instance);

	public abstract void attachClean(Admin instance);

}