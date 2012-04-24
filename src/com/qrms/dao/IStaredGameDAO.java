package com.qrms.dao;

import java.util.List;

import com.qrms.bean.StaredGame;

/**
 * Description: This is the interface of CityBroadcastDAOImpl. It provides
 * methods to interact with the related tables
 * 
 * @author YinShunMing & Wangxing
 * @version 1.0
 */
public interface IStaredGameDAO {

	public abstract void save(StaredGame transientInstance);

	public abstract void delete(StaredGame persistentInstance);

	public abstract StaredGame findById(java.lang.Integer id);

	public abstract List findByExample(StaredGame instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByGameType(Object gameType);

	public abstract List findByGameId(Object gameId);

	public abstract List findAll();

	public abstract StaredGame merge(StaredGame detachedInstance);

	public abstract void attachDirty(StaredGame instance);

	public abstract void attachClean(StaredGame instance);

	/*
	 * Functions below are added by wangxing
	 */
	public abstract List<StaredGame> findByUserIdAndGameTypeAndGameId(
			Integer userId, int gameType, Integer gameId);

	public abstract List<StaredGame> findByUserId(Integer userId);

}