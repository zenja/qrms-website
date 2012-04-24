package com.qrms.action.gamecomment;

import com.opensymphony.xwork2.ActionSupport;
import com.qrms.bean.GameComment;
import com.qrms.service.IGameCommentService;

/**
 * Description: When class finds detailed comments info from the database
 * 
 * @author yinshunming & zhaolu
 * @version 1.0
 */
public class ViewGameCommentAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private IGameCommentService gameCommentService;

	/** the id of gameComment */
	private Integer commentId;

	/** passed to SUCCESS jsp */
	private GameComment gameComment;

	public IGameCommentService getGameCommentService() {
		return gameCommentService;
	}

	public void setGameCommentService(IGameCommentService gameCommentService) {
		this.gameCommentService = gameCommentService;
	}

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public GameComment getGameComment() {
		return gameComment;
	}

	public void setGameComment(GameComment gameComment) {
		this.gameComment = gameComment;
	}

	/**
	 * the main function of the class. It just fetches data from the database
	 * 
	 * @return SUCCESS if all are correct INPUT if the request is not complete
	 */
	@Override
	public String execute() {
		if (commentId == null) {
			return INPUT;
		}
		gameComment = gameCommentService.getGameCommentByCommentId(commentId);
		return SUCCESS;
	}
}
