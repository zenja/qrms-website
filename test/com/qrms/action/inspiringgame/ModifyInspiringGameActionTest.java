package com.qrms.action.inspiringgame;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.service.IInspiringGameService;
import com.qrms.service.IQRContentService;
/**
 * @author Wangxing & Zhangzu
 * @version 1.0
 */
public class ModifyInspiringGameActionTest extends TestCase {
	private IInspiringGameService inspiringGameService;
	private MockControl igMock;
	private IQRContentService qrContentService;
	private MockControl qrMock;

	private ModifyInspiringGameAction action;
	private Integer gameId = 1;

	protected void setUp() throws Exception {
		igMock = MockControl.createControl(IInspiringGameService.class);
		qrMock = MockControl.createControl(IQRContentService.class);

		qrContentService = (IQRContentService) qrMock.getMock();
		inspiringGameService = (IInspiringGameService) igMock.getMock();

		action = new ModifyInspiringGameAction();
		action.setGameId(gameId);
		action.setInspiringGameService(inspiringGameService);
		action.setQrContentService(qrContentService);
		// action.setNewGameInfo(new InspiringGameInfo());
	}

	public void testModify() {
		igMock.reset();
		igMock.replay();
		assertEquals(action.modify(), "input");
	}

	public void testShowForm() {
		assertEquals(action.showForm(), "success");
	}

	protected void tearDown() throws Exception {
	}

}
