package com.qrms.action.user;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.qrms.bean.InspiringGameInfo;
import com.qrms.bean.PuzzleSolvingGameInfo;
import com.qrms.bean.User;
import com.qrms.service.IInspiringGameService;
import com.qrms.service.IShowPuzzleSolvingGameDetailService;
import com.qrms.service.IUserService;

/**
 * Description: This class controls the logic when users want to see their
 * personal peofiles
 * 
 * @author Wangxing & ZhangZu
 * @version 4.0
 * 
 * @modify 1: Wangxing & ZhangZu Description:add the function to see their games
 *         which are launched by themselves
 * 
 * @modify 2: Wangxing & YinShunMing Description: add the function that users
 *         can see his internal messages
 * 
 * @modify 3: Wangxing & YinShunMing Description: remove the function that users
 *         can see his internal messages,and use another class to do this
 *         function
 */
public class ShowUserProfileAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private IUserService userService;

	private IInspiringGameService inspiringGameService;

	private IShowPuzzleSolvingGameDetailService puzzleSolvingGameService;

	private List<InspiringGameInfo> launchedInspiringGameInfoList;

	private List<PuzzleSolvingGameInfo> launchedPuzzleSolvingGameInfoList;

	/** user's id, received from the parameter */
	private Integer userId;

	/** user info, based on userId */
	private User userInfo;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public User getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(User userInfo) {
		this.userInfo = userInfo;
	}

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
	 * 1.query the info of the user 2.query the game list which is lanuched by
	 * this user
	 * 
	 * @return "noUserId" if userId is null or there is no such a user SUCCESS
	 *         if all go right
	 */
	@Override
	public String execute() throws Exception {

		if (userId == null) {
			return "noUserId";
		}

		userInfo = userService.findById(userId);
		if (userInfo == null) {
			return "noUserId";
		}

		launchedInspiringGameInfoList = inspiringGameService
				.getInspiringGameInfoByUserId(userId);

		launchedPuzzleSolvingGameInfoList = puzzleSolvingGameService
				.getPuzzleSolvingGameInfoByUserId(userId);

		return SUCCESS;

	}

}
