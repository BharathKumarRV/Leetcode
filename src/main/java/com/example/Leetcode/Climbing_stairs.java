package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Climbing_stairs {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); int res =
	 * climbStairs(4); System.out.println(res); }
	 */

	 public static int climbStairs(int n) {
	        int[] ways = new int[n + 1];
	        if (n<=1) {
	            return 1;
	        }
	        ways[0] = 1;
	        ways[1] = 1;
	        for (int i = 2; i <= n; i++) {
	          ways[i] = ways[i-1] + ways[i - 2];
	        }
	        return ways[n];
	    }
}
