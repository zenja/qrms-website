package com.qrms.action.inspiringgame;

import com.opensymphony.xwork2.ActionSupport;
import com.qrms.bean.QRContent;
import com.qrms.service.IQRContentService;

/**
 * Description: This is an action. It works when someone want to see QR contents
 * of a detailed inspring game
 * 
 * @author Zhaolu & ZhangZu
 * @version 1.0
 */
public class ShowQRContentAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/** a main service to find qrContent */
	private IQRContentService qrContentService;

	private String code; // passed by user

	private QRContent qrContent; // made by the action, passed to the jsp:
									// inspiring-display.jsp

	public IQRContentService getQrContentService() {
		return qrContentService;
	}

	public void setQrContentService(IQRContentService qrContentService) {
		this.qrContentService = qrContentService;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public QRContent getQrContent() {
		return qrContent;
	}

	public void setQrContent(QRContent qrContent) {
		this.qrContent = qrContent;
	}

	/**
	 * the main function is to find the content of the qr code according to the
	 * id
	 * 
	 * @return INPUT if inputs are not complete 
	 * SUCCESS if all go right
	 */
	@Override
	public String execute() {
		if (code == null) {
			return INPUT;
		}

		qrContent = qrContentService.findByCode(code);

		if (qrContent == null) {
			return INPUT;
		}

		return SUCCESS;
	}
}
