package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Unique_paths_obstacles_memo {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		int res = uniquePathsWithObstacles(obstacleGrid);
		System.out.println(res);

	}

	static int count = 0;
	static int row;
	static int col;
	static int[][] table;

	public static int uniquePathsWithObstacles(int[][] grid) {
		row = grid.length;
		col = grid[0].length;
		table = new int[row][col];
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				table[i][j] = -1;
			}
		}
		if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1)
			return 0;
		return dfs(0, 0, grid);
	}

	private static int dfs(int x, int y, int[][] grid) {
		if (x == row - 1 && y == col - 1) {
			table[x][y] = 1;
			return 1;
		}
		
		if (table[x][y] >= 0) {
			return table[x][y];
		}
		int result = 0;
		if (x <= row - 1 && y + 1 <= col - 1 && grid[x][y + 1] == 0) {
			result += dfs(x, y + 1, grid);
		}
		if (x + 1 <= row - 1 && y <= col - 1 && grid[x + 1][y] == 0) {
			result += dfs(x + 1, y, grid);
		}
		table[x][y] = result;
		return result;
	}
}
