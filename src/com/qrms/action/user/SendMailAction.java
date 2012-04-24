package com.qrms.action.user;

import com.opensymphony.xwork2.ActionSupport;
import com.qrms.service.IUserValidateService;
import com.qrms.util.MD5;
import com.qrms.util.MailSender;

/**
 * Description: The class is designed to send validate Email to user. It uses
 * assited classes MailSender and MD5
 * 
 * @author Zhaolu & Yinshunming
 * @version 2.0 
 *  modify 1:Yinshunming & Zhaolu
 *  Description: Use a class to send the email
 */

public class SendMailAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	/** the service to delete the invalidate info form the database */

	private IUserValidateService uvs;

	private MailSender ms;
	
	
 /**
 * use an assited class to send activation mail to user
 * @return ERROR if there is any exception
 * SUCCESS if all go right
 */
	@Override
	public String execute() {
		ms = new MailSender();
		ms.addReceivers(MD5.getMD5Instance().getUserName());
		try {
			ms.sendTextMail();
		} catch (Exception e) {
			uvs.deleteByValidateCode(MD5.getMD5Instance().getMd5());
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	public IUserValidateService getUvs() {
		return uvs;
	}

	public void setUvs(IUserValidateService uvs) {
		this.uvs = uvs;
	}

	public MailSender getMs() {
		return ms;
	}

	public void setMs(MailSender ms) {
		this.ms = ms;
	}
}
