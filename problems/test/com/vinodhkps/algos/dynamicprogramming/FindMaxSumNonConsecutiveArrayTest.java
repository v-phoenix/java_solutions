package com.vinodhkps.algos.dynamicprogramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindMaxSumNonConsecutiveArrayTest {

	FindMaxSumNonConsecutiveArray classUnderTest = new FindMaxSumNonConsecutiveArray();

	@Test
	public void test() {
		int[] A = { 5, 1, 3, 5 };
		int actual = classUnderTest.findMaxSum(A, 0, A.length - 1);
		int expected = 10;

		assertEquals(expected, actual);
		
		int [] B = {3, 2, 5, 10, 7};
		
		actual = classUnderTest.findMaxSum(B, 0, B.length - 1);
		expected = 15;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testNonRecursive() {
		int[] A = { 5, 1, 3, 5 };
		int actual = classUnderTest.maxSumNonRecursive(A);
		int expected = 10;

		assertEquals(expected, actual);
		
		int [] B = {3, 2, 5, 10, 7};
		
		actual = classUnderTest.maxSumNonRecursive(B);
		expected = 15;
		
		assertEquals(expected, actual);
		
	}

}
