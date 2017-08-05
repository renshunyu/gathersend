package com.asiainfo.a4.gathersend.myGatherSend.Base;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PowInputTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testResult() {
		double a = 12;
		PowInput p = new PowInput();
		assertTrue("成功",Math.pow(a, 0.1) == p.result(a));
	}


}
