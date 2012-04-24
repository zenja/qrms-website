package com.qrms.action.puzzlesolvinggame;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qrms.bean.GameComment;
import com.qrms.bean.PuzzleSolvingGameInfo;
import com.qrms.bean.User;
import com.qrms.service.IGameCommentService;
import com.qrms.service.IQRContentService;
import com.qrms.service.IShowPuzzleSolvingGameDetailService;
import com.qrms.service.IStaredGameService;

/**
 * Description: The class is designed for user when he/she wants to see the game
 * info.
 * 
 * @author WangXing & YinShunMing
 * @version 2.0
 * 
 * @modify 1: YinShunMing & ZhangZu Description: add making statistics function
 *         which counts different types of game comments
 */

public class ShowPuzzleSolvingGameDetailAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/** service, to be injected */
	private IShowPuzzleSolvingGameDetailService showPuzzleSolvingGameDetailService;

	/** service, to be injected */
	private IGameCommentService gameCommentService;

	/** service, to be injected */
	private IStaredGameService staredGameService;

	/** the id of the game to be showed */
	private Integer gameId;

	private List<GameComment> gameCommentList;

	/** bean, to be retrieved from DB based on gameId */
	private PuzzleSolvingGameInfo puzzleSolvingGameInfo;

	private Boolean isStared; // if the game is stared by the current user in
								// session

	/*
	 * statistics
	 */
	private Integer foundNum;
	private Integer notFoundNum;
	private Integer needMaintenanceNum;

	public Integer getFoundNum() {
		return foundNum;
	}

	public void setFoundNum(Integer foundNum) {
		this.foundNum = foundNum;
	}

	public Integer getNotFoundNum() {
		return notFoundNum;
	}

	public void setNotFoundNum(Integer notFoundNum) {
		this.notFoundNum = notFoundNum;
	}

	public Integer getNeedMaintenanceNum() {
		return needMaintenanceNum;
	}

	public void setNeedMaintenanceNum(Integer needMaintenanceNum) {
		this.needMaintenanceNum = needMaintenanceNum;
	}

	public PuzzleSolvingGameInfo getPuzzleSolvingGameInfo() {
		return puzzleSolvingGameInfo;
	}

	public void setPuzzleSolvingGameInfo(
			PuzzleSolvingGameInfo puzzleSolvingGameInfo) {
		this.puzzleSolvingGameInfo = puzzleSolvingGameInfo;
	}

	public IGameCommentService getGameCommentService() {
		return gameCommentService;
	}

	public void setGameCommentService(IGameCommentService gameCommentService) {
		this.gameCommentService = gameCommentService;
	}

	public List<GameComment> getGameCommentList() {
		return gameCommentList;
	}

	public void setGameCommentList(List<GameComment> gameCommentList) {
		this.gameCommentList = gameCommentList;
	}

	public IShowPuzzleSolvingGameDetailService getShowPuzzleSolvingGameDetailService() {
		return showPuzzleSolvingGameDetailService;
	}

	public void setShowPuzzleSolvingGameDetailService(
			IShowPuzzleSolvingGameDetailService showPuzzleSolvingGameDetailService) {
		this.showPuzzleSolvingGameDetailService = showPuzzleSolvingGameDetailService;
	}

	public IStaredGameService getStaredGameService() {
		return staredGameService;
	}

	public void setStaredGameService(IStaredGameService staredGameService) {
		this.staredGameService = staredGameService;
	}

	public Boolean getIsStared() {
		return isStared;
	}

	public void setIsStared(Boolean isStared) {
		this.isStared = isStared;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	/**
	 * 1.fetch the gameinfo and comments 2.count different types of game
	 * comments
	 * 
	 * @return "showDetail" Show details
	 */
	@Override
	public String execute() throws Exception {
		if (gameId == null) {
			return INPUT;
		}

		/*
		 * fill in puzzleSolvingGameInfo and gameCommentList
		 */
		gameCommentList = gameCommentService
				.getGameCommentListForPuzzleSolvingByGameId(gameId);
		puzzleSolvingGameInfo = showPuzzleSolvingGameDetailService
				.getPuzzleSolvingGameInfoByGameId(gameId);

		/*
		 * fill in isStared
		 */
		ActionContext ctx = ActionContext.getContext();
		User currentUser = (User) ctx.getSession().get("user");
		Integer userId = currentUser.getId();
		isStared = staredGameService.isStared(userId,
				IQRContentService.GAME_TYPE_PUZZLE_SOLVING,
				puzzleSolvingGameInfo.getId());

		/*
		 * make statistics
		 */
		foundNum = 0;
		notFoundNum = 0;
		needMaintenanceNum = 0;
		for (GameComment comment : gameCommentList) {
			if (comment.getCommentType().equals(GameComment.COMMENT_TYPE_FOUND)) {
				foundNum++;
			} else if (comment.getCommentType().equals(
					GameComment.COMMENT_TYPE_NOT_FOUND)) {
				notFoundNum++;
			} else if (comment.getCommentType().equals(
					GameComment.COMMENT_TYPE_NEED_MAINTENANCE)) {
				needMaintenanceNum++;
			}
		}

		return "showDetail";
	}

}
