package com.qrms.action.gamecomment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qrms.bean.GameComment;
import com.qrms.bean.User;
import com.qrms.service.IGameCommentService;

/**
 * Description: This action does with the bussines logic of making comments
 * 
 * @author Yinshunming & Zhaolu
 * @version 1.0
 */
public class MakeGameCommentAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private final static String UPLOADDIR = "/upload";

	private IGameCommentService gameCommentService;

	/** passed by user, to be saved to DB */
	private GameComment gameComment;

	/** passed by user */
	private File pictureFile;

	private String pictureFileFileName;

	public IGameCommentService getGameCommentService() {
		return gameCommentService;
	}

	public void setGameCommentService(IGameCommentService gameCommentService) {
		this.gameCommentService = gameCommentService;
	}

	public GameComment getGameComment() {
		return gameComment;
	}

	public void setGameComment(GameComment gameComment) {
		this.gameComment = gameComment;
	}

	public File getPictureFile() {
		return pictureFile;
	}

	public void setPictureFile(File pictureFile) {
		this.pictureFile = pictureFile;
	}

	public String getPictureFileFileName() {
		return pictureFileFileName;
	}

	public void setPictureFileFileName(String pictureFileFileName) {
		this.pictureFileFileName = pictureFileFileName;
	}

	/**
	 * this function uses java IO to save the files
	 * 
	 * @param newFileName
	 *         The name of the file name.
	 */
	@SuppressWarnings("deprecation")
	private void uploadFile(String newFileName) throws FileNotFoundException,
			IOException {
		try {
			// open a file IO
			InputStream in = new FileInputStream(pictureFile);
			String dir = ServletActionContext.getRequest().getRealPath(
					UPLOADDIR);
			File uploadFile = new File(dir, newFileName);
			OutputStream out = new FileOutputStream(uploadFile);
			byte[] buffer = new byte[1024 * 1024];
			int length;
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}
			in.close();
			out.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/** Get the file type string of a given filename */
	private static String getExtention(String fileName) {
		int type = fileName.lastIndexOf(".");
		return fileName.substring(type);
	}

	/**
	 * This class mainly controls the logic when a user uploads a photo
	 * 
	 * @return INPUT the the inputs are not complete ERROR if there is any
	 *         exception SUCCESS if all go as expected
	 */
	@Override
	public String execute() {
		if (gameComment == null) {
			return INPUT;
		}

		ActionContext ctx = ActionContext.getContext();
		User currentUser = (User) ctx.getSession().get("user");

		/*
		 * Upload file and set photo
		 */
		try {
			if (pictureFile != null) { // User uploads file and here creates a
										// unique name
				String newFileName = "comment_" + (new Date().getTime()) + "_"
						+ currentUser.getId().toString()
						+ getExtention(pictureFileFileName);
				uploadFile(newFileName);

				// set photo
				gameComment.setPhoto(newFileName);
			}
		} catch (IOException e) {
			e.printStackTrace();

			return ERROR;
		}

		// the comment-maker is the current user
		gameComment.setUser(currentUser);

		// set the time to current time
		gameComment.setTime(new Timestamp(System.currentTimeMillis()));

		// save to DB
		gameCommentService.saveGameComment(gameComment);

		return SUCCESS;
	}

}
