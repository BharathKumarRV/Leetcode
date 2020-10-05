package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Unique_paths_recursion {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int res = uniquePaths(3, 3);
		System.out.println(res);

	}

	public static int uniquePaths(int m, int n) {
		return uniquePathsHelper(m - 1, n - 1);
	}

	private static int uniquePathsHelper(int m, int n) {
		if (m < 0 || n < 0) {
			return 0;
		} else if (m == 0 || n == 0) {
			return 1;
		} else {
			return uniquePathsHelper(m - 1, n) + uniquePathsHelper(m, n - 1);
		}
	}

}
