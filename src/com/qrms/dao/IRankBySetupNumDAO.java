package com.qrms.dao;

import java.util.List;

import com.qrms.bean.RankBySetupNum;

/**
 * Description: This is the interface of RankBySetupNumDAOImpl. It provides
 * methods to interact with the related tables
 * 
 * @author ZhangZu & Zhaolu
 * @version 1.0
 */
public interface IRankBySetupNumDAO {

	public abstract void save(RankBySetupNum transientInstance);

	public abstract void delete(RankBySetupNum persistentInstance);

	public abstract RankBySetupNum findById(java.lang.Integer id);

	public abstract List findByExample(RankBySetupNum instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByExp(Object exp);

	public abstract List findBySetupnum(Object setupnum);

	public abstract List findByOccupyingnum(Object occupyingnum);

	public abstract List findByName(Object name);

	public abstract List findAll();

	public abstract RankBySetupNum merge(RankBySetupNum detachedInstance);

	public abstract void attachDirty(RankBySetupNum instance);

	public abstract void attachClean(RankBySetupNum instance);

}