package com.qrms.action.inspiringgame;

import org.easymock.MockControl;

import com.qrms.bean.QRContent;
import com.qrms.service.IQRContentService;

import junit.framework.TestCase;

/**
 * @author Zhaolu & ZhangZu
 * @version 1.0
 */
public class ShowQRContentActionTest extends TestCase {

	private IQRContentService qrContentService;
	private MockControl qrContentMock;
	private ShowQRContentAction action;
	private String code = "test code";

	protected void setUp() throws Exception {
		qrContentMock = MockControl.createControl(IQRContentService.class);
		qrContentService = (IQRContentService) qrContentMock.getMock();

		action = new ShowQRContentAction();
		action.setCode(code);
		action.setQrContentService(qrContentService);
	}

	public void testExecute() {
		qrContentMock.reset();
		qrContentMock.expectAndReturn(qrContentService.findByCode(code),
				new QRContent());
		qrContentMock.replay();

		assertEquals(action.execute(), "success");
	}

	protected void tearDown() throws Exception {
		qrContentMock.verify();
	}

}
