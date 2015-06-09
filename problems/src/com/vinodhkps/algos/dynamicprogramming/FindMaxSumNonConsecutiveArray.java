package com.vinodhkps.algos.dynamicprogramming;

/*
 * E.g. For a given array {5, 1, 3, 5}, the output should be 10.
 * 
 */
public class FindMaxSumNonConsecutiveArray {

	/*
	 * Recursive non-optimized solution
	 */
	int findMaxSum(int[] A, int start, int end) {
		int ret = -1;
		int S[] = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			S[i] = -1;
		}

		if (start > end) {
			ret = 0;
		}
		if (start == end) {
			ret = A[end];
		}

		if (ret == -1) {
			for (int i = start; i <= end; i++) {
				S[i] = A[i] + findMaxSum(A, i + 2, end);
			}

			for (int i = 0; i < S.length; i++) {
				if (S[i] > ret) {
					ret = S[i];
				}
			}
		}
		return ret;
	}

}
