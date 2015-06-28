package com.vinodhkps.algos.dynamicprogramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxSubArraySumTest {

	@Test
	public void testFindMaxSubArraySum() {
		int[] A = { 904, 40, 523, 12, -335, -385, -124, 481, -31 };

		int expected = 1479;
		int actual = new MaxSubArraySum().findMaxSubArraySum(A);

		assertEquals(expected, actual);
	}

}
