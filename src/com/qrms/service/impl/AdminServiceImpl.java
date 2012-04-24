package com.qrms.service.impl;

import java.util.List;

import com.qrms.bean.Admin;
import com.qrms.dao.IAdminDAO;
import com.qrms.service.IAdminService;

/**
 * Description: This is the implemention of IAdminService,which provides some
 * methods related to the operation of admin
 * 
 * @author Yinshunming & Wangxing
 * @version 1.0
 */
public class AdminServiceImpl implements IAdminService {

	/** the dao to do operations related to admin */
	private IAdminDAO adminDAO;

	public IAdminDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(IAdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	/**
	 * It checks if the loginEmail and loginPassword are of the
	 * @param username 
	 * @param password
	 * @return ture if login person is admin false if login person is not admin
	 */
	@SuppressWarnings("unchecked")
	public boolean isAdmin(String username, String password) {
		List<Admin> list = (List<Admin>) adminDAO.findByUsername(username);
		if (list != null && list.size() > 0
				&& list.get(0).getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public Admin findByUsername(String username) {
		List<Admin> list = (List<Admin>) adminDAO.findByUsername(username);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

}
