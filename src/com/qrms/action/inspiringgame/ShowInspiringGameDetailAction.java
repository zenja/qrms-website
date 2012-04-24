package com.qrms.action.inspiringgame;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qrms.bean.GameComment;
import com.qrms.bean.InspiringGameInfo;
import com.qrms.bean.User;
import com.qrms.service.IGameCommentService;
import com.qrms.service.IInspiringGameService;
import com.qrms.service.IQRContentService;
import com.qrms.service.IStaredGameService;

/**
 * Description: It is an action. It controls the logic when user wants to see a
 * detailed info of a specific inspiring game.
 * 
 * @author Yinshunming & Zhaolu
 * @version 2.0
 * 
 * @modify 1: YinShunMing & ZhangZu 
 * Description: add making statistics function
 *         which counts different types of game comments
 */
public class ShowInspiringGameDetailAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/** service to fetch the info of inspiring game */
	private IInspiringGameService inspiringGameService;

	/** service to fetch comments of this game */
	private IGameCommentService gameCommentService;

	private List<GameComment> gameCommentList;

	/** service to detect if this game is started */
	private IStaredGameService staredGameService;

	private InspiringGameInfo gameInfo;

	private Integer gameId;

	private Boolean isStared; // if the game is stared by the current user in
								// session

	/*
	 * statistics about different types of comments
	 */
	private Integer foundNum;
	private Integer notFoundNum;
	private Integer needMaintenanceNum;

	public IInspiringGameService getInspiringGameService() {
		return inspiringGameService;
	}

	public void setInspiringGameService(
			IInspiringGameService inspiringGameService) {
		this.inspiringGameService = inspiringGameService;
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

	public InspiringGameInfo getGameInfo() {
		return gameInfo;
	}

	public void setGameInfo(InspiringGameInfo gameInfo) {
		this.gameInfo = gameInfo;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
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

	/**
	 * 1.find the comments and detailed info of this game 2.find if the game is
	 * stared game 3. make statistics of different types of comments
	 * 
	 * @return INPUT if the inputs are not complete\
	 *  SUCCESS if all go right
	 */
	@Override
	public String execute() {
		if (gameId == null) {
			return INPUT;
		}

		/*
		 * fill in gameInfo and gameCommentList
		 */
		gameCommentList = gameCommentService
				.getGameCommentListForInspiringMarkByGameId(gameId);
		gameInfo = inspiringGameService.findGame(gameId);

		/*
		 * fill in isStared
		 */
		ActionContext ctx = ActionContext.getContext();
		User currentUser = (User) ctx.getSession().get("user");
		Integer userId = currentUser.getId();
		isStared = staredGameService.isStared(userId,
				IQRContentService.GAME_TYPE_INSPIRING_MARK, gameInfo.getId());

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

		return SUCCESS;
	}

}
