package com.vinodhkps.algos.dynamicprogramming;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RobotMoveTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindNumberOfWays() {
		int n = 3;
		int expected = 6;
		int actual = RobotMove.findNumberOfWays(n);

		assertEquals(expected, actual);

		n = 0;
		expected = 0;
		actual = RobotMove.findNumberOfWays(n);
		assertEquals(expected, actual);
	}

}
