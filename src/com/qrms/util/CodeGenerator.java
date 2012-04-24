package com.qrms.util;

import java.util.Random;

/**
 * Description: this class is responsible for generating random letters
 * 
 * @author Wangxing & Yinshunming
 * @version 1.0
 */
public class CodeGenerator {
	public final static int CODE_MAX_LENGTH = 32;

	private static Random random = new Random(System.currentTimeMillis());

	/**
	 * a static method to generate the ranom letter
	 * @return String : the random letter
	 */
	public static String generate() {
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < CODE_MAX_LENGTH; i++) {
			builder.append(getLetter());
		}

		return builder.toString();
	}

	private static char getLetter() {
		char ch = (char) (random.nextInt(26) + 'A');

		return ch;
	}
}
