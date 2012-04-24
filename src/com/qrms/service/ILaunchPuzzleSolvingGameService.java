package com.qrms.service;

import com.qrms.bean.PuzzleSolvingGameInfo;

/**
 * Description: The interface of the LaunchPuzzleSolvingGameService
 * 
 * @author WangXing & Yinshunming
 * @version 1.0
 */
public interface ILaunchPuzzleSolvingGameService {

	/**
	 * Description: Save the bean to the DB
	 * 
	 * @param info
	 */
	public void save(PuzzleSolvingGameInfo info);

	/**
	 * Description: Update the bean to the DB
	 * 
	 * @param info
	 */
	public void update(PuzzleSolvingGameInfo info);

	/**
	 * Description: Delete the bean from the DB
	 * 
	 * @param info
	 */
	public void delete(PuzzleSolvingGameInfo info);

	/**
	 * Description: Find a bean according to id
	 * 
	 * @param Id
	 *            game's id
	 * @return PuzzleSolvingGameInfo Bean with the id
	 */
	public PuzzleSolvingGameInfo findById(Integer Id);

}
