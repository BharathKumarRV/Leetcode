package com.example.Leetcode.DP;

public class Egg_dropping_memo {

	// static int t[][] = new int[][];

	// int dp[][] = new int[n + 1][sum + 1];

	public static void main(String args[]) {
		System.out.println(eggDrop(2, 10));
	}

	static int eggDropRec(int n, int k, int dp[][]) {
		// If there are no floors, then
		// no trials needed. OR if there
		// is one floor, one trial needed.
		if (k == 1 || k == 0)
			return k;

		// We need k trials for one egg
		// and k floors
		if (n == 1)
			return k;

		int min = Integer.MAX_VALUE;
		int x, res;

		// Consider all droppings from
		// 1st floor to kth floor and
		// return the minimum of these
		// values plus 1.
		if (dp[n][k] != -1) {
			return dp[n][k];
		}
		for (x = 1; x <= k; x++) {
			res = 1 + Math.max(eggDrop(n - 1, x - 1), eggDrop(n, k - x));
			if (res < min)
				min = res;
		}

		return dp[n][k] = min;
	}

	static int eggDropRec_2(int e, int f, int dp[][]) {
		// If there are no floors, then
		// no trials needed. OR if there
		// is one floor, one trial needed.
		if (f == 1 || f == 0)
			return f;

		// We need k trials for one egg
		// and k floors
		if (e == 1)
			return f;

		int min = Integer.MAX_VALUE;
		int k, res;

		// Consider all droppings from
		// 1st floor to kth floor and
		// return the minimum of these
		// values plus 1.
		if (dp[e][f] != -1) {
			return dp[e][f];
		}
		for (k = 1; k <= f; k++) {
			int low, high;
			if (dp[e - 1][k - 1] != -1) {
				low = dp[e - 1][k - 1];
			} else {
				low = eggDrop(e - 1, k - 1);
			}

			if (dp[e][f - k] != -1) {
				high = dp[e][f - k];
			} else {
				high = eggDrop(e, f - k);
			}
			res = 1 + Math.max(low, high);
			if (res < min)
				min = res;
		}

		return dp[e][f] = min;
	}

	static int eggDrop(int e, int k) {

		// Declare the table dynamically
		int dp[][] = new int[e + 1][k + 1];
		for (int i = 0; i < e + 1; i++)
			for (int j = 0; j < k + 1; j++)
				dp[i][j] = -1;

		return eggDropRec_2(e, k, dp);
	}
}
