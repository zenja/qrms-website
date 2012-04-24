package com.qrms.dao;

import java.util.List;

import com.qrms.bean.RankByOccupyingNum;

/**
 * Description: This is the interface ofRankByOccupyingNumDAOImpl. It provides
 * methods to interact with the related tables
 * 
 * @author ZhangZu & ZhaoLu
 * @version 1.0
 */
public interface IRankByOccupyingNumDAO {

	public abstract void save(RankByOccupyingNum transientInstance);

	public abstract void delete(RankByOccupyingNum persistentInstance);

	public abstract RankByOccupyingNum findById(java.lang.Integer id);

	public abstract List findByExample(RankByOccupyingNum instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByExp(Object exp);

	public abstract List findBySetupnum(Object setupnum);

	public abstract List findByOccupyingnum(Object occupyingnum);

	public abstract List findByName(Object name);

	public abstract List findAll();

	public abstract RankByOccupyingNum merge(RankByOccupyingNum detachedInstance);

	public abstract void attachDirty(RankByOccupyingNum instance);

	public abstract void attachClean(RankByOccupyingNum instance);

}