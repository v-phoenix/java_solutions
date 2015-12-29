package com.vinodhkps.algos.backtrack;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RatsInAMazeTest {

	RatsInAMaze classUnderTest = new RatsInAMaze();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSolve() {

		int[][] inputMaze = new int[4][4];
		inputMaze[0] = new int[] { 1, 0, 0, 0 };
		inputMaze[1] = new int[] { 1, 1, 0, 1 };
		inputMaze[2] = new int[] { 0, 1, 0, 0 };
		inputMaze[3] = new int[] { 1, 1, 1, 1 };

		int[][] actuals = classUnderTest.solve(inputMaze);
		int[][] expecteds = new int[][] { { 1, 0, 0, 0 }, { 1, 1, 0, 0 },
				{ 0, 1, 0, 0 }, { 0, 1, 1, 1 } };

		assertArrayEquals(expecteds, actuals);

	}
}
