package com.qrms.util;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description: This class can generate md5 code for a input string.
 * 
 * @author Zhaolu & Yinshunming
 * @version 1.0 
 */

public final class MD5 {
	public static MD5 md5 = null;
	private String valiLink = null;
	private String username = null;
	private String path = null;

	private MD5() {
	}

	public String getUserName() {
		return username;
	}

	public String getMd5() {
		return valiLink;
	}

	public void setUsername(String inStr) {
		this.username = inStr;
	}

	/**
	 * Description: Treat as singleton.
	 * 
	 * @return MD5
	 */
	public static MD5 getMD5Instance() {
		if (md5 == null) {
			md5 = new MD5();
			return md5;
		} else {
			return md5;
		}
	}

	/**
	 * Description: Generate md5 code use some algorithm.
	 * 
	 * @param inStr¡¡£º a string to be encoded by md5
	 * @return String
	 */
	public String toMD5(String inStr) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		byte[] byteArray = inStr.getBytes();
		byte[] md5Bytes = md.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16) {
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}

	/**
	 * Description: Generate the input string to be encoded.
	 */
	public void setMD5() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(new Date());
		valiLink = toMD5(username + time);
	}

	/**
	 * Description:Create the validated link.
	 * @return String
	 */
	public String creatValidateLink() {
		String httpaddr = this.getPath() + "uservalidate.action?valicode="
				+ valiLink;
		System.out.println(httpaddr);
		return httpaddr;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}
}
