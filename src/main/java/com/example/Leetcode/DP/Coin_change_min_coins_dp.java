package com.example.Leetcode.DP;

public class Coin_change_min_coins_dp {

	static int minCoins(int coins[], int m, int V) {
		// table[i] will be storing
		// the minimum number of coins
		// required for i value. So
		// table[V] will have result
		int table[] = new int[V + 1];

		// Base case (If given value V is 0)
		table[0] = 0;

		// Initialize all table values as Infinite
		for (int i = 1; i <= V; i++)
			table[i] = Integer.MAX_VALUE;

		// Compute minimum coins required for all
		// values from 1 to V
		for (int i = 1; i <= V; i++) {
			// Go through all coins smaller than i
			for (int j = 0; j < m; j++)
				if (coins[j] <= i) {
					int sub_res = table[i - coins[j]];
					if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i])
						table[i] = sub_res + 1;

				}

		}

		if (table[V] == Integer.MAX_VALUE)
			return -1;

		return table[V];

	}

	static int minCoins_2(int coins[], int m, int V) {
		int table[][] = new int[m + 1][V + 1];

		for (int j = 1; j <= V; j++)
			table[0][j] = Integer.MAX_VALUE - 1;

		for (int j = 1; j <= V; j++)
			if (j / coins[0] == 0) {
				table[1][j] = j / coins[0];
			} else {
				table[1][j] = Integer.MAX_VALUE - 1;
			}

		for (int i = 2; i <= m; i++) {
			for (int j = 1; j <= V; j++)
				if (coins[i - 1] <= j) {
					table[i][j] = Math.min(1 + table[i][j - coins[i - 1]], table[i - 1][j]);

				} else {
					table[i][j] = table[i - 1][j];
				}

		}

		return table[m - 1][V - 1];

	}

	// Driver program
	public static void main(String[] args) {
		int coins[] = { 1, 2, 3 };
		int m = coins.length;
		int V = 5;
		System.out.println("Minimum coins required is " + minCoins_2(coins, m, V));
	}
}
