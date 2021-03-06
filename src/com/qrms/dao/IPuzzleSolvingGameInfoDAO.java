package com.qrms.dao;

import java.util.List;
import com.qrms.bean.PuzzleSolvingGameInfo;

/**
 * Description: The interface of the PuzzleSolvingGameInfoDAOImpl Generated by
 * MyEclipse Persistence Tools
 * 
 * @author WangXing & Zhaolu
 * @version 1.0
 */
public interface IPuzzleSolvingGameInfoDAO {

	/**
	 * Description: Save the bean to the DB
	 * 
	 * @author WangXing
	 * @param transientInstance
	 *            The bean to be saved in DB
	 * */
	public abstract void save(PuzzleSolvingGameInfo transientInstance);

	/**
	 * Description: Delete the bean from the DB
	 * 
	 * @author WangXing
	 * @param transientInstance
	 *            The bean to be deleted in DB
	 * */
	public abstract void delete(PuzzleSolvingGameInfo persistentInstance);

	/**
	 * Description: Find the bean from the DB according to id
	 * 
	 * @author WangXing
	 * @param PuzzleSolvingGameInfo
	 *            The bean which satisfies the condition
	 * */
	public abstract PuzzleSolvingGameInfo findById(java.lang.Integer id);

	/**
	 * Description: Select beans according to given bean
	 * 
	 * @author WangXing
	 * @param transientInstance
	 *            The bean to be saved in DB
	 * @return a list which satisfies the condition
	 * */
	@SuppressWarnings("unchecked")
	public abstract List findByExample(PuzzleSolvingGameInfo instance);

	/**
	 * Description: Select beans according to given property
	 * 
	 * @author WangXing
	 * @param propertyName
	 *            The property's name
	 * @param value
	 *            The value of the property
	 * @return a list which satisfies the condition
	 * */
	@SuppressWarnings("unchecked")
	public abstract List findByProperty(String propertyName, Object value);

	@SuppressWarnings("unchecked")
	public abstract List findByArea(double latitude, double longitude,
			double radius);

	/**
	 * Description: Select beans according to game name
	 * 
	 * @author WangXing
	 * @param gameName
	 *            The name of the game
	 * @return a list which satisfies the condition
	 * */
	@SuppressWarnings("unchecked")
	public abstract List findByGameName(Object gameName);

	/**
	 * Description: Select beans according to the pictureUrl
	 * 
	 * @author WangXing
	 * @param pictureUrl
	 *            The value of the pictureUrl
	 * @return a list which satisfies the condition
	 * */
	@SuppressWarnings("unchecked")
	public abstract List findByPictureUrl(Object pictureUrl);

	/**
	 * Description: Select beans according to the nation
	 * 
	 * @author WangXing
	 * @param nation
	 *            The value of the nation
	 * @return a list which satisfies the condition
	 * */
	@SuppressWarnings("unchecked")
	public abstract List findByNation(Object nation);

	/**
	 * Description: Select beans according to the province
	 * 
	 * @author WangXing
	 * @param province
	 *            The value of the province
	 * @return a list which satisfies the condition
	 * */
	@SuppressWarnings("unchecked")
	public abstract List findByProvince(Object province);

	/**
	 * Description: Select beans according to the difficulty level
	 * 
	 * @author WangXing
	 * @param difficultyLevel
	 *            The value of the difficulty level
	 * @return a list which satisfies the condition
	 * */
	@SuppressWarnings("unchecked")
	public abstract List findByDifficultyLevel(Object difficultyLevel);

	/**
	 * Description: Select beans according to the terrain level
	 * 
	 * @author WangXing
	 * @param terrainLevel
	 *            The value of the terrain level
	 * @return a list which satisfies the condition
	 * */
	@SuppressWarnings("unchecked")
	public abstract List findByTerrainLevel(Object terrainLevel);

	/**
	 * Description: Select beans according to the long description
	 * 
	 * @author WangXing
	 * @param longDescription
	 *            The value of the long description
	 * @return a list which satisfies the condition
	 * */
	@SuppressWarnings("unchecked")
	public abstract List findByLongDescription(Object longDescription);

	/**
	 * Description: Select beans according to the hint
	 * 
	 * @author WangXing
	 * @param hint
	 *            The value of the hint
	 * @return a list which satisfies the condition
	 * */
	@SuppressWarnings("unchecked")
	public abstract List findByHint(Object hint);

	/**
	 * Description: Select beans according to the longitude
	 * 
	 * @author WangXing
	 * @param longitude
	 *            The value of the note to longitude
	 * @return a list which satisfies the condition
	 * */
	@SuppressWarnings("unchecked")
	public abstract List findByLongitude(Object longitude);

	/**
	 * Description: Select beans according to the latitude
	 * 
	 * @author WangXing
	 * @param latitude
	 *            The value of the note to latitude
	 * @return a list which satisfies the condition
	 * */
	@SuppressWarnings("unchecked")
	public abstract List findByLatitude(Object latitude);

	/**
	 * Description: Select beans according to the qrNum
	 * 
	 * @author WangXing
	 * @param qrNum
	 *            The value of the note to qrNum
	 * @return a list which satisfies the condition
	 * */
	@SuppressWarnings("unchecked")
	public abstract List findByQrNum(Object qrNum);

	/**
	 * Description: Select beans according to the city
	 * 
	 * @author WangXing
	 * @param city
	 *            The value of the note to city
	 * @return a list which satisfies the condition
	 * */
	@SuppressWarnings("unchecked")
	public abstract List findByCity(Object city);

	/**
	 * Description: Find all beans
	 * 
	 * @author WangXing
	 * @return a list which contains all beans in the table
	 * */
	@SuppressWarnings("unchecked")
	public abstract List findAll();

	/**
	 * add by wangxing at 2010-12-9
	 */
	public List<PuzzleSolvingGameInfo> findByUserId(Integer userId);

	public abstract PuzzleSolvingGameInfo merge(
			PuzzleSolvingGameInfo detachedInstance);

	public abstract void attachDirty(PuzzleSolvingGameInfo instance);

	public abstract void attachClean(PuzzleSolvingGameInfo instance);

	public abstract void update(PuzzleSolvingGameInfo info);

}