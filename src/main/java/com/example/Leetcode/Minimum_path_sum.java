package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Minimum_path_sum {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[][] Grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		int res = minimumPathSum(Grid);
		System.out.println(res);

	}

	public static int minimumPathSum(int[][] Grid) {
		if (Grid == null || Grid.length == 0 || Grid[0].length == 0) {
			return 0;
		}

		int height = Grid.length;
		int width = Grid[0].length;

		int[][] paths = new int[height][width];

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				paths[i][j] += Grid[i][j];

				if (i > 0 && j > 0) {
					paths[i][j] += Math.min(paths[i - 1][j], paths[i][j - 1]);
				} else if (i > 0) {
					paths[i][j] += paths[i - 1][j];
				} else if (j > 0) {
					paths[i][j] += paths[i][j - 1];
				}

			}
		}

		return paths[height - 1][width - 1];
	}

	public static int minPathSum2(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		for (int i = 1; i < n; i++) {
			grid[0][i] += grid[0][i - 1];
		}
		for (int i = 1; i < m; i++) {
			grid[i][0] += grid[i - 1][0];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
			}
		}
		return grid[m - 1][n - 1];
	}
}
