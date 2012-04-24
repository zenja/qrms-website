package com.qrms.service;

import java.util.List;

import com.qrms.bean.QRContent;

/**
 * Description: This is the interface of QRContentServiceImpl. It has some
 * methods which are related operations on QRContent
 * 
 * @author Wangxing & Zhaolu
 * @version 1.0
 */
public interface IQRContentService {

	public static final int GAME_TYPE_INSPIRING_MARK = 1;
	public static final int GAME_TYPE_PUZZLE_SOLVING = 2;
	public static final int GAME_TYPE_CONQUEST_AND_DEFENCE = 3;

	public QRContent findByCode(String code);

	public QRContent makeQRContent(String qrRawContent, int type, Integer gameId);

	public QRContent makeQRContent(String qrRawContent, int type,
			Integer gameId, Integer sequence);

	public void saveQRContent(QRContent theQRContent);

	public void updateQRContent(QRContent theQRContent);

	/**
	 * Find a list of QRContent objects that belong to given game's id. Must
	 * satisfy the sequence!
	 * 
	 * @param gameId
	 * @return list of the bean QRContent
	 */
	public List<QRContent> findQRContentListForPuzzleSolvingGame(Integer gameId);

	/**
	 * Must satisfy the sequence!
	 * 
	 * @param gameId
	 * @return list of String
	 */
	public List<String> findQrRawContentListForPuzzleSolvingGame(Integer gameId);

	public QRContent findQRContentForInspiringGame(Integer gameId);

}
