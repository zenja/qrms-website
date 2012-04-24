package com.qrms.action.inspiringgame;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.bean.InspiringGameInfo;
import com.qrms.bean.QRContent;
import com.qrms.bean.User;
import com.qrms.service.IInspiringGameService;
import com.qrms.service.IQRContentService;
import com.qrms.service.IUserService;
/**
 * @author WangXing & ZhangZu
 * @version 1.0
 */
public class LaunchInspiringGameActionTest extends TestCase {
	/** service, to be injected */
	private IInspiringGameService inspiringGameService;
	private MockControl igMock;

	/** service, to be injected */
	private IQRContentService qrContentService;
	private MockControl qcMock;

	/** service, to be injected */
	private IUserService userService;
	private MockControl usMock;

	private LaunchInspiringGameAction action;
	private Integer gameLauncherId = 1;
	private String qrRawContent = "test content";

	protected void setUp() throws Exception {
		igMock = MockControl.createNiceControl(IInspiringGameService.class);
		qcMock = MockControl.createNiceControl(IQRContentService.class);
		usMock = MockControl.createNiceControl(IUserService.class);

		inspiringGameService = (IInspiringGameService) igMock.getMock();
		qrContentService = (IQRContentService) qcMock.getMock();
		userService = (IUserService) usMock.getMock();

		action = new LaunchInspiringGameAction();
		action.setInspiringGameService(inspiringGameService);
		action.setQrContentService(qrContentService);
		action.setUserService(userService);
		action.setGameLauncherId(gameLauncherId);
		action.setGameInfo(new InspiringGameInfo());
		action.setQrRawContent(qrRawContent);
	}

	protected void tearDown() throws Exception {
		igMock.verify();
		qcMock.verify();
		usMock.verify();
	}

	public void testLaunchGame() {
		igMock.reset();
		qcMock.reset();
		usMock.reset();
		usMock
				.expectAndReturn(userService.findById(gameLauncherId),
						new User());
		qcMock
				.expectAndReturn(qrContentService.makeQRContent(qrRawContent,
						IQRContentService.GAME_TYPE_INSPIRING_MARK, 0),
						new QRContent());
		igMock.replay();
		qcMock.replay();
		usMock.replay();

		assertEquals(action.launchGame(), "success");
	}

}
