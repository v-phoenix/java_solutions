package com.vinodhkps.algos.dynamicprogramming;

/*
 * Subsequence considered in this problem:
 * 
 * A subsequence of a given sequence is just the given sequence with zero or more elements left out. Ordering matters here.
 * 
 * Example: {B, C, D, B} is a subsequence of {A, B, C, B, D, A, B} while for {B, C, D, B, A} is not. 
 * 
 * Given two such sequences, below algorithm helps find a longest subsequence that spans across both the given sequence
 * 
 */

public class LongestCommonSubsequence {
	
	char[][] maxSubSequence(char[] seq1, char[] seq2) {

		int m = seq1.length;
		int n = seq2.length;

		char[] X = new char[m + 1];
		char[] Y = new char[n + 1];

		for (int i = 0; i < m; i++) {
			X[i + 1] = seq1[i];
		}

		for (int i = 0; i < n; i++) {
			Y[i + 1] = seq2[i];
		}

		int[][] ret = new int[m + 1][n + 1];
		char[][] retChar = new char[m][n];

		for (int i = 0; i < m + 1; i++)
			ret[i][0] = 0;
		for (int i = 0; i < n + 1; i++)
			ret[0][i] = 0;

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {

				if (X[i] == Y[j]) {
					ret[i][j] = ret[i - 1][j - 1] + 1;
					retChar[i][j] = '\\';
				} else if (ret[i - 1][j] >= ret[i][j - 1]) {
					ret[i][j] = ret[i - 1][j];
					retChar[i][j] = '|';
				} else {
					ret[i][j] = ret[i][j - 1];
					retChar[i][j] = ' ';
				}
			}
		}

		System.out.println(" Max length sub sequence is " + ret[m][n]);
		return retChar;
	}
}
