package com.qrms.action.staredgame;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qrms.bean.User;
import com.qrms.service.IStaredGameService;

/**
 * Description:This is action when users star a game
 * 
 * @author ZhangZu & WangXing
 * @version 1.0
 */
public class StarGameAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private IStaredGameService staredGameService;

	private Boolean isStared;

	private Integer gameType;

	private Integer gameId;

	// use JSON annotations to mark that this variable doesn't need to
	// serializion
	@JSON(serialize = false)
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

	public Integer getGameType() {
		return gameType;
	}

	public void setGameType(Integer gameType) {
		this.gameType = gameType;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	/**
	 * it just uses service to fetch the user's started games
	 * 
	 * @return SUCCESS if all go right
	 */
	@Override
	public String execute() {
		ActionContext ctx = ActionContext.getContext();
		User currentUser = (User) ctx.getSession().get("user");
		Integer userId = currentUser.getId();

		staredGameService.setStared(isStared, userId, gameType, gameId);
		return SUCCESS;
	}
}
