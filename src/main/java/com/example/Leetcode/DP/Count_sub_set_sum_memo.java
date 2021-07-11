package com.example.Leetcode.DP;

public class Count_sub_set_sum_memo {

	// Returns the value of maximum profit
	static int subsetSumCountRec(int set[], int n, int sum, int[][] dp) {

		if (sum == 0)
			return 1;

		if (n <= 0)
			return 0;

		// If the value is not -1 it means it
		// already call the function
		// with the same value.
		// it will save our from the repetation.

		if (dp[n][sum] != -1)
			return dp[n][sum];

		// Here we do two calls because we
		// don't know which value is
		// full-fill our critaria
		// that's why we doing two calls
		if (set[n - 1] <= sum) {
			return dp[n][sum] = subsetSumCountRec(set, n - 1, sum, dp)
					+ subsetSumCountRec(set, n - 1, sum - set[n - 1], dp);
		} // If last element is greater than
			// sum, then ignore it
		else {
			return dp[n][sum] = subsetSumCountRec(set, n - 1, sum, dp);
		}
	}

	static int subsetSumCount(int set[], int N, int sum) {

		// Declare the table dynamically
		int dp[][] = new int[N + 1][sum + 1];
		for (int i = 0; i < N + 1; i++)
			for (int j = 0; j < sum + 1; j++)
				dp[i][j] = -1;

		return subsetSumCountRec(set, N, sum, dp);
	}

	// Driver Code
	public static void main(String[] args) {
		int set[] = { 2, 3, 5, 6, 8, 10 };
		int sum = 10;
		int n = set.length;
		System.out.println("Subset count sum" + subsetSumCount(set, n, sum));
	}
}
