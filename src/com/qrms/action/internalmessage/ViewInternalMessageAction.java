package com.qrms.action.internalmessage;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qrms.bean.InternalMessage;
import com.qrms.bean.User;
import com.qrms.service.IInternalMessageService;

/**
 * Description:This action is for users to view his internal messages
 * 
 * @author Yinshunming & Zhangzu
 * @version 1.0
 */
public class ViewInternalMessageAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/** service to fetch internal messages */
	private IInternalMessageService internalMessageService;

	/** list of messages send to the users */
	private List<InternalMessage> internalMessageList;

	private InternalMessage internalMessage;

	private Integer internalMessageId;

	public IInternalMessageService getInternalMessageService() {
		return internalMessageService;
	}

	public void setInternalMessageService(
			IInternalMessageService internalMessageService) {
		this.internalMessageService = internalMessageService;
	}

	public List<InternalMessage> getInternalMessageList() {
		return internalMessageList;
	}

	public void setInternalMessageList(List<InternalMessage> internalMessageList) {
		this.internalMessageList = internalMessageList;
	}

	public InternalMessage getInternalMessage() {
		return internalMessage;
	}

	public void setInternalMessage(InternalMessage internalMessage) {
		this.internalMessage = internalMessage;
	}

	public Integer getInternalMessageId() {
		return internalMessageId;
	}

	public void setInternalMessageId(Integer internalMessageId) {
		this.internalMessageId = internalMessageId;
	}

	/**
	 * This function is simple and it just fetches internalmessages of users
	 * 
	 * @return SUCCESS if all go right
	 */
	public String viewAllInternalMessages() {
		ActionContext ctx = ActionContext.getContext();
		User currentUser = (User) ctx.getSession().get("user");

		internalMessageList = internalMessageService
				.findInternalMessagesByReceiverId(currentUser.getId());

		return SUCCESS;
	}

	public String viewSingleInternalMessage() {
		if (internalMessageId == null) {
			return INPUT;
		}

		internalMessage = internalMessageService.findById(internalMessageId);

		return SUCCESS;
	}
}
