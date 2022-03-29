package com.example.Leetcode.DP;

import java.util.Arrays;

public class Matrix_chain_multiplication_bottom_up {

	static int[][] dp = new int[6][6]; //initialize with size of array.

	// Function for matrix chain multiplication
	static int matrixChainMemoised(int[] p, int i, int j) {
		if (i >= j) {
			return 0;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		int min = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int count = matrixChainMemoised(p, i, k) + matrixChainMemoised(p, k + 1, j) + p[i - 1] * p[k] * p[j];

			if (count < min)
				min = count;
		}
		return dp[i][j]=min;
	}

	static int MatrixChainOrder(int[] p, int n) {
		int i = 1, j = n - 1;
		return matrixChainMemoised(p, i, j);
	}

	// Driver Code
	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4 };
		int n = arr.length;

		for (int[] row : dp)
			Arrays.fill(row, -1);

		System.out.println("Minimum number of multiplications is " + MatrixChainOrder(arr, n));
	}
}
