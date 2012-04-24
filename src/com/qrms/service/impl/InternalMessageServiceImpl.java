package com.qrms.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.qrms.bean.InternalMessage;
import com.qrms.bean.User;
import com.qrms.dao.IInternalMessageDAO;
import com.qrms.service.IInternalMessageService;

/**
 * Description: This class provides services related to internal messages
 * 
 * @author Yinshunming & Zhaolu
 * @version 1.0
 */
public class InternalMessageServiceImpl implements IInternalMessageService {

	/** the dao to interact with the database */
	private IInternalMessageDAO internalMessageDAO;

	public IInternalMessageDAO getInternalMessageDAO() {
		return internalMessageDAO;
	}

	public void setInternalMessageDAO(IInternalMessageDAO internalServiceDAO) {
		this.internalMessageDAO = internalServiceDAO;
	}

	/**
	 * The method sends the internal message to a given user
	 * 
	 * @param userFromId : the id of the user that sends the internal
	 *            message
	 * @param  userToId : the id of the user that the internal message sends
	 *            to
	 * @param title : title of the internal message
	 * @param content : content of the internal message
	 */
	public void sendMessage(Integer userFromId, Integer userToId, String title,
			String content) {
		InternalMessage internelMessage = new InternalMessage();
		/* fill the User bean */
		User userByUserFrom = new User();
		userByUserFrom.setId(userFromId);
		User userByUserTo = new User();
		userByUserTo.setId(userToId);
		/* fill the internel message bean */
		internelMessage.setTitle(title);
		internelMessage.setContent(content);
		internelMessage.setUserByUserFrom(userByUserFrom);
		internelMessage.setUserByUserTo(userByUserTo);
		internelMessage.setTime(new Timestamp(System.currentTimeMillis()));
		internalMessageDAO.save(internelMessage); // save this bean
	}

	public InternalMessage findById(Integer internalMessageId) {
		return internalMessageDAO.findById(internalMessageId);
	}

	public List<InternalMessage> findInternalMessagesByReceiverId(Integer userId) {
		return internalMessageDAO.findByReceiverId(userId);
	}

}
