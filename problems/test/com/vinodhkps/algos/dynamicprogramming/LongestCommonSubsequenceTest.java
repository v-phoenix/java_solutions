package com.vinodhkps.algos.dynamicprogramming;

import org.junit.Test;

public class LongestCommonSubsequenceTest {

	LongestCommonSubsequence classUnderTest = new  LongestCommonSubsequence();
	
	@Test
	public void testMaxSubSequence() {
		char[] X = { 'A', 'B', 'C', 'B', 'D', 'A', 'B' };
		char[] Y = { 'B', 'D', 'C', 'A', 'B', 'A' };
		
		classUnderTest.maxSubSequence(X, Y);
	}

}
