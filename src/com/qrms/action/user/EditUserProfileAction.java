package com.qrms.action.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qrms.bean.User;
import com.qrms.service.IUserService;

/**
 * Description: Edit user profile. Can upload a photo.
 * 
 * @author Wangxing & Zhangzu
 * @version 1.0
 */
public class EditUserProfileAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static String UPLOADDIR = "/upload";

	/**
	 * User Service, to be injected
	 */
	private IUserService userService;

	/**
	 * The nation of the user, received from EditUserProfile.jsp
	 */
	private String nation;

	/**
	 * The province of the user, received from EditUserProfile.jsp
	 */
	private String province;

	/**
	 * The city of the user, received from EditUserProfile.jsp
	 */
	private String city;

	/** File object that maybe uploaded by user */
	private File file;

	/** The name of the file that be uploaded by user */
	private String fileFileName;

	/** The type of the uploaded file */
	private String fileContentType;

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	/** Get the file type string of a given filename */
	private static String getExtention(String fileName) {
		int type = fileName.lastIndexOf(".");
		return fileName.substring(type);
	}

	// Upload Function Method
	@SuppressWarnings("deprecation")
	private void uploadFile(String newFileName) throws FileNotFoundException,
			IOException {
		try {
			InputStream in = new FileInputStream(file);
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

	@Override
	public String execute() throws Exception {
		// get current logged in user
		ActionContext context = ActionContext.getContext();
		User currentUser = (User) (context.getSession().get("user"));

		// if user modifies the photo, upload the new photo
		if (currentUser != null) {
			if (file != null) {
				// set the file's name
				String newFileName = "user_" + (new Date().getTime()) + "_"
						+ currentUser.getId().toString()
						+ getExtention(this.getFileFileName());

				// Upload the file
				uploadFile(newFileName);

				// set the new photo filename to the user bean
				currentUser.setPhoto(newFileName);
			}

			// modify user object
			currentUser.setNation(nation);
			currentUser.setProvince(province);
			currentUser.setCity(city);
		}

		// modify the DB
		userService.update(currentUser);

		return SUCCESS;
	}

}
