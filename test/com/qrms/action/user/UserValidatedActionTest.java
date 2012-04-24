package com.qrms.action.user;

import java.sql.Timestamp;
import junit.framework.TestCase;
import org.easymock.MockControl;
import com.qrms.action.user.UserValidateAction;
import com.qrms.bean.UserNotValidatedInfo;
import com.qrms.service.IUserValidateService;
/**
 * @author Zhaolu & Yinshunming
 * @version 1.0
 */
public class UserValidatedActionTest extends TestCase {
	private MockControl control;
	private IUserValidateService uvs;
	private UserNotValidatedInfo uvinfo;

	/**
	 * description:It just forges some essiential environment for the test
	 */
	@Override
	public void setUp() {
		uvinfo = new UserNotValidatedInfo();
		uvinfo.setEncryptkey("13123123312");
		uvinfo.setId(1);
		uvinfo.setLoginEmail("123@qq.com");
		uvinfo.setName("ysm");
		uvinfo.setPassword("1312321");
		Timestamp d = new Timestamp(System.currentTimeMillis());
		uvinfo.setDate(d);
		control = MockControl.createControl(IUserValidateService.class);

		/* We use mock here to forge the interaction with the database */
		uvs = (IUserValidateService) control.getMock(); // create a mock
		uvs.find("13123123312");
		control.setReturnValue(uvinfo);
		uvs.find("abcdefg");
		control.setReturnValue(null);
		uvs.deleteFromTblNotValidate(uvinfo);
		uvs.saveToTblUserInfo(null);
		control.replay(); // finish the REC
	}

	public void testExcute() {
		UserValidateAction uva = new UserValidateAction();
		uva.setUvs(uvs);
		/*
		 * uva.setValicode("13123123312");
		 * assertEquals(uva.execute(),"success");
		 */
		uva.setValicode("abcdefg"); // Valicode is fasle
		assertEquals(uva.execute(), "error");
	}
}
