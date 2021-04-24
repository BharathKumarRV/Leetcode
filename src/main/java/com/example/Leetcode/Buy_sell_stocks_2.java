package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Buy_sell_stocks_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		int res = maxProfit(prices);
		System.out.print(res);

	}

	public static int maxProfit(int[] prices) {
		int total = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i + 1] > prices[i])
				total += prices[i + 1] - prices[i];
		}

		return total;
	}
}
