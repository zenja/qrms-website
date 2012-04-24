package com.qrms.dao;

import java.util.List;

import com.qrms.bean.ErrorReport;

/**
 * Description: This is the interface of ErrorReportDAOImpl. It provides methods
 * to interact with the related tables.
 * 
 * @author Zhangzu & Zhaolu
 * @version 1.0
 */
public interface IErrorReportDAO {

	public abstract void save(ErrorReport transientInstance);

	public abstract void delete(ErrorReport persistentInstance);

	public abstract ErrorReport findById(java.lang.Integer id);

	public abstract List findByExample(ErrorReport instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByStrongholdid(Object strongholdid);

	public abstract List findByReporterid(Object reporterid);

	public abstract List findByErrormsg(Object errormsg);

	public abstract List findAll();

	public abstract ErrorReport merge(ErrorReport detachedInstance);

	public abstract void attachDirty(ErrorReport instance);

	public abstract void attachClean(ErrorReport instance);

}