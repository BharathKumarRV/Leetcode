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
	
	 public static int maxProfit_2(int[] prices) {
	        int n = prices.length;
	        if(n < 2) return 0;
	        
	        int mpst=0;int mpbt=0;
	        int leastsf = prices[0], maxat = prices[n-1];
	        int[] profit1 = new int[n];
	        int[] profit2 = new int[n];
	        
	        for(int i = 1; i < n; ++i) {
	            leastsf = Math.min(leastsf, prices[i]);
	            mpst=prices[i]-leastsf;
	            if(mpst>profit1[i-1]) {
	            	profit1[i]=mpst;
	            }
	            else {
	            	profit1[i]=profit1[i-1];
	            }
	        }
	        
	        for(int i = n-2; i>=0; i--) {
	        	maxat = Math.max(maxat, prices[i]);
	        	mpbt=maxat-prices[i];
	            if(mpbt>profit2[i+1]) {
	            	profit2[i]=mpbt;
	            }
	            else {
	            	profit2[i]=profit2[i+1];
	            }
	        }
	        
	        int profit = 0;
	        for(int i = 0; i < n; ++i)
	            profit = Math.max(profit, profit1[i] + profit2[i]);
	        return profit;
	    }
}
