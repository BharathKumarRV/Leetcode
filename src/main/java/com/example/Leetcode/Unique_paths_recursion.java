package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Unique_paths_recursion {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int res = uniquePaths2(3, 3);
		System.out.println(res);

	}

	//Brute force approach
	//Time complexity is exponential i.e 2^n
	public static int uniquePaths(int m, int n) {
		return uniquePathsHelper_top_down(m - 1, n - 1);
	}

	public static int uniquePaths2(int m, int n) {
		return uniquePathsHelper_bottom_up(0, 0, m - 1, n - 1);
	}

	private static int uniquePathsHelper_top_down(int m, int n) {
		if (m < 0 || n < 0) {
			return 0;
		} else if (m == 0 || n == 0) {
			return 1;
		} else {
			return uniquePathsHelper_top_down(m - 1, n) + uniquePathsHelper_top_down(m, n - 1);
		}
	}

	private static int uniquePathsHelper_bottom_up(int i, int j, int m, int n) {
		if (i >= m || j >= n) {
			return 0;
		} else if (i == m-1 && j == n-1) {
			return 1;
		} else {
			return uniquePathsHelper_bottom_up(i + 1, j, m, n) + uniquePathsHelper_bottom_up(i, j + 1, m, n);
		}
	}

}
