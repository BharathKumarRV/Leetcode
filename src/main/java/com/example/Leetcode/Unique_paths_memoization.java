package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Unique_paths_memoization {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int res = uniquePaths(3, 3);
		System.out.println(res);

	}

	public static int uniquePaths(int m, int n) {
		return uniquePathsHelper(m - 1, n - 1, new int[m][n]);
	}

	private static int uniquePathsHelper(int m, int n, int[][] memo) {
		if (m < 0 || n < 0) {
			return 0;
		}
		else if (m == 0 || n == 0) {
			return 1;
		} else if (memo[m][n] > 0) {
			return memo[m][n];
		} else {
			memo[m][n] = uniquePathsHelper(m - 1, n, memo) + uniquePathsHelper(m, n - 1, memo);
			return memo[m][n];
		}
	}
}
