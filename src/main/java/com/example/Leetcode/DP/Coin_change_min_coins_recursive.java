package com.example.Leetcode.DP;

public class Coin_change_min_coins_recursive {

	static int minCoins(int coins[], int amount) {

		if (amount == 0) {
			return 0;
		}
		if (amount < 0) {
			return Integer.MAX_VALUE - 1;
		}

		int res = Integer.MAX_VALUE;

		for (int i = 0; i < coins.length; i++) {
			int ways = 1 + minCoins(coins, amount - coins[i]);

			if (ways < res) {
				res = ways;
			}
		}

		return res;
	}

	public static void main(String args[]) {
		int coins[] = { 1, 2, 3 };
		int m = coins.length;
		int V = 5;
		int dp[][] = new int[m + 1][V + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= V; j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println("Minimum coins required is " + minCoins(coins, V));
	}
}
