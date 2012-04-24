package com.qrms.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import com.qrms.bean.UserNotValidatedInfo;
import com.qrms.dao.IUSerNotValidatedInfoDAO;
/**
 * @author Yinshunming & Zhaolu
 * @version 1.0
 */
public class UserNotValidatedInfoDAOImplTest extends BaseDAOTest {

	// private static Log log =
	// LogFactory.getLog(UserNotValidatedInfoDAOImplTest.class);
	IUSerNotValidatedInfoDAO unv;
	UserNotValidatedInfo unvi;

	public void setUnv(IUSerNotValidatedInfoDAO unv) {
		this.unv = unv;
	}

	public void onSetUpInTransaction() {
		Timestamp ts = new Timestamp(1000000);
		unvi = new UserNotValidatedInfo();
		unvi.setEncryptkey(new String("1234"));
		unvi.setLoginEmail(new String("superboytony@qq.com"));
		unvi.setName(new String("test"));
		unvi.setPassword(new String("1234"));
		unvi.setDate(new Timestamp(1000000));
		// unvi.setId(new Integer(4));
	}

	public void testSave() {
		unv.save(unvi);
		assertNotNull(unvi.getId());
	}

	public void testFindByLoginEnail() {
		List result = unv.findByLoginEmail("wx@126.com");
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}

	public void testFindByEncryptkey() {
		List result = unv.findByEncryptkey("122af67e05652d11ea8b94909e2b9e5a");
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}

	public void testDelete() {
		unv.save(unvi);
		unv.delete(unvi);
		flushSession();
		assertTrue(unv.findByLoginEmail(unvi.getLoginEmail()).isEmpty());
	}
}
