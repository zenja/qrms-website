package com.qrms.action.inspiringgame;

import com.opensymphony.xwork2.ActionSupport;
import com.qrms.service.IQRContentService;

/**
 * Description£ºIt is an action. It is for users when he wants to print new QR
 * Codes when previous QR Codes destory
 * 
 * @author WangXing & Zhangzu
 * @version 1.0
 */
public class RecountInspiringGameQRCodeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private IQRContentService qrContentService;

	/** passed by user */
	private Integer gameId;

	private String code;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * find the qrContent according to the code
	 * @return SUCCESS if all go right INPUT if inputs are not complete
	 */
	@Override
	public String execute() {
		if (gameId == null) {
			return INPUT;
		}

		code = qrContentService.findQRContentForInspiringGame(gameId).getCode();

		return SUCCESS;
	}

}
