package com.vinodhkps.algos.dynamicprogramming;

public class MaxSubArraySum {

	/*-- brute force O(n^3) --*/
	int findMaxSubArraySum(int[] A) {
		int ret = 0;

		int s = -1, e = -1;

		for (int i = 0; i < A.length; i++) {
			for (int j = i; j < A.length; j++) {
				int temp = 0;
				for (int k = i; k <= j; k++) {
					temp = temp + A[k];
				}
				if (temp > ret) {
					s = i;
					e = j;
					ret = temp;
				}
			}
		}
		System.out.println("Max Sub Array Sum Starts from " + s
				+ " and ends at " + e + " for a value of " + ret);
		return ret;
	}

}
