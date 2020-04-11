package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Decode_ways_recursion_to_dp {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); int res =
	 * numDecodings("226"); System.out.print(res);
	 * 
	 * }
	 */

	public static int numDecodings(String s) {
		int dp[] = new int[s.length() + 1];
		return helper(s, s.length(), dp);
	}

	public static int helper(String s, int k, int dp[]) {
		if (k == 0) {
			return 1;
		}
		int start = s.length() - k;
		if (s.charAt(start) == '0') {
			return 0;
		}
		if (dp[k] != 0) {
			return dp[k];
		}
		int res = helper(s, k - 1, dp);

		if (k >= 2 && Integer.valueOf(s.substring(start, start + 2)) <= 26) {
			res += helper(s, k - 2, dp);
		}
		dp[k] = res;
		return res;
	}
}
