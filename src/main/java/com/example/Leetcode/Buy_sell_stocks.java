package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Buy_sell_stocks {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); int []prices= {1, 7,
	 * 4, 11}; int res = maxProfit(prices); System.out.print(res);
	 * 
	 * }
	 */

	public static int maxProfit(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		int max = 0;
		int sofarMin = prices[0];
		for (int i = 0; i < prices.length; ++i) {
			if (prices[i] < sofarMin) {
				sofarMin = prices[i];
			} else {
				max = Math.max(max, prices[i] - sofarMin);
			}
		}
		return max;
	}
}
