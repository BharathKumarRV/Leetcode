package com.example.Leetcode.DP;

//Here is the top-down approach of
//dynamic programming
public class knapsack_memo {

//A utility function that returns
//maximum of two integers	
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

//Returns the value of maximum profit
	static int knapSackRec(int W, int wt[], int val[], int n, int[][] dp) {

		// Base condition
		if (n == 0 || W == 0)
			return 0;

		if (dp[n][W] != -1)
			return dp[n][W];

		// Return the maximum of two cases:
		// (1) nth item included
		// (2) not included

		if (wt[n - 1] <= W) {
			return dp[n][W] = max(val[n - 1] + knapSackRec(W - wt[n - 1], wt, val, n - 1, dp),
					knapSackRec(W, wt, val, n - 1, dp));
		}

		// If weight of the nth item is
		// more than Knapsack capacity W,
		// then this item cannot be included
		// in the optimal solution
		else {
			return dp[n][W] = knapSackRec(W, wt, val, n - 1, dp);
		}
	}

	static int knapSack(int W, int wt[], int val[], int N) {

		// Declare the table dynamically
		int dp[][] = new int[N + 1][W + 1];

		// Loop to initially filled the
		// table with -1
		for (int i = 0; i < N + 1; i++)
			for (int j = 0; j < W + 1; j++)
				dp[i][j] = -1;

		return knapSackRec(W, wt, val, N, dp);
	}

//Driver Code
	public static void main(String[] args) {
		int val[] = { 60, 100, 120 };
		int wt[] = { 10, 20, 30 };

		int W = 50;
		int N = val.length;

		System.out.println(knapSack(W, wt, val, N));
	}
}
