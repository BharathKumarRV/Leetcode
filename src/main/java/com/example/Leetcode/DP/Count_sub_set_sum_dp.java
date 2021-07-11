package com.example.Leetcode.DP;

public class Count_sub_set_sum_dp {

	// Returns the maximum value that can
	// be put in a knapsack of capacity W
	static int subSetSumCount(int arr[], int sum, int n) {
		//int i, j;
		int dp[][] = new int[n + 1][sum + 1];
		
		dp[0][0] = 1;
		 
	    for(int i = 1; i <= sum; i++)
	    	dp[0][i] = 0;
	 
	    for(int i = 1; i <= n; i++)
	    	dp[i][0] = 1;

		// Build table K[][] in bottom up manner
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (arr[i - 1] <= j)
					dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
				else
					dp[i][j] = dp[i - 1][j];
			}
		}

		return dp[n][sum];
	}

	// Driver code
	public static void main(String args[]) {
		int arr[] = new int[] { 2, 3, 5, 6, 8, 10 };
		int sum = 10;
		int n = arr.length;
		System.out.println(subSetSumCount(arr, sum, n));
	}
}
