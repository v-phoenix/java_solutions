package com.vinodhkps.algos.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

public class MakingChangeTest {

	MakingChange classUnderTest = new MakingChange();

	@Test
	public void testMakeChange() {
		int[] coins = { 1, 5, 10 };
		int amount = 6;

		int expected = 2;
		int actual = classUnderTest.makeChange(amount, coins);

		Assert.assertEquals(expected, actual);

		/*
		expected = 1;
		actual = classUnderTest.makeChange(10, coins);

		Assert.assertEquals(expected, actual);

		expected = 10;
		actual = classUnderTest.makeChange(100, coins);

		Assert.assertEquals(expected, actual);
		*/

	}

}
