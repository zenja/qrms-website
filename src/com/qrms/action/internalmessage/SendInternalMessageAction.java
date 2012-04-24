package com.qrms.action.internalmessage;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qrms.bean.User;
import com.qrms.service.IInternalMessageService;
import com.qrms.service.IUserService;

/**
 * Descrption: This is an action. It is called when one user sends internal
 * messages to other users.It controls the logic of this operation.
 * 
 * @author Yinshunming & Zhangzu
 * @version 1.0
 */
public class SendInternalMessageAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/** a service to send messages */
	private IInternalMessageService internalMessageService;

	private IUserService userService;

	private Integer userIdTo;

	private String title;

	private String content;

	public IInternalMessageService getInternalMessageService() {
		return internalMessageService;
	}

	public void setInternalMessageService(
			IInternalMessageService internalMessageService) {
		this.internalMessageService = internalMessageService;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public Integer getUserIdTo() {
		return userIdTo;
	}

	public void setUserIdTo(Integer userToId) {
		this.userIdTo = userToId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 1,check info integrity 2,fetch the info of the sendTo person 3,send a
	 * message
	 * 
	 * @return INPUT if the infos are not complete 
	 *  ERROR if the inputs are not
	 *         complete SUCCESS if all go right
	 */
	@Override
	public String execute() {
		if (checkInfoIntegrity() == false) { // check info integrity
			return INPUT;
		}

		ActionContext ctx = ActionContext.getContext();
		User currentUser = (User) ctx.getSession().get("user");
		User userTo = userService.findById(userIdTo);
		User userFrom = currentUser;

		if (userTo == null || userFrom == null) {
			return ERROR;
		}

		internalMessageService.sendMessage(userFrom.getId(), userTo.getId(),
				title, content);// send a message

		return SUCCESS;
	}

	/**
	 * check if title sendingUser and content have values.
	 * 
	 * @return false if the integerity of the info is not true true if the
	 *         integerity of the info is right
	 */
	private boolean checkInfoIntegrity() {
		if (userIdTo == null || title == null || content == null) {
			return false;
		} else {
			return true;
		}
	}
}
