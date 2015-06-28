package com.vinodhkps.algos.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

public class KnapSackProblemTest {

	@Test
	public void testFindMaxSteal() {
		/*--Courtesy: test data From rosettacode.org--*/

		int[] weights = { 9, 13, 153, 50, 15, 68, 27, 39, 23, 52, 11, 32, 24,
				48, 73, 42, 43, 22, 7, 18, 4, 30 };

		int[] prices = { 150, 35, 200, 160, 60, 45, 60, 40, 30, 10, 70, 30, 15,
				10, 40, 70, 75, 80, 20, 12, 50, 10 };

		int maxWeight = 400;
		KnapSackProblem classUnderTest = new KnapSackProblem();
		int actual = classUnderTest.knapSack(weights, prices, maxWeight);
		int expected = 1030;

		Assert.assertEquals(expected, actual);

	}

}
