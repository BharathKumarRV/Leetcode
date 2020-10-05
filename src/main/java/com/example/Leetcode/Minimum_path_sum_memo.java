package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Minimum_path_sum_memo {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[][] Grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		int res = minPathSum(Grid);
		System.out.println(res);

	}

	public static int minPathSum(int[][] grid) {
		int row = grid.length - 1;
		int col = grid[0].length - 1;
		int[][] dp = new int[row + 1][col + 1];
		return minPathSum(grid, row, col, dp);
	}

	public static int minPathSum(int[][] grid, int row, int col, int[][] dp) {
		if (row == 0 && col == 0)
			return grid[row][col];

		if (dp[row][col] != 0)
			return dp[row][col];

		if (row != 0 && col == 0)
			return dp[row][col] = grid[row][col] + minPathSum(grid, row - 1, col, dp);

		if (row == 0 && col != 0)
			return dp[row][col] = grid[row][col] + minPathSum(grid, row, col - 1, dp);

		return dp[row][col] = grid[row][col]
				+ Math.min(minPathSum(grid, row - 1, col, dp), minPathSum(grid, row, col - 1, dp));
	}
}
