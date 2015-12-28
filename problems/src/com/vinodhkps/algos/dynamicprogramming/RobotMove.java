package com.vinodhkps.algos.dynamicprogramming;

import static java.util.Arrays.deepToString;

/*

 Problem Statement:

 Imagine a robot sitting on the upper left hand corner of an NxN grid 
 The robot can only move in two directions: right and down. 
 How many possible paths are there for the robot?

 */
public class RobotMove {

	static int findNumberOfWays(int n) {
		int ret = 0;
		if (n > 0) {
			int[][] A = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					A[i][j] = 0;
				}
			}

			// Base Case

			A[0][0] = 1;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i - 1 >= 0) {
						A[i][j] += A[i - 1][j];
					}
					if (j - 1 >= 0) {
						A[i][j] += A[i][j - 1];
					}
				}
			}
			ret = A[n - 1][n - 1];

			System.out.println(deepToString(A));
		}
		return ret;
	}

}
