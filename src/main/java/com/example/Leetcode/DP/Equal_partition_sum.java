package com.example.Leetcode.DP;

public class Equal_partition_sum {

	// A recursive Java solution for partition problem

	// A utility function that returns true if there is a
	// subset of arr[] with sun equal to given sum
	static boolean isSubsetSum(int arr[], int n, int sum) {
		if (sum == 0)
			return true;
		if (n == 0)
			return false;

		/*
		 * else, check if sum can be obtained by any of the following (a) including the
		 * last element (b) excluding the last element
		 */
		if (arr[n - 1] <= sum) {
			return isSubsetSum(arr, n - 1, sum) || isSubsetSum(arr, n - 1, sum - arr[n - 1]);
		}// If last element is greater than
		// sum, then ignore it
		else {
			return isSubsetSum(arr, n - 1, sum);
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
		return isSubsetSum(arr, n, sum / 2);
	}

	// Driver code
	public static void main(String[] args) {

		int arr[] = { 3, 1, 5, 10, 12};
		int n = arr.length;

		// Function call
		if (findPartition(arr, n) == true)
			System.out.println("Can be divided into two " + "subsets of equal sum");
		else
			System.out.println("Can not be divided into " + "two subsets of equal sum");
	}
}
