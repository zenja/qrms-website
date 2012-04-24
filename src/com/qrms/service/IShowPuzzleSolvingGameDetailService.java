package com.qrms.service;

import java.util.List;

import com.qrms.bean.PuzzleSolvingGameInfo;

/**
 * Description:This is the interface of IShowPuzzleSolvingGameDetailServiceImpl.
 * It mainly has some methods which are get the detailed info of puzzlesolving
 * game
 * 
 * @author ZhaoLu & Wangxing
 * @version 1.0
 */
public interface IShowPuzzleSolvingGameDetailService {

	public abstract PuzzleSolvingGameInfo getPuzzleSolvingGameInfoByGameId(
			Integer gameId);

	public abstract List<PuzzleSolvingGameInfo> getPuzzleSolvingGameInfoByUserId(
			Integer userId);

}