package com.qrms.dao;

import java.util.List;

import com.qrms.bean.QRContent;

/**
 * Description: This is the interface of QRContentDAOImpl. It provides methods
 * to interact with the related tables
 * 
 * @author Wangxing & Yinshunming
 * @version 1.0
 */
public interface IQRContentDAO {

	public abstract void save(QRContent transientInstance);

	public abstract void delete(QRContent persistentInstance);

	public abstract QRContent findById(java.lang.Integer id);

	public abstract List findByExample(QRContent instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByType(Object type);

	public abstract List findByCode(Object code);

	public abstract List findByContent(Object content);

	public abstract List findByGameId(Object gameId);

	public abstract List findAll();

	public abstract QRContent merge(QRContent detachedInstance);

	public abstract void attachDirty(QRContent instance);

	public abstract void attachClean(QRContent instance);

	public abstract void update(QRContent theQRContent);

	public abstract List<QRContent> findByGameTypeAndGameId(Integer gameType,
			Integer gameId);

}