package com.example.Leetcode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class CoinChangeMinRecursive {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int coins[] = { 1, 2, 5 };
		int res = coinChange(coins, 11);
		System.out.println(res);
	}

	public static int coinChange(int[] coins, int amount) {
		if (coins.length == 0 || amount == 0)
			return 0;
		List<List<Integer>> result = new ArrayList<>();
		helper(coins, amount, 0, result, new ArrayList<>());
		int min = Integer.MAX_VALUE;
		for (List<Integer> each : result) {
			min = Math.min(min, each.size());
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}

	private static void helper(int[] coins, int amount, int index, List<List<Integer>> result, List<Integer> curr) {
		if (amount < 0)
			return;
		if (amount == 0) {
			result.add(new ArrayList<>(curr));
			return;
		}

		for (int i = index; i < coins.length; i++) {
			curr.add(coins[i]);
			helper(coins, amount - coins[i], i, result, curr);
			curr.remove(curr.size() - 1);
		}
	}
}
