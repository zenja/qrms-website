package com.qrms.action.puzzlesolvinggame;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.qrms.bean.PuzzleSolvingGameInfo;
import com.qrms.bean.QRContent;
import com.qrms.bean.User;
import com.qrms.service.ILaunchPuzzleSolvingGameService;
import com.qrms.service.IQRContentService;
import com.qrms.service.IUserService;
import com.qrms.util.QueryLL;

/**
 * Description: This class is an Action.It is for user to launch puzzle solving
 * game;
 * 
 * @author Wangxing & Zhaolu
 * @version 1.0
 */
public class LaunchPuzzleSolvingGameAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/** service, to be injected */
	private ILaunchPuzzleSolvingGameService launchPuzzleSolvingGameService;

	/** service, to be injected */
	private IQRContentService qrContentService;

	/** service, to be injected */
	private IUserService userService;

	/** bean for this action */
	private PuzzleSolvingGameInfo gameInfo;

	private List<String> qrRawContentList;

	/**
	 * the list of generated code, passed to
	 * launch-puzzlesolving-game-result.jsp
	 */
	private List<String> codeList;

	/**
	 * gameLauncher's id, used to fill the foreign key of the gameInfo
	 * (tbl_puzzlesolvinggameinfo.user_id)
	 */
	private Integer gameLauncherId;

	private boolean precision;

	public boolean isPrecision() {
		return precision;
	}

	public void setPrecision(boolean precision) {
		this.precision = precision;
	}

	public Integer getGameLauncherId() {
		return gameLauncherId;
	}

	public void setGameLauncherId(Integer gameLauncherId) {
		this.gameLauncherId = gameLauncherId;
	}

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

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public PuzzleSolvingGameInfo getGameInfo() {
		return gameInfo;
	}

	public void setGameInfo(PuzzleSolvingGameInfo gameInfo) {
		this.gameInfo = gameInfo;
	}

	public List<String> getQrRawContentList() {
		return qrRawContentList;
	}

	public void setQrRawContentList(List<String> qrRawContentList) {
		this.qrRawContentList = qrRawContentList;
	}

	public List<String> getCodeList() {
		return codeList;
	}

	public void setCodeList(List<String> codeList) {
		this.codeList = codeList;
	}

	/**
	 * Description: The main function of the class. Save the game info(gameInfo)
	 * to the DB
	 * 
	 * @return SUCCESS Saving operation is successful "noGameLauncher" Foreign
	 *         key info(gameLauncherId) is missing or not exists
	 */
	public String saveInfo() {
		if (gameLauncherId == null) {
			return "noGameLauncher";
		}

		// find foreign key based on gameLauncherId
		User gameLauncher = userService.findById(gameLauncherId);

		if (gameLauncher == null) {
			return "noGameLauncher";
		}
		if (isPrecision() == true) {
			gameInfo.setDefaultLL(1);
		} else {
			gameInfo.setDefaultLL(0);
			String city = gameInfo.getCity();
			Double ret[] = QueryLL.QueryCity(city);
			gameInfo.setLatitude(ret[0]);
			gameInfo.setLongitude(ret[1]);
		}

		gameInfo.setPlaceDate(new Date()); // set place date to the launch date

		gameInfo.setTblUserinfo(gameLauncher); // set foreign key

		/*
		 * save gameInfo to DB
		 */
		launchPuzzleSolvingGameService.save(gameInfo);

		/*
		 * make QRContents and save these QRContents to DB; fill codeList;
		 */
		codeList = new ArrayList<String>();
		for (int i = 0; i < gameInfo.getQrNum(); i++) {
			QRContent qrContent = qrContentService.makeQRContent(
					qrRawContentList.get(i),
					IQRContentService.GAME_TYPE_PUZZLE_SOLVING, gameInfo
							.getId(), i);
			codeList.add(qrContent.getCode());
			qrContentService.saveQRContent(qrContent);
		}

		return SUCCESS;
	}

}
