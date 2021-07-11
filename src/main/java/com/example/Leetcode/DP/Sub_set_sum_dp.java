package com.example.Leetcode.DP;

public class Sub_set_sum_dp {

	// A Dynamic Programming solution for subset
	// sum problem

	// Returns true if there is a subset of
	// set[] with sun equal to given sum
	static boolean isSubsetSum(int set[], int n, int sum) {
		boolean subset[][] = new boolean[n + 1][sum + 1];

		for (int i = 0; i <= sum; i++)
			subset[0][i] = false;

		for (int i = 0; i <= n; i++)
			subset[i][0] = true;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (set[i - 1] <= j) {
					subset[i][j] = subset[i - 1][j] || subset[i - 1][j - set[i - 1]];
				} else {
					subset[i][j] = subset[i - 1][j];
				}
			}
		}

		
		return subset[n][sum];
	}

	/* Driver code */
	public static void main(String args[]) {
		int set[] = { 3, 34, 4, 12, 5, 2 };
		int sum = 70;
		int n = set.length;
		if (isSubsetSum(set, n, sum) == true)
			System.out.println("Found a subset" + " with given sum");
		else
			System.out.println("No subset with" + " given sum");
	}
}
