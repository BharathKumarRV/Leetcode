package com.example.Leetcode.DP;

public class Coin_change_dp {

	static int subSetSumCount(int val[], int sum, int n) {
		// int i, j;
		int dp[][] = new int[n + 1][sum + 1];

		dp[0][0] = 1;

		for (int i = 1; i <= sum; i++)
			dp[0][i] = 0;

		for (int i = 1; i <= n; i++)
			dp[i][0] = 1;

		// Build table K[][] in bottom up manner
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (val[i - 1] <= j)
					dp[i][j] = dp[i][j - val[i - 1]] + dp[i - 1][j];
				else
					dp[i][j] = dp[i - 1][j];
			}
		}

		return dp[n][sum];
	}

	// Driver code
	public static void main(String args[]) {
		int val[] = new int[] { 1, 2, 3 };
		int sum = 4;
		int n = val.length;
		System.out.println(subSetSumCount(val, sum, n));
	}
}
