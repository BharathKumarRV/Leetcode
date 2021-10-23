package com.example.Leetcode.DP;

public class Rod_cutting_recursive {

	// A utility function that returns
	// maximum of two integers
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	// Returns the maximum value that
	// can be put in a knapsack of
	// capacity W
	static int rodcutting(int L, int N[], int val[], int n) {
		// Base Case
		if (n == 0 || L == 0)
			return 0;

		// Return the maximum of two cases:
		// (1) nth item included
		// (2) not included

		if (N[n - 1] <= L) {
			return max(val[n - 1] + rodcutting(L - N[n - 1], N, val, n), rodcutting(L, N, val, n - 1));
		}

		// If weight of the nth item is
		// more than Knapsack capacity W,
		// then this item cannot be included
		// in the optimal solution
		else {
			return rodcutting(L, N, val, n - 1);
		}

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
