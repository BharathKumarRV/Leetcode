package com.example.Leetcode.DP;

public class Equal_partition_sum_memo {

	// A recursive Java solution for partition problem

	// A utility function that returns true if there is a
	// subset of arr[] with sun equal to given sum
	static boolean isSubsetSum(int arr[], int n, int sum, boolean dp[][]) {
		if (sum == 0)
			return true;
		if (n == 0)
			return false;

		if (dp[n][sum])
			return true;
		if (arr[n - 1] <= sum) {
			return dp[n][sum] = isSubsetSum(arr, n - 1, sum, dp) || isSubsetSum(arr, n - 1, sum - arr[n - 1], dp);
		} // If last element is greater than
			// sum, then ignore it
		else {
			return dp[n][sum] = isSubsetSum(arr, n - 1, sum, dp);
		}
	}

	// Returns true if arr[] can be partitioned in two
	// subsets of equal sum, otherwise false
	static boolean findPartition(int arr[], int n) {
		// Calculate sum of the elements in array
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += arr[i];

		// If sum is odd, there cannot be two subsets
		// with equal sum
		if (sum % 2 != 0)
			return false;

		// Find if there is subset with sum equal to half
		// of total sum
		boolean dp[][] = new boolean[n + 1][sum / 2 + 1];
		return isSubsetSum(arr, n, sum / 2, dp);
	}

	// Driver code
	public static void main(String[] args) {

		int arr[] = { 3, 1, 5, 9, 12 };
		int n = arr.length;

		// Function call
		if (findPartition(arr, n) == true)
			System.out.println("Can be divided into two " + "subsets of equal sum");
		else
			System.out.println("Can not be divided into " + "two subsets of equal sum");
	}
}
