package com.qrms.service.impl;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.bean.QRContent;
import com.qrms.dao.IQRContentDAO;
import com.qrms.service.IQRContentService;

/**
 * @author Wangxing & Yinshunming
 * @version 1.0
 */
public class QRContentServiceImplTest extends TestCase {

	MockControl control;
	QRContentServiceImpl service;
	IQRContentDAO mock;

	protected void setUp() throws Exception {
		super.setUp();

		QRContent qrContent = new QRContent();
		qrContent.setCode("test1");
		qrContent.setContent("test1");
		qrContent.setGameId(1);
		qrContent.setId(1);
		qrContent.setSequence(1);
		qrContent.setType(IQRContentService.GAME_TYPE_INSPIRING_MARK);

		List<QRContent> list = new ArrayList<QRContent>();
		list.add(qrContent);

		service = new QRContentServiceImpl();

		control = MockControl.createControl(IQRContentDAO.class);
		mock = (IQRContentDAO) control.getMock();
		service.setQrContentDAO(mock);

		mock.findByCode("test");
		control.setReturnValue(list);
		mock.findByGameTypeAndGameId(
				IQRContentService.GAME_TYPE_PUZZLE_SOLVING, 1);
		control.setReturnValue(list);
		mock.findByGameTypeAndGameId(
				IQRContentService.GAME_TYPE_INSPIRING_MARK, 1);
		control.setReturnValue(list);
		control.replay();
	}

	protected void tearDown() throws Exception {
		control.reset();
		super.tearDown();
	}

	public void testFindByCode() {
		assertNotNull(service.findByCode("test"));
	}

	public void testFindQRContentListForPuzzleSolvingGame() {
		assertNotNull(service.findQRContentListForPuzzleSolvingGame(1));
	}

	public void testFindQrRawContentListForPuzzleSolvingGame() {
		assertNotNull(service.findQrRawContentListForPuzzleSolvingGame(1));
	}

	public void testFindQRContentForInspiringGame() {
		assertNotNull(service.findQRContentForInspiringGame(1));
	}

}
