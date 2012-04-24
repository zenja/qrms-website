package com.qrms.action.puzzlesolvinggame;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qrms.bean.PuzzleSolvingGameInfo;
import com.qrms.bean.QRContent;
import com.qrms.bean.User;
import com.qrms.service.ILaunchPuzzleSolvingGameService;
import com.qrms.service.IQRContentService;

/**
 * Description:This action is used when someone wants to modify his
 * puzzleSolving Game
 * 
 * @author ZhangZu & YinShunMing
 * @version 1.0
 */
public class ModifyPuzzleSolvingGameAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private ILaunchPuzzleSolvingGameService launchPuzzleSolvingGameService;

	private IQRContentService qrContentService;

	/**
	 * the id of the game to be modified Note: used in showForm() but not used
	 * in modify()!!
	 */
	private Integer gameId;

	/** the modified gameInfo */
	private PuzzleSolvingGameInfo newGameInfo;

	/** the previous gameInfo */
	private PuzzleSolvingGameInfo oldGameInfo;

	private List<String> oldQrRawContentList;

	private List<String> newQrRawContentList;

	public ILaunchPuzzleSolvingGameService getLaunchPuzzleSolvingGameService() {
		return launchPuzzleSolvingGameService;
	}

	public void setLaunchPuzzleSolvingGameService(
			ILaunchPuzzleSolvingGameService launchPuzzleSolvingGameService) {
		this.launchPuzzleSolvingGameService = launchPuzzleSolvingGameService;
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

	public PuzzleSolvingGameInfo getNewGameInfo() {
		return newGameInfo;
	}

	public void setNewGameInfo(PuzzleSolvingGameInfo newGameInfo) {
		this.newGameInfo = newGameInfo;
	}

	public PuzzleSolvingGameInfo getOldGameInfo() {
		return oldGameInfo;
	}

	public void setOldGameInfo(PuzzleSolvingGameInfo oldGameInfo) {
		this.oldGameInfo = oldGameInfo;
	}

	public List<String> getOldQrRawContentList() {
		return oldQrRawContentList;
	}

	public void setOldQrRawContentList(List<String> oldQrRawContentList) {
		this.oldQrRawContentList = oldQrRawContentList;
	}

	public List<String> getNewQrRawContentList() {
		return newQrRawContentList;
	}

	public void setNewQrRawContentList(List<String> newQrRawContentList) {
		this.newQrRawContentList = newQrRawContentList;
	}

	/**
	 * Show the jsp form. Fill in oldGameInfo. oldGameInfo will be used to fill
	 * in the form as original data
	 * 
	 * @return INPUT if inputs are not complete SUCCESS if all go right.
	 */
	public String showForm() {
		if (gameId == null) {
			return INPUT;
		}

		oldGameInfo = launchPuzzleSolvingGameService.findById(gameId);

		oldQrRawContentList = qrContentService
				.findQrRawContentListForPuzzleSolvingGame(gameId);

		return SUCCESS;
	}

	/**
	 * Modify the game
	 * 
	 * @return INPUT if inputs are not complete or there are errors ERROR if the
	 *         game is not launched by the current user SUCCESS if all go right
	 */
	public String modify() {
		/*
		 * Check info integrity
		 */
		if (newGameInfo == null || newGameInfo.getId() == null) {
			return INPUT;
		}

		// get the old game info
		PuzzleSolvingGameInfo oldGame = launchPuzzleSolvingGameService
				.findById(newGameInfo.getId());

		/*
		 * Check is the gameInfo is launched by the current user
		 */
		ActionContext ctx = ActionContext.getContext();
		User currentUser = (User) ctx.getSession().get("user");
		Integer currentUserId = currentUser.getId();
		Integer gameLauncherId = oldGame.getTblUserinfo().getId();
		// Be careful: equals but not ==
		if (gameLauncherId.equals(currentUserId) == false) {
			return ERROR;
		}

		/*
		 * update QRContent objects
		 */
		List<QRContent> newQRContentList = qrContentService
				.findQRContentListForPuzzleSolvingGame(newGameInfo.getId());
		for (int i = 0; i < newQRContentList.size(); i++) {
			// replace the content of QRContent object with new one
			newQRContentList.get(i).setContent(newQrRawContentList.get(i));

			// update the database
			qrContentService.updateQRContent(newQRContentList.get(i));
		}

		/*
		 * update PuzzleSolvingGameInfo object
		 */
		newGameInfo.setTblUserinfo(oldGame.getTblUserinfo());
		newGameInfo.setPlaceDate(oldGame.getPlaceDate());
		newGameInfo.setQrNum(oldGame.getQrNum());
		newGameInfo.setDefaultLL(1);
		launchPuzzleSolvingGameService.update(newGameInfo);

		return SUCCESS;
	}

}
