package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Unique_binary_search_tree {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); int res=numTrees(3);
	 * System.out.print(res);
	 * 
	 * }
	 */

	public static int numTrees(int n) {
	    int [] dp = new int[n+1];
	    dp[0]= 1;
	    dp[1] = 1;
	    for(int level = 2; level <=n; level++)
	        for(int root = 1; root<=level; root++)
	            dp[level] += dp[level-root]*dp[root-1];
	    return dp[n];
	}
}
