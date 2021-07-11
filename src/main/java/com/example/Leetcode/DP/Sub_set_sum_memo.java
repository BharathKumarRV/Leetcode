package com.example.Leetcode.DP;

public class Sub_set_sum_memo {

	// A utility function that returns
	// maximum of two integers
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	// Returns the value of maximum profit
	static boolean isSubsetSumRec(int set[], int n, int sum, boolean[][] dp) {

		if (sum == 0)
			return true;

		if (n <= 0)
			return false;

		// If the value is not -1 it means it
		// already call the function
		// with the same value.
		// it will save our from the repetation.

		if (dp[n][sum])
			return true;

		// Here we do two calls because we
		// don't know which value is
		// full-fill our critaria
		// that's why we doing two calls
		if (set[n - 1] <= sum) {
			return dp[n][sum] = isSubsetSum(set, n - 1, sum) || isSubsetSum(set, n - 1, sum - set[n - 1]);
		} // If last element is greater than
			// sum, then ignore it
		else {
			return dp[n][sum] = isSubsetSum(set, n - 1, sum);
		}
	}

	static boolean isSubsetSum(int set[], int N, int sum) {

		// Declare the table dynamically
		boolean dp[][] = new boolean[N + 1][sum + 1];

		return isSubsetSumRec(set, N, sum, dp);
	}

	// Driver Code
	public static void main(String[] args) {
		int set[] = { 3, 34, 4, 12, 5, 2 };
		int sum = 9;
		int n = set.length;
		if (isSubsetSum(set, n, sum) == true)
			System.out.println("Found a subset" + " with given sum");
		else
			System.out.println("No subset with" + " given sum");
	}

}
