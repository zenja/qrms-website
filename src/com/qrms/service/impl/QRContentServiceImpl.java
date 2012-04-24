package com.qrms.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.qrms.bean.QRContent;
import com.qrms.dao.IQRContentDAO;
import com.qrms.service.IQRContentService;
import com.qrms.util.CodeGenerator;

/**
 * Description: This class provides services related to QR codes
 * 
 * @author Wangxing & Yinshunming
 * @version 1.0
 */
public class QRContentServiceImpl implements IQRContentService {

	private IQRContentDAO qrContentDAO;

	public IQRContentDAO getQrContentDAO() {
		return qrContentDAO;
	}

	public void setQrContentDAO(IQRContentDAO qrContentDAO) {
		this.qrContentDAO = qrContentDAO;
	}

	/**
	 * Get QRContent object by id
	 * @param code : the code of the QR
	 * @return null if not found QRContent of the given code if all go well
	 */
	@SuppressWarnings("unchecked")
	public QRContent findByCode(String code) {
		List<QRContent> qrContentList = qrContentDAO.findByCode(code);
		if (qrContentList != null || qrContentList.size() > 0) {
			return qrContentList.get(0);
		} else {
			return null;
		}
	}

	/**
	 * Make a QRContent object
	 * @param
	 * String qrRawContent : The html content text
	 * int type: The game type. 1 for inspiring mark, 2 for puzzle solving
	 * Integer gameId: the id of the game
	 * 
	 * @return an QRContent object
	 */
	public QRContent makeQRContent(String qrRawContent, int type, Integer gameId) {
		QRContent content = new QRContent();

		content.setContent(qrRawContent);
		content.setCode(CodeGenerator.generate());
		content.setType(type);
		content.setGameId(gameId);

		// set default sequence
		content.setSequence(0);

		return content;
	}

	/**
	 * Make a QRContent object with a sequence. Used for Puzzle Solving
	 * @param qrRawContent : The html content text
	 * @param type: The game type. 1 for inspiring mark, 2 for puzzle solving
	 * @param gameId: the id of the game
	 * @param sequence: The sequence number of the QR Code
	 * 
	 * @return an QRContent object 
	 */
	public QRContent makeQRContent(String qrRawContent, int type,
			Integer gameId, Integer sequence) {
		QRContent content = new QRContent();

		content.setContent(qrRawContent);
		content.setCode(CodeGenerator.generate());
		content.setType(type);
		content.setGameId(gameId);

		// set sequence
		content.setSequence(sequence);

		return content;
	}

	public void saveQRContent(QRContent theQRContent) {
		qrContentDAO.save(theQRContent);
	}

	public void updateQRContent(QRContent theQRContent) {
		qrContentDAO.update(theQRContent);
	}

	/**
	 * Find a list of QRContent objects. Used for Puzzle Solving
	 * Note: Must satisfied the sequence!
	 * 
	 * @param gameId: the id of the game(Puzzle Solving)
	 * @return a list of QRContent objects
	 */
	public List<QRContent> findQRContentListForPuzzleSolvingGame(Integer gameId) {
		List<QRContent> qrContentList = qrContentDAO.findByGameTypeAndGameId(
				IQRContentService.GAME_TYPE_PUZZLE_SOLVING, gameId);
		List<QRContent> result = new ArrayList<QRContent>(qrContentList.size());

		for (QRContent content : qrContentList) {
			result.add(content);
		}

		return result;
	}

	/**
	 * Get a list of html texts in the QR Codes of a sepcific game
	 * Note: Must satisfied the sequence!
	 * 
	 * @param gameId: the id of the game
	 * 
	 * @return a list of String which are the html texts
	 * 
	 */
	public List<String> findQrRawContentListForPuzzleSolvingGame(Integer gameId) {
		List<QRContent> qrContentList = findQRContentListForPuzzleSolvingGame(gameId);
		List<String> qrRawContentList = new ArrayList<String>(qrContentList
				.size());
		for (QRContent content : qrContentList) {
			qrRawContentList.add(content.getContent());
		}

		return qrRawContentList;
	}

	/**
	 * Get the QRContent object of an Inspiring Mark game
	 * 
	 * @param gameId: the id of the game
	 * 
	 * @return a QRContent object of that game
	 * 
	 */
	public QRContent findQRContentForInspiringGame(Integer gameId) {
		List<QRContent> qrContentList = qrContentDAO.findByGameTypeAndGameId(
				IQRContentService.GAME_TYPE_INSPIRING_MARK, gameId);

		return qrContentList.get(0);
	}

}
