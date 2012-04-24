package com.qrms.action.puzzlesolvinggame;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.qrms.bean.QRContent;
import com.qrms.service.IQRContentService;

/**
 * Description:This is an action.It controls the logic when someone wants to
 * reprint his qr codes
 * 
 * @author ZhaoLu & YinShunMing
 * @version 1.0
 */

public class RecountPuzzleSolvingGameQRCodeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private IQRContentService qrContentService;

	/** passed by user */
	private Integer gameId;

	private List<String> codeList;

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

	public List<String> getCodeList() {
		return codeList;
	}

	public void setCodeList(List<String> codeList) {
		this.codeList = codeList;
	}

	/**
	 * It just fetches the QR content according to user's request
	 * 
	 * @return INPUT if inputs are not complete SUCCESS if all go right as
	 *         expected
	 */
	@Override
	public String execute() {
		if (gameId == null) {
			return INPUT;
		}

		List<QRContent> qrContentList = qrContentService
				.findQRContentListForPuzzleSolvingGame(gameId);
		codeList = new ArrayList<String>();
		for (QRContent qrContent : qrContentList) {
			codeList.add(qrContent.getCode());
		}

		return SUCCESS;
	}

}
