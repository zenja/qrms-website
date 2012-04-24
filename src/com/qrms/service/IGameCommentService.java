package com.qrms.service;

import java.util.List;

import com.qrms.bean.GameComment;

/**
 * Description:This class is the interface for GameConmentServiceImpl It
 * provides some methods to provide the service
 * 
 * @author Yinshunming & Zhaolu
 * @version 1.0
 */
public interface IGameCommentService {

	List<GameComment> getGameCommentListByGameTypeAndGameId(Integer gameType,
			Integer gameId);

	List<GameComment> getGameCommentListForPuzzleSolvingByGameId(Integer gameId);

	List<GameComment> getGameCommentListForInspiringMarkByGameId(Integer gameId);

	void saveGameComment(GameComment gameComment);

	GameComment getGameCommentByCommentId(Integer commentId);
}
