package com.qrms.service.impl.mobile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.qrms.bean.MsgBox;
import com.qrms.dao.IMsgBoxDAO;
import com.qrms.service.mobile.IMsgBoxService;

/**
 * Description: this service deals with the message related functions
 * 
 * @author ZhaoLu & Zhangzu
 * @version 1.0
 */
public class MsgBoxService implements IMsgBoxService {
	IMsgBoxDAO msgBoxDao = null;

	public IMsgBoxDAO getMsgBoxDao() {
		return msgBoxDao;
	}

	public void setMsgBoxDao(IMsgBoxDAO msgBoxDao) {
		this.msgBoxDao = msgBoxDao;
	}

	/**
	 * get the message sent to a player
	 * 
	 * @param the
	 *            player's id
	 * @return the message list
	 */
	public ArrayList<Map<String, Object>> getMyMsg(int id) {
		ArrayList<Map<String, Object>> msgList;
		List<MsgBox> dbMsgList = msgBoxDao.findByReceiverid(id);
		if (dbMsgList != null) {
			msgList = new ArrayList<Map<String, Object>>();
			Iterator<MsgBox> itr = dbMsgList.iterator();
			while (itr.hasNext()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				MsgBox temp = itr.next();
				map.put("time", temp.getTime());
				map.put("content", temp.getContent());
				msgList.add(map);
			}
			return msgList;
		}
		return null;
	}
}
