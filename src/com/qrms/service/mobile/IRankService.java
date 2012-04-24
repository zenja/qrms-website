package com.qrms.service.mobile;

import java.util.ArrayList;
import java.util.Map;

/**
 * Description: the interface of the rankServiceImpl
 * 
 * @author ZhaoLu & Zhangzu
 * @version 1.0
 */
public interface IRankService {

	ArrayList<Map<String, Object>> rankByExp();

	ArrayList<Map<String, Object>> rankBySetupNum();

	ArrayList<Map<String, Object>> rankByOccupyingNum();
}
