package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Minimum_path_sum_recursion {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[][] Grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		int res = minPathSum(Grid);
		System.out.println(res);

	}

	public static int minPathSum(int[][] grid) {

		int height = grid.length;
		int width = grid[0].length;
		return min(grid, height - 1, width - 1);

	}

	public static int min(int[][] grid, int row, int col) {

		if (row == 0 && col == 0)
			return grid[row][col]; // this is the exit of the recursion
		if (row == 0)
			return grid[row][col]
					+ min(grid, row, col - 1); /** when we reach the first row, we could only move horizontally. */
		if (col == 0)
			return grid[row][col]
					+ min(grid, row - 1, col); /** when we reach the first column, we could only move vertically. */
		return grid[row][col] + Math.min(min(grid, row - 1, col),
				min(grid, row, col - 1)); /** we want the min sum path so we pick the cell with the less value */

	}
}
