package com.qrms.service.impl;

import java.util.List;

import com.qrms.bean.GameComment;
import com.qrms.dao.IGameCommentDAO;
import com.qrms.service.IGameCommentService;
import com.qrms.service.IQRContentService;

/**
 * Description: This class is the implemention of the interface
 * IGameCOmmentService It implements some methods related to game comments
 * 
 * @author Yinshunming & Wangxing
 * @version 2.0
 * 
 *          modify 1: Wangxing & Yinshunming Description: add some methods about
 *          InspringMark Game
 */
public class GameCommentServiceImpl implements IGameCommentService {

	/** the dao to do the game comments operation */
	private IGameCommentDAO gameCommentDAO;

	public IGameCommentDAO getGameCommentDAO() {
		return gameCommentDAO;
	}

	public void setGameCommentDAO(IGameCommentDAO gameCommentDAO) {
		this.gameCommentDAO = gameCommentDAO;
	}

	/**
	 * This method fetchs the game comments according to gameType and gameId
	 * 
	 * @param  gameType: the type of the game
	 *@param   gameid: the id of the game
	 *@return the list of the GameComments
	 */
	public List<GameComment> getGameCommentListByGameTypeAndGameId(
			Integer gameType, Integer gameId) {
		return gameCommentDAO.findByGameTypeAndGameId(gameType, gameId);
	}

	/**
	 * This method fetchs the game comments for inspiringMark game
	 * 
	 * @param gameId: the id of the inspiringMark game
	 * @return the list of the game comments
	 */
	public List<GameComment> getGameCommentListForInspiringMarkByGameId(
			Integer gameId) {
		return getGameCommentListByGameTypeAndGameId(
				IQRContentService.GAME_TYPE_INSPIRING_MARK, gameId);
	}

	/**
	 * This method fetchs the game comments for puzzleSolving game
	 * 
	 * @param  gameId: the id of the puzzleSolving game
	 * @return list of the game comments
	 */
	public List<GameComment> getGameCommentListForPuzzleSolvingByGameId(
			Integer gameId) {
		return getGameCommentListByGameTypeAndGameId(
				IQRContentService.GAME_TYPE_PUZZLE_SOLVING, gameId);
	}

	/**
	 * This method save the comment to DB
	 * 
	 * @param gameComment
	 *            : bean
	 */
	public void saveGameComment(GameComment gameComment) {
		gameCommentDAO.save(gameComment);
	}

	/**
	 * This method gets the comments by comment's id
	 * 
	 * @param commentId: the id of the comment
	 * @return GameComment
	 */
	public GameComment getGameCommentByCommentId(Integer commentId) {
		return gameCommentDAO.findById(commentId);
	}

}
