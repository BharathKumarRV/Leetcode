package com.example.Leetcode.DP;

public class Coin_change_memo {

	// Returns the maximum value that
	// can be put in a knapsack of
	// capacity W
	static int coinChangeRec(int sum, int val[], int n, int dp[][]) {
		// Base Case
		if (sum == 0)
			return 1;
		if (n == 0)
			return 0;

		if (dp[n][sum] != -1)
			return dp[n][sum];

		if (val[n - 1] <= sum) {
			return dp[n][sum] = coinChangeRec(sum - val[n - 1], val, n, dp) + coinChangeRec(sum, val, n - 1, dp);
		}

		// If weight of the nth item is
		// more than Knapsack capacity W,
		// then this item cannot be included
		// in the optimal solution
		else {
			return dp[n][sum] = coinChangeRec(sum, val, n - 1, dp);
		}

	}

	static int coinChange(int val[], int sum, int n) {

		// Declare the table dynamically
		int dp[][] = new int[n + 1][sum + 1];
		for (int i = 0; i < n + 1; i++)
			for (int j = 0; j < sum + 1; j++)
				dp[i][j] = -1;

		return coinChangeRec(sum, val, n, dp);
	}

	// Driver code
	public static void main(String args[]) {
		int val[] = new int[] { 1, 2, 3 };
		int sum = 4;
		int n = val.length;
		System.out.println(coinChange(val, sum, n));
	}
}
