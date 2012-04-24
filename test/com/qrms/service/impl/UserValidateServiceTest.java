package com.qrms.service.impl;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.easymock.MockControl;
import com.qrms.bean.UserNotValidatedInfo;
import com.qrms.dao.IUSerNotValidatedInfoDAO;
/**
 * @author Zhaolu & Yinshunming
 * @version 1.0
 */
public class UserValidateServiceTest extends TestCase {

	private MockControl control;
	private IUSerNotValidatedInfoDAO nvUserDAO;
	List<UserNotValidatedInfo> lt;
	UserNotValidatedInfo u;
	List<UserNotValidatedInfo> lt1;
	UserValidateServiceImpl uds;

	/** set up the environment for the test */
	public void setUp() {
		uds = new UserValidateServiceImpl();
		lt = new ArrayList<UserNotValidatedInfo>();
		lt1 = new ArrayList<UserNotValidatedInfo>();
		u = new UserNotValidatedInfo();
		u.setEncryptkey("4cb975900ccb4f972d8682a59a110275");
		u.setLoginEmail("test@163.com");
		u.setPassword("1234567");
		lt.add(u);
		control = MockControl.createControl(IUSerNotValidatedInfoDAO.class);
		nvUserDAO = (IUSerNotValidatedInfoDAO) control.getMock();
		nvUserDAO.findByEncryptkey("4cb975900ccb4f972d8682a59a110275");
		control.setReturnValue(lt);
		nvUserDAO.findByEncryptkey("dafasdfdasfasfasfasfasfasfafasfads");
		control.setReturnValue(lt1);
		control.replay();
	}

	/** reset the environment */
	public void tearDown() {
		control.reset();
	}

	/** test find() method in the class */
	public void testFind() {
		uds.setNvUserDAO(nvUserDAO);
		assertEquals(uds.find("4cb975900ccb4f972d8682a59a110275"), lt.get(0));
		assertEquals(uds.find("dafasdfdasfasfasfasfasfasfafasfads"), null);
	}
}
