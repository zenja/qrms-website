package com.qrms.dao;

import java.util.List;

import com.qrms.bean.GameComment;

/**
 * Description: This is the interface of GameCommentDAOImpl. It provides methods
 * to interact with the related tables
 * 
 * @author Zhangzu & Zhaolu
 * @version 1.0
 */
public interface IGameCommentDAO {

	public static final String TEXTCOMMENT = "textcomment";
	public static final String PHOTO = "photo";

	public abstract void save(GameComment transientInstance);

	public abstract void delete(GameComment persistentInstance);

	public abstract GameComment findById(java.lang.Integer id);

	public abstract List findByExample(GameComment instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByGameId(Object gameId);

	public abstract List findByTextcomment(Object textcomment);

	public abstract List findByPhoto(Object photo);

	public abstract List findByGameType(Object gameType);

	public abstract List findByCommentType(Object commentType);

	public abstract List findAll();

	public abstract GameComment merge(GameComment detachedInstance);

	public abstract void attachDirty(GameComment instance);

	public abstract void attachClean(GameComment instance);

	public abstract List<GameComment> findByGameTypeAndGameId(Integer gameType,
			Integer gameId);

}