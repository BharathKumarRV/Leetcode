package com.example.Leetcode.DP;

public class knapsack_top_down {

	// A Dynamic Programming based solution
	// for 0-1 Knapsack problem

	// A utility function that returns
	// maximum of two integers
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	// Returns the maximum value that can
	// be put in a knapsack of capacity W
	static int knapSack(int W, int wt[], int val[], int n) {
		int i, j;
		int dp[][] = new int[n + 1][W + 1];

		// Build table K[][] in bottom up manner
		for (i = 0; i <= n; i++) {
			for (j = 0; j <= W; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else if (wt[i - 1] <= j)
					dp[i][j] = max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
				else
					dp[i][j] = dp[i - 1][j];
			}
		}

		return dp[n][W];
	}

	// Driver code
	public static void main(String args[]) {
		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 50;
		int n = val.length;
		System.out.println(knapSack(W, wt, val, n));
	}
}

