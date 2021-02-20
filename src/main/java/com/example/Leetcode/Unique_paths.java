package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Unique_paths {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int res = uniquePaths(7, 3);
		System.out.println(res);

	}

	public static int uniquePaths(int m, int n) {
		int[][] map = new int[m][n];
		for (int i = 0; i < m; i++) {
			map[i][0] = 1;
		}
		for (int j = 0; j < n; j++) {
			map[0][j] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				map[i][j] = map[i - 1][j] + map[i][j - 1];
			}
		}
		return map[m - 1][n - 1];
	}

	public static int uniquePaths2(int m, int n) {
		int[][] map = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					map[i][j] = 1;
				} else {
					map[i][j] = map[i - 1][j] + map[i][j - 1];
				}
			}
		}
		return map[m - 1][n - 1];
	}
}
