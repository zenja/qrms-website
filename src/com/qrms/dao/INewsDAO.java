package com.qrms.dao;

import java.util.List;
import com.qrms.bean.News;

/**
 * Description: This is the interface of NewsDAOImpl. It provides methods to
 * interact with the related tables
 * 
 * @author Yinshunming & Zhangzu
 * @version 1.0
 */
public interface INewsDAO {

	public abstract void save(News transientInstance);

	public abstract void delete(News persistentInstance);

	public abstract News findById(java.lang.Integer id);

	public abstract List findByExample(News instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByTitle(Object title);

	public abstract List findByContent(Object content);

	public abstract List findAll();

	public abstract News merge(News detachedInstance);

	public abstract void attachDirty(News instance);

	public abstract void attachClean(News instance);

}