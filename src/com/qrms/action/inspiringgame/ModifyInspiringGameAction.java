package com.qrms.action.inspiringgame;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qrms.bean.InspiringGameInfo;
import com.qrms.bean.QRContent;
import com.qrms.bean.User;
import com.qrms.service.IInspiringGameService;
import com.qrms.service.IQRContentService;

/**
 * Description£ºThis class is an action.It is for users when he wants to modify
 * inspiring games he has launched
 * 
 * @author Wangxing & Zhangzu
 * @version 1.0
 */
public class ModifyInspiringGameAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private IInspiringGameService inspiringGameService;

	private IQRContentService qrContentService;

	/**
	 * the id of the game to be modified Note: used in showForm() but not used
	 * in modify()!!
	 */
	private Integer gameId;

	/** the modified gameInfo */
	private InspiringGameInfo newGameInfo;

	/** the previous gameInfo */
	private InspiringGameInfo oldGameInfo;

	private String newQrRawContent;

	public IInspiringGameService getInspiringGameService() {
		return inspiringGameService;
	}

	public void setInspiringGameService(
			IInspiringGameService inspiringGameService) {
		this.inspiringGameService = inspiringGameService;
	}

	public IQRContentService getQrContentService() {
		return qrContentService;
	}

	public void setQrContentService(IQRContentService qrContentService) {
		this.qrContentService = qrContentService;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public InspiringGameInfo getNewGameInfo() {
		return newGameInfo;
	}

	public void setNewGameInfo(InspiringGameInfo newGameInfo) {
		this.newGameInfo = newGameInfo;
	}

	public InspiringGameInfo getOldGameInfo() {
		return oldGameInfo;
	}

	public void setOldGameInfo(InspiringGameInfo oldGameInfo) {
		this.oldGameInfo = oldGameInfo;
	}

	public String getNewQrRawContent() {
		return newQrRawContent;
	}

	public void setNewQrRawContent(String newQrRawContent) {
		this.newQrRawContent = newQrRawContent;
	}

	/**
	 * Show the jsp form. Fill in oldGameInfo. oldGameInfo will be used to fill
	 * in the form as original data
	 * 
	 * @return SUCCESS if all go righ 
	 * INPUT if the input is complete
	 */
	public String showForm() {
		if (gameId == null) {
			return INPUT;
		}

		oldGameInfo = inspiringGameService.findGame(gameId);

		return SUCCESS;
	}

	/**
	 * Modify the game
	 * @return INPUT the inputs are not complete or there are errors
	 * ERROR if there is exception of the request
	 * SUCCESS if all go right
	 */
	public String modify() {
		/*
		 * Check info integrity
		 */
		if (newGameInfo == null || newGameInfo.getId() == null) {
			return INPUT;
		}

		// get the old game info
		InspiringGameInfo oldGame = inspiringGameService.findGame(newGameInfo
				.getId());

		/*
		 * Check is the gameInfo is launched by the current user
		 */
		ActionContext ctx = ActionContext.getContext();
		User currentUser = (User) ctx.getSession().get("user");
		Integer currentUserId = currentUser.getId();
		Integer gameLauncherId = oldGame.getUser().getId();
		// Be careful: equals but not ==
		if (gameLauncherId.equals(currentUserId) == false) {
			return ERROR;
		}

		/*
		 * update QRContent object
		 */
		QRContent newQrContent = oldGame.getQrContent();
		newQrContent.setContent(newQrRawContent);
		qrContentService.updateQRContent(newQrContent);

		/*
		 * update InspiringGameInfo object
		 */
		newGameInfo.setQrContent(newQrContent);
		newGameInfo.setUser(oldGame.getUser());
		newGameInfo.setPlaceDate(oldGame.getPlaceDate());
		inspiringGameService.modifyGameInfoByExample(newGameInfo);

		return SUCCESS;
	}

}
