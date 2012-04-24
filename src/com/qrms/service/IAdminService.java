package com.qrms.service;

import com.qrms.bean.Admin;

/**
 * Descrption:This class is the interface for AdminServiceImpl It abstracts some
 * methods from the service to provide service to actions
 * 
 * @author Yinshunming & Wangxing
 * @version 1.0
 */
public interface IAdminService {
	/** the method is to judge if username and password has a partnership */
	public boolean isAdmin(String username, String password);

	/** find the adimin info according to username */
	public Admin findByUsername(String username);
}
