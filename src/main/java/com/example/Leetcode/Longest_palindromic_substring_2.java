package com.example.Leetcode;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;

public class Longest_palindromic_substring_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		String res = longestPalindrome("babad");
		System.out.println(res);

	}

	public static String longestPalindrome(String s) {
		int n = s.length();
		String res = null;

		boolean[][] dp = new boolean[n][n];

		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

				if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
					res = s.substring(i, j + 1);
				}
			}
		}

		return res;
	}
}
