package com.vinodhkps.algos.dynamicprogramming;

public class KnapSackProblem {

	/**
	 * A 0/1 knapsack implementation. i.e. Either the element is fully taken or
	 * left out.
	 */

	public int knapSack(int[] weights, int[] prices, int maxWeight) {

		int val[][] = new int[weights.length + 1][maxWeight + 1];

		for (int w = 0; w < weights.length; w++) {

			for (int i = 0; i <= maxWeight; i++) {

				if (i == 0 || w == 0) {
					val[w][i] = 0;
				} else if (weights[w - 1] <= i) {
					val[w][i] = max(prices[w - 1]
							+ val[w - 1][i - weights[w - 1]], val[w - 1][i]);
				} else {
					val[w][i] = val[w - 1][i];
				}

			}
		}

		return val[weights.length - 1][maxWeight];
	}

	private int max(int i, int j) {
		return (i < j ? j : i);
	}

}
