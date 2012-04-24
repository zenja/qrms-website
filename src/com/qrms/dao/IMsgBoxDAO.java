package com.qrms.dao;

import java.util.List;

import com.qrms.bean.MsgBox;

/**
 * Description: This is the interface of MsgBoxDAOImpl. It provides methods to
 * interact with the related tables
 * 
 * @author Wangxing & Yinshunming
 * @version 1.0
 */
public interface IMsgBoxDAO {

	public abstract void save(MsgBox transientInstance);

	public abstract void delete(MsgBox persistentInstance);

	public abstract MsgBox findById(java.lang.Integer id);

	public abstract List findByExample(MsgBox instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByReceiverid(Object receiverid);

	public abstract List findByContent(Object content);

	public abstract List findByChecked(Object checked);

	public abstract List findAll();

	public abstract MsgBox merge(MsgBox detachedInstance);

	public abstract void attachDirty(MsgBox instance);

	public abstract void attachClean(MsgBox instance);

}