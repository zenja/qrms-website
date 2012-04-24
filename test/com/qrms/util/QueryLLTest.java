package com.qrms.util;

import junit.framework.TestCase;

/**
 * @author Yinshunming & Zhangzu
 * @vertion 3.0
 * modify 1: Yinshunming & Zhangzu 
 *         to V3
 * 
 * modify 2: Yinshunming & Wangxing 
 */
public class QueryLLTest extends TestCase {

	/** test the static method QueryCity() */
	public void testQueryCity() {
		Double[] d = QueryLL.QueryCity("Nanjing");
		assertEquals(d[0], 32.058365, 0.1);
		assertEquals(d[1], 118.796468, 0.1);
	}
}
