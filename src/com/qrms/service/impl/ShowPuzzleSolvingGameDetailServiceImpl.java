package com.qrms.service.impl;

import java.util.List;

import com.qrms.bean.PuzzleSolvingGameInfo;
import com.qrms.dao.IPuzzleSolvingGameInfoDAO;
import com.qrms.service.IShowPuzzleSolvingGameDetailService;

/**
 * Descroption: The implemement of the interface It uses DAO Object to find and
 * save info in the puzzleSolvingGameInfo
 * 
 * @author Wangxing & Zhangzu
 * @version 2.0
 *  modified 1: by wangxing & Zhangzu 
 * Description:add some new methods: 1.
 *          getPuzzleSolvingGameInfoByUserId
 */

public class ShowPuzzleSolvingGameDetailServiceImpl implements
		IShowPuzzleSolvingGameDetailService {

	private IPuzzleSolvingGameInfoDAO puzzleSolvingGameInfoDAO;

	public IPuzzleSolvingGameInfoDAO getPuzzleSolvingGameInfoDAO() {
		return puzzleSolvingGameInfoDAO;
	}

	public void setPuzzleSolvingGameInfoDAO(
			IPuzzleSolvingGameInfoDAO puzzleSolvingGameInfoDAO) {
		this.puzzleSolvingGameInfoDAO = puzzleSolvingGameInfoDAO;
	}

	public PuzzleSolvingGameInfo getPuzzleSolvingGameInfoByGameId(Integer gameId) {
		return puzzleSolvingGameInfoDAO.findById(gameId);
	}

	/*
	 * new added
	 */
	public List<PuzzleSolvingGameInfo> getPuzzleSolvingGameInfoByUserId(
			Integer userId) {
		List<PuzzleSolvingGameInfo> list = (List<PuzzleSolvingGameInfo>) puzzleSolvingGameInfoDAO
				.findByUserId(userId);

		return list;
	}
}
