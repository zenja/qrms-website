package com.qrms.service.mobile;

import java.util.ArrayList;
import java.util.Map;

/**
 * Description: the interface of the msgbox
 * 
 * @author ZhaoLu & Zhangzu
 * @version 1.0
 */
public interface IMsgBoxService {

	ArrayList<Map<String, Object>> getMyMsg(int id);

}