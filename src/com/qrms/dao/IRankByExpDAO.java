package com.qrms.dao;

import java.util.List;

import com.qrms.bean.RankByExp;

/**
 * Description: This is the interface of RankByExpDAOImpl. It provides methods
 * to interact with the related tables
 * 
 * @author ZhangZu & Zhaolu
 * @version 1.0
 */
public interface IRankByExpDAO {

	public abstract void save(RankByExp transientInstance);

	public abstract void delete(RankByExp persistentInstance);

	public abstract RankByExp findById(java.lang.Integer id);

	public abstract List findByExample(RankByExp instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByExp(Object exp);

	public abstract List findBySetupnum(Object setupnum);

	public abstract List findByOccupyingnum(Object occupyingnum);

	public abstract List findByName(Object name);

	public abstract List findAll();

	public abstract RankByExp merge(RankByExp detachedInstance);

	public abstract void attachDirty(RankByExp instance);

	public abstract void attachClean(RankByExp instance);

}