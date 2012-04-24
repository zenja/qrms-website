package com.qrms.dao.impl;

import com.qrms.bean.Admin;
import com.qrms.dao.IAdminDAO;

/**
 * @author Yinshunming & Wangxing
 * @version 1.0
 */
public class AdminDAOImplTest extends BaseDAOTestCase {
	private IAdminDAO adminDao;
	private Admin admin;

	private final String EMAIL = "test email";
	private final String PASSWORD = "test pass";
	private final String USERNAME = "test username";

	public IAdminDAO getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(IAdminDAO adminDao) {
		this.adminDao = adminDao;
	}

	public void onSetUpInTransaction() {
		admin = new Admin();
		admin.setEmail(EMAIL);
		admin.setPassword(PASSWORD);
		admin.setUsername(USERNAME);

		adminDao.save(admin);
	}

	public void testSave() {
		adminDao.save(admin);
		assertNotNull(adminDao.findById(admin.getId()));
	}

	public void testDelete() {
		adminDao.delete(admin);
		assertNull(adminDao.findById(admin.getId()));
	}

	public void testFindById() {
		assertNotNull(adminDao.findById(admin.getId()));
	}

	public void testFindByExample() {
		assertTrue(adminDao.findByExample(admin).size() > 0);
	}

	public void testFindByProperty() {
		assertTrue(adminDao.findByProperty("email", EMAIL).size() > 0);
	}

	public void testFindByUsername() {
		assertTrue(adminDao.findByUsername(USERNAME).size() > 0);
	}

	public void testFindByPassword() {
		assertTrue(adminDao.findByPassword(PASSWORD).size() > 0);
	}

	public void testFindByEmail() {
		assertTrue(adminDao.findByEmail(EMAIL).size() > 0);
	}

	public void testFindAll() {
		assertTrue(adminDao.findAll().size() > 0);
	}

}
