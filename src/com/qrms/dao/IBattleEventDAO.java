package com.qrms.dao;

import java.util.List;

import com.qrms.bean.BattleEvent;

/**
 * Description: This is the interface of battleEventDaoImpl. It provides some
 * methods to interact with the related tables
 * 
 * @author Zhangzu & Zhaolu
 * @version 1.0
 */
public interface IBattleEventDAO {

	public abstract void save(BattleEvent transientInstance);

	public abstract void delete(BattleEvent persistentInstance);

	public abstract BattleEvent findById(java.lang.Integer id);

	public abstract List findByExample(BattleEvent instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByAttackerid(Object attackerid);

	public abstract List findByDefenderid(Object defenderid);

	public abstract List findByStrongholdid(Object strongholdid);

	public abstract List findByEventtype(Object eventtype);

	public abstract List findAll();

	public abstract BattleEvent merge(BattleEvent detachedInstance);

	public abstract void attachDirty(BattleEvent instance);

	public abstract void attachClean(BattleEvent instance);

}