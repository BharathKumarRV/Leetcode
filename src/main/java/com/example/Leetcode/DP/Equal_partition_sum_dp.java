package com.example.Leetcode.DP;

public class Equal_partition_sum_dp {

	static boolean isSubsetSum(int arr[], int n, int sum) {
		boolean subset[][] = new boolean[n + 1][sum + 1];

		for (int i = 0; i <= sum; i++)
			subset[0][i] = false;

		for (int i = 0; i <= n; i++)
			subset[i][0] = true;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (arr[i - 1] <= j) {
					subset[i][j] = subset[i - 1][j] || subset[i - 1][j - arr[i - 1]];
				} else {
					subset[i][j] = subset[i - 1][j];
				}
			}
		}

		return subset[n][sum];
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
		return isSubsetSum(arr, n, sum / 2);
	}

	// Driver code
	public static void main(String[] args) {

		int arr[] = { 3, 1, 5, 10, 12 };
		int n = arr.length;

		// Function call
		if (findPartition(arr, n) == true)
			System.out.println("Can be divided into two " + "subsets of equal sum");
		else
			System.out.println("Can not be divided into " + "two subsets of equal sum");
	}
}
