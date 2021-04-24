package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Buy_sell_stocks_kadanes {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] prices = { 1, 7, 4, 11 };
		int res = maxProfit(prices);
		System.out.print(res);

	}

	public static int maxProfit(int[] prices) {
		int maxCur = 0, maxSoFar = 0;
		for (int i = 1; i < prices.length; i++) {
			maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
			maxSoFar = Math.max(maxCur, maxSoFar);
		}
		return maxSoFar;
	}
}
