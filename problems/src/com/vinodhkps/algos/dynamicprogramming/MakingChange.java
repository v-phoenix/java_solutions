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
 * M(j) = Minimum { M(j - V(i)) } + 1, for all i.
 * 
 * 
 * @author Vinodh Periyasamy
 *
 *
 *
 */

public class MakingChange {

	/**
	 * 
	 * @param makeChange
	 *            -- total money for which a distribution of change needs to be
	 *            found. This needs to be in the same metric as the coins are
	 *            denominated. E.g. If US metric system, this should be in
	 *            Cents. If Indian metric system, this should be in paises.
	 */

	// Bottom Up Implementation
	int makeChange(int amount, int[] coins) {

		int[] solutions = new int[coins.length];
		int[] solutionsForAmount = new int[amount + 1];

		solutionsForAmount[0] = 0;

		for (int i = 1; i <= amount; i++) {

			for (int k = 0; k < coins.length; k++)
				solutions[k] = -1;

			for (int k = 0; k < coins.length; k++) {
				if (coins[k] <= i) {
					solutions[k] = solutionsForAmount[i - coins[k]] + 1;
					System.out.println("Amount is " + i + " Coin Used "
							+ coins[k]);
				}
			}

			solutionsForAmount[i] = -1;

			for (int k = 0; k < coins.length; k++) {
				if (solutions[k] > -1) {
					if (solutionsForAmount[i] == -1
							|| solutionsForAmount[i] > solutions[k]) {
						solutionsForAmount[i] = solutions[k];
						System.out.println("solutions["+k+"] " + solutions[k]);
					}
				}
			}
		}

		return solutionsForAmount[amount];
	}

}
