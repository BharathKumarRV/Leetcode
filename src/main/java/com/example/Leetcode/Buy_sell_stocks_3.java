package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Buy_sell_stocks_3 {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); int[] prices =
	 * {3,3,5,0,0,3,1,4}; int res = maxProfit(prices); System.out.print(res);
	 * 
	 * }
	 */
	
	public static int maxProfit(int[] prices) {
		int oneBuy = Integer.MAX_VALUE;
		int oneBuyOneSell = 0;
		int twoBuy = Integer.MAX_VALUE;
		int twoBuyTwoSell = 0;
		for (int i = 0; i < prices.length; i++) {
			oneBuy = Math.min(oneBuy, prices[i]);
			oneBuyOneSell = Math.max(oneBuyOneSell, prices[i] - oneBuy);
			twoBuy = Math.min(twoBuy, prices[i] - oneBuyOneSell);
			twoBuyTwoSell = Math.max(twoBuyTwoSell, prices[i] - twoBuy);
		}

		return Math.max(oneBuyOneSell, twoBuyTwoSell);
	}
}
