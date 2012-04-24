package com.qrms.action.user;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qrms.bean.InspiringGameInfo;
import com.qrms.bean.PuzzleSolvingGameInfo;
import com.qrms.bean.User;
import com.qrms.service.IInspiringGameService;
import com.qrms.service.IShowPuzzleSolvingGameDetailService;
import com.qrms.service.IUserService;

/**
 * Decsription: This class controls the showing of the main page when 
 * user see his profile
 * @author Wangxing & Yinshunming
 * @version 2.0
 * modify 1: Wangxing & Yinshunming
 * Description: add inspiringgame
 */
public class ShowMyProfileMainPageAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private IUserService userService;

	private IInspiringGameService inspiringGameService;

	private IShowPuzzleSolvingGameDetailService puzzleSolvingGameService;

	private List<InspiringGameInfo> launchedInspiringGameInfoList;

	private List<PuzzleSolvingGameInfo> launchedPuzzleSolvingGameInfoList;

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
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

	
	/**
	 * this method uses services to find the puzzleSolving game & inspiringgame
	 * @return SUCCESS if all go right
	 */
	@Override
	public String execute() {
		/*
		 * Get the current login user
		 */
		ActionContext ctx = ActionContext.getContext();
		User currentUser = (User) ctx.getSession().get("user");
		Integer currentUserId = currentUser.getId();

		launchedInspiringGameInfoList = inspiringGameService
				.getInspiringGameInfoByUserId(currentUserId);

		launchedPuzzleSolvingGameInfoList = puzzleSolvingGameService
				.getPuzzleSolvingGameInfoByUserId(currentUserId);

		return SUCCESS;
	}

}
