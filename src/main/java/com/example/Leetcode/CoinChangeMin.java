package com.example.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class CoinChangeMin {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int coins[] = { 1, 2, 5 };
		int res = coinChange(coins, 11);
		List<Integer> ans = coinChange_3(coins, 11);
		System.out.println(ans);
	}

	public static int coinChange(int[] coins, int amount) {
		if (amount < 0)
			return -1;
		if (amount == 0)
			return 0;
		int cc = -1;
		for (int i = 0; i < coins.length; i++) {
			int coin = coinChange(coins, amount - coins[i]);
			if (coin >= 0)
				cc = cc < 0 ? coin + 1 : Math.min(cc, coin + 1);
		}
		return cc;
	}

	public static int coinChange_2(int[] coins, int amount) {

		int dp[] = new int[amount + 1];

		Arrays.fill(dp, amount + 1);
		dp[0] = 0;

		for (int i = 0; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
				}
			}
		}

		return (dp[amount] > amount) ? -1 : dp[amount];
	}

	public static List<Integer> coinChange_3(int[] coins, int amount) {

		List<Integer> ans = new ArrayList<Integer>();
		for (int i = coins.length - 1; i >= 0; i--) {
			while (coins[i] <= amount) {

				amount -= coins[i];
				ans.add(coins[i]);
			}
		}

		return ans;
	}

}
