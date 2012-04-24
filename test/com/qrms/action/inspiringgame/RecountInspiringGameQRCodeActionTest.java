package com.qrms.action.inspiringgame;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.bean.QRContent;
import com.qrms.service.IQRContentService;

/**
 * @author WangXing & Zhangzu
 * @version 1.0
 */
public class RecountInspiringGameQRCodeActionTest extends TestCase {
	private IQRContentService qrContentService;
	private MockControl qrMock;
	private RecountInspiringGameQRCodeAction action;
	private Integer gameId = 1;

	protected void setUp() throws Exception {
		qrMock = MockControl.createNiceControl(IQRContentService.class);
		qrContentService = (IQRContentService) qrMock.getMock();

		action = new RecountInspiringGameQRCodeAction();
		action.setQrContentService(qrContentService);
		action.setGameId(gameId);
	}

	public void testExcute() {
		qrMock.reset();
		qrMock.expectAndReturn(qrContentService
				.findQRContentForInspiringGame(gameId), new QRContent());
		qrMock.replay();

		assertEquals(action.execute(), "success");
	}

	protected void tearDown() throws Exception {
		qrMock.verify();
	}

}
