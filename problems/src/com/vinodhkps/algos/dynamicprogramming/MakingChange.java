package com.vinodhkps.algos.dynamicprogramming;

/**
 * 
 * Problem Statement:
 * 
 * You are given n types of coin denominations of values v(1) < v(2) < ... <
 * v(n) (all integers). Assume v(1) = 1, so you can always make change for any
 * amount of money C. Give an algorithm which makes change for an amount of
 * money C with as few coins as possible.
 * 
 * Solution:
 * 
 * Recurrence M(j) = Minimum number of coins required to make change for amount
 * j.
 * 
 * Recurrence:
 * 
 * M(j) = Minimum { M(j - V(i) } + 1, for all i.
 * 
 * 
 * @author vinodhkps
 *
 */

public class MakingChange {

	/**
	 * 
	 * @param totalMoney
	 *            -- total money for which a distribution of change needs to be
	 *            found. This needs to be in the same metric as the coins are
	 *            denominated. E.g. If US metric system, this should be in
	 *            Cents. If Indian metric system, this should be in paises.
	 */

	void findMinChange(int totalMoney) {

		if (totalMoney <= 0) {
			throw new IllegalArgumentException(
					"Input total money is negative, cannot find a denomication");
		}

		// Running Total of how much money has been distributed
		int remainingMoney = totalMoney;

	}

}
