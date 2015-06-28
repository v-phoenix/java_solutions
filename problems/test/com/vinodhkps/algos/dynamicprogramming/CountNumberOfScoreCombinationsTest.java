package com.vinodhkps.algos.dynamicprogramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountNumberOfScoreCombinationsTest {

	@Test
	public void testFindNumberOfScoreCombinations() {
		int[] possibleTypesOfPoints = { 3, 2, 7 };
		int score = 12;

		CountNumberOfScoreCombinations classUnderTest = new CountNumberOfScoreCombinations();
		int expected = 4;
		int actual = classUnderTest.findNumberOfScoreCombinations(
				possibleTypesOfPoints, score);

		assertEquals(expected, actual);
	}

}
