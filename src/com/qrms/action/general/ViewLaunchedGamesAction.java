package com.qrms.action.general;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.qrms.bean.InspiringGameInfo;
import com.qrms.bean.PuzzleSolvingGameInfo;
import com.qrms.service.IInspiringGameService;
import com.qrms.service.IShowPuzzleSolvingGameDetailService;

/**
 * Description: This class is an Action. Used to view all the games a specific
 * user have launched.
 * 
 * @author WangXing & ZhangZu
 * @version 1.0
 */
public class ViewLaunchedGamesAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Integer userId;

	private List<InspiringGameInfo> launchedInspiringGameInfoList;

	private List<PuzzleSolvingGameInfo> launchedPuzzleSolvingGameInfoList;

	private IInspiringGameService inspiringGameService;

	private IShowPuzzleSolvingGameDetailService puzzleSolvingGameService;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<InspiringGameInfo> getLaunchedInspiringGameInfoList() {
		return launchedInspiringGameInfoList;
	}

	public void setLaunchedInspiringGameInfoList(
			List<InspiringGameInfo> launchedInspiringGameInfoList) {
		this.launchedInspiringGameInfoList = launchedInspiringGameInfoList;
	}

	public List<PuzzleSolvingGameInfo> getLaunchedPuzzleSolvingGameInfoList() {
		return launchedPuzzleSolvingGameInfoList;
	}

	public void setLaunchedPuzzleSolvingGameInfoList(
			List<PuzzleSolvingGameInfo> launchedPuzzleSolvingGameInfoList) {
		this.launchedPuzzleSolvingGameInfoList = launchedPuzzleSolvingGameInfoList;
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

	/**
	 * this function fetches the games from the database a specific user has
	 * launched
	 * 
	 * @return INPUT if INPUT is not complete or there are errors SUCCESS if all
	 *         go right
	 */
	@Override
	public String execute() {
		if (userId == null) {
			return INPUT;
		}

		launchedInspiringGameInfoList = inspiringGameService
				.getInspiringGameInfoByUserId(userId);

		launchedPuzzleSolvingGameInfoList = puzzleSolvingGameService
				.getPuzzleSolvingGameInfoByUserId(userId);

		return SUCCESS;
	}

}
