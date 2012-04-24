package com.qrms.util;

import junit.framework.TestCase;
/**
 * @author Zhaolu & Yinshunming
 * @version 1.0 
 */
public class MD5Test extends TestCase {

	MD5 md5 = MD5.getMD5Instance();

	public void testToMD5() {
		assertEquals(md5.toMD5("tony").length(), 32);
	}

	public void testCreatValidateLink() {
		md5.setMD5();
		String link = md5.creatValidateLink();
		assertEquals(link.charAt(0), 'h');
	}
}
