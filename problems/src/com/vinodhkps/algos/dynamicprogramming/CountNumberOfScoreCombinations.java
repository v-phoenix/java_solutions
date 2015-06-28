package com.vinodhkps.algos.dynamicprogramming;


/**
 * 
 * You have an aggregate score s and W which specifies the points that can be
 * scored in an individual play. How would you find the number of combinations
 * of plays that result in an aggregate score of s? How would you compute the
 * number of distinct sequences of individual plays that result in a score of s
 *
 * @author Vinodh Periyasamy
 *
 */

public class CountNumberOfScoreCombinations {

	int findNumberOfScoreCombinations(int[] possibleTypesOfPoints, int score) {

		int ret = -1;
		int sols[] = new int[score + 1];

		// Initialize
		for (int k = 0; k < sols.length; k++) {
			sols[k] = 0;
		}

		sols[0] = 1;

		for (int p = 0; p < possibleTypesOfPoints.length; p++) {
			int point = possibleTypesOfPoints[p];
			for (int i = point; i <= score; i++) {
				if (point <= i) {
					sols[i] = sols[i] + sols[i - point];
				}
			}
		}

		/*-- for debugging --*/
		for (int i = 0; i < sols.length; i++) {
			System.out.println("sol[" + i + "]\t" + sols[i]);
		}
		ret = sols[score];
		return ret;

	}
}
