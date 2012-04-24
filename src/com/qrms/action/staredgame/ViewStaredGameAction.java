package com.qrms.action.staredgame;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.qrms.bean.InspiringGameInfo;
import com.qrms.bean.PuzzleSolvingGameInfo;
import com.qrms.bean.StaredGame;
import com.qrms.service.IInspiringGameService;
import com.qrms.service.IQRContentService;
import com.qrms.service.IShowPuzzleSolvingGameDetailService;
import com.qrms.service.IStaredGameService;
import com.qrms.util.enhancedbean.StaredGameInfo;

/**
 * Description: This is an action when user views his/her started games
 * 
 * @author WangXing & ZhangZu
 * @version 1.0
 */
public class ViewStaredGameAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/** service to find the started games */
	private IStaredGameService staredGameService;

	/** service to find the insiring games */
	private IInspiringGameService inspiringGameService;

	/** service to find the puzzleSolvingGame */
	private IShowPuzzleSolvingGameDetailService puzzleSolvingGameService;

	/** list of stared games */
	private List<StaredGameInfo> staredGameInfoList;

	private Integer userId;

	public IStaredGameService getStaredGameService() {
		return staredGameService;
	}

	public void setStaredGameService(IStaredGameService staredGameService) {
		this.staredGameService = staredGameService;
	}

	public IInspiringGameService getInspiringGameService() {
		return inspiringGameService;
	}

	public void setInspiringGameService(
			IInspiringGameService inspiringGameService) {
		this.inspiringGameService = inspiringGameService;
	}

	public IShowPuzzleSolvingGameDetailService getPuzzleSolvingGameService() {
		return puzzleSolvingGameService;
	}

	public void setPuzzleSolvingGameService(
			IShowPuzzleSolvingGameDetailService puzzleSolvingGameService) {
		this.puzzleSolvingGameService = puzzleSolvingGameService;
	}

	public List<StaredGameInfo> getStaredGameInfoList() {
		return staredGameInfoList;
	}

	public void setStaredGameInfoList(List<StaredGameInfo> staredGameInfoList) {
		this.staredGameInfoList = staredGameInfoList;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * 1,find his staredGameList 2,check the type of the games 3,put it into the
	 * list of started games
	 * 
	 * @return INPUT if inputs are not complete SUCCESS if all go right
	 */
	@Override
	public String execute() {
		if (userId == null) {
			return INPUT;
		}

		List<StaredGame> staredGameList = staredGameService
				.findByUserId(userId);
		staredGameInfoList = new ArrayList<StaredGameInfo>();

		for (StaredGame staredGame : staredGameList) {
			StaredGameInfo staredGameInfo = new StaredGameInfo();

			staredGameInfo.setGameId(staredGame.getGameId());
			staredGameInfo.setGameLauncher(staredGame.getUser());
			staredGameInfo.setGameType(staredGame.getGameType());

			if (staredGame.getGameType() == IQRContentService.GAME_TYPE_INSPIRING_MARK) {
				InspiringGameInfo gameInfo = inspiringGameService
						.findGame(staredGame.getGameId());
				String gameName = gameInfo.getGameName();
				staredGameInfo.setGameName(gameName);
			} else if (staredGame.getGameType() == IQRContentService.GAME_TYPE_PUZZLE_SOLVING) {
				PuzzleSolvingGameInfo gameInfo = puzzleSolvingGameService
						.getPuzzleSolvingGameInfoByGameId(staredGame
								.getGameId());
				String gameName = gameInfo.getGameName();
				staredGameInfo.setGameName(gameName);
			}

			staredGameInfoList.add(staredGameInfo);
		}

		return SUCCESS;
	}

}
