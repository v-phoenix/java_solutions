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

	int maxSumNonRecursive(int[] A) {
		int ret = -1;
		int[] sol = new int[A.length];
		int[] solPath = new int[A.length];

		for (int i = A.length - 1; i >= 0; i--) {
			sol[i] = -1;
			solPath[i] = -1;
		}

		for (int i = A.length - 1; i >= 0; i--) {
			int k = i + 2;
			if (k >= A.length) {
				sol[i] = A[i];
				solPath[i] = i;
			} else {
				int temp = -1;
				for (; k < A.length; k++) {
					if (temp < (A[i] + sol[k])) {
						temp = A[i] + sol[k];
						solPath[i] = k;
					}
				}
				sol[i] = temp;
			}
		}

		int pos = -1;

		for (int i = 0; i < A.length; i++) {
			if (ret < sol[i]) {
				ret = sol[i];
				pos = i;
			}
		}

		while (true) {
			if (pos >= A.length - 1) {
				System.out.println("Select A[" + pos + "] which is " + A[pos]);
				break;
			} else {
				System.out.println("Select A[" + pos + "] which is " + A[pos]);
				pos = solPath[pos];
			}
		}
		System.out.println("Max Sum is " + ret);
		System.out.println("==============");
		return ret;
	}
}
