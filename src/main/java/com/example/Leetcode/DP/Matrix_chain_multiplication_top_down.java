package com.example.Leetcode.DP;

import java.util.Arrays;

public class Matrix_chain_multiplication_top_down {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4 };
		int n = arr.length;

		System.out.println("Minimum number of multiplications is " + MatrixChainOrder(arr, n));
	}

	static int MatrixChainOrder(int[] p, int n) {
		int dp[][] = new int[n - 1][n - 1];

		for (int g = 0; g < dp.length; g++) {
			for (int i = 0, j = g; j < dp.length; i++, j++) {
				if (g == 0) {
					dp[i][j] = 0;
				} else if (g == 1) {
					dp[i][j] = p[i] * p[j] * p[j + 1];
				} else {
					int min = Integer.MAX_VALUE;
					for (int k = i; k < j; k++) {
						int lc = dp[i][k];
						int rc = dp[k + 1][j];
						int mc = p[i] * p[k + 1] * p[j + 1];
						int tc = lc + rc + mc;

						if (tc < min) {
							min = tc;
						}
					}
					dp[i][j] = min;
				}
			}

		}

		return dp[0][dp.length - 1];
	}
}
