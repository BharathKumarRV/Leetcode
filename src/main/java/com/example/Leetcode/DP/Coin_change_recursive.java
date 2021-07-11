package com.example.Leetcode.DP;

public class Coin_change_recursive {

	// Returns the maximum value that
	// can be put in a knapsack of
	// capacity W
	static int coinChange(int sum, int val[], int n) {
		// Base Case
		if (sum == 0)
			return 1;
		if (n == 0)
			return 0;

		// Return the maximum of two cases:
		// (1) nth item included
		// (2) not included

		if (val[n - 1] <= sum) {
			return coinChange(sum - val[n - 1], val, n) + coinChange(sum, val, n - 1);
		}

		// If weight of the nth item is
		// more than Knapsack capacity W,
		// then this item cannot be included
		// in the optimal solution
		else {
			return coinChange(sum, val, n - 1);
		}

	}

	// Driver code
	public static void main(String args[]) {
		int val[] = new int[] { 1, 2, 3};
		int sum = 4;
		int n = val.length;
		System.out.println(coinChange(sum, val, n));
	}
}
