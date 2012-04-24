package com.qrms.service;

import java.util.List;

import com.qrms.bean.InternalMessage;

/**
 * Description: This provides some services about internalmessages.
 * 
 * @author Yinshunming & Wangxing
 * @version 1.0
 */
public interface IInternalMessageService {

	void sendMessage(Integer userFromId, Integer userToId, String title,
			String content);

	List<InternalMessage> findInternalMessagesByReceiverId(Integer userId);

	InternalMessage findById(Integer internalMessageId);

}
