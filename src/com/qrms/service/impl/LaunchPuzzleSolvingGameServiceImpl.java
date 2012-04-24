package com.qrms.service.impl;

import com.qrms.bean.PuzzleSolvingGameInfo;
import com.qrms.dao.IPuzzleSolvingGameInfoDAO;
import com.qrms.service.ILaunchPuzzleSolvingGameService;

/**
 * Descroption: The implemement of the interface It uses DAO Object to find and
 * save info in the puzzleSolvingGameInfo
 * 
 * @author Wangxin & Yinshunming
 * @version 1.0
 */

public class LaunchPuzzleSolvingGameServiceImpl implements
		ILaunchPuzzleSolvingGameService {

	public void setPuzzleSolvingGameInfoDAO(
			IPuzzleSolvingGameInfoDAO puzzleSolvingGameInfoDAO) {
		this.puzzleSolvingGameInfoDAO = puzzleSolvingGameInfoDAO;
	}

	/** the dao to operate the operations */
	private IPuzzleSolvingGameInfoDAO puzzleSolvingGameInfoDAO;

	public IPuzzleSolvingGameInfoDAO getPuzzleSolvingGameInfoDAO() {
		return puzzleSolvingGameInfoDAO;
	}

	public void puzzleSolvingGameInfo(
			IPuzzleSolvingGameInfoDAO puzzleSolvingGameInfoDAO) {
		this.puzzleSolvingGameInfoDAO = puzzleSolvingGameInfoDAO;
	}

	public void save(PuzzleSolvingGameInfo info) {
		puzzleSolvingGameInfoDAO.save(info);
	}

	public void delete(PuzzleSolvingGameInfo info) {
		puzzleSolvingGameInfoDAO.delete(info);
	}

	public PuzzleSolvingGameInfo findById(Integer Id) {
		return puzzleSolvingGameInfoDAO.findById(Id);
	}

	public void update(PuzzleSolvingGameInfo info) {
		puzzleSolvingGameInfoDAO.update(info);
	}
}
