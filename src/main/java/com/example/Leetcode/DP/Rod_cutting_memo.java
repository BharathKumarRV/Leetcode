package com.example.Leetcode.DP;

public class Rod_cutting_memo {

	// A utility function that returns
	// maximum of two integers
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	// Returns the maximum value that
	// can be put in a knapsack of
	// capacity W
	static int rodCuttingRec(int L, int N[], int val[], int n, int dp[][]) {
		// Base Case
		if (n == 0 || L == 0)
			return 0;

		// Return the maximum of two cases:
		// (1) nth item included
		// (2) not included
		if (dp[n][L] != -1)
			return dp[n][L];

		if (N[n - 1] <= L) {
			return dp[n][L] = max(val[n - 1] + rodCuttingRec(L - N[n - 1], N, val, n, dp),
					rodCuttingRec(L, N, val, n - 1, dp));
		}

		// If weight of the nth item is
		// more than Knapsack capacity W,
		// then this item cannot be included
		// in the optimal solution
		else {
			return dp[n][L] = rodCuttingRec(L, N, val, n - 1, dp);
		}

	}

	static int rodcutting(int L, int N[], int val[], int n) {

		// Declare the table dynamically
		int dp[][] = new int[n + 1][L + 1];

		// Loop to initially filled the
		// table with -1
		for (int i = 0; i < n + 1; i++)
			for (int j = 0; j < L + 1; j++)
				dp[i][j] = -1;

		return rodCuttingRec(L, N, val, n, dp);
	}

	// Driver code
	public static void main(String args[]) {
		int val[] = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
		int N[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		int L = N.length;
		int n = val.length;
		System.out.println(rodcutting(L, N, val, n));
	}
}
