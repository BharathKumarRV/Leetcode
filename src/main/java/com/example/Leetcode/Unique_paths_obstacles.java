package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Unique_paths_obstacles {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		int res = uniquePathsWithObstacles_2(obstacleGrid);
		System.out.println(res);

	}

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
			return 0;
		}

		int height = obstacleGrid.length;
		int width = obstacleGrid[0].length;

		int[][] paths = new int[height][width];

		// first column
		for (int i = 0; i < height; i++) {
			if (obstacleGrid[i][0] != 1) {
				paths[i][0] = 1;
			} else {
				break;
			}
		}

		// first row
		for (int j = 0; j < width; j++) {
			if (obstacleGrid[0][j] != 1) {
				paths[0][j] = 1;
			} else {
				break;
			}
		}

		// for spaces not at first row or first column
		for (int i = 1; i < height; i++) {
			for (int j = 1; j < width; j++) {
				if (obstacleGrid[i][j] != 1) {
					paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
				}
			}
		}

		return paths[height - 1][width - 1];
	}
	
	//No extra space

	public static int uniquePathsWithObstacles_2(int[][] obstacleGrid) {
		int m = obstacleGrid.length, n = obstacleGrid[0].length;

		// flip upper left cell (the start cell): 1 => 0 or 0 => 1
		obstacleGrid[0][0] ^= 1;

		// first row: if 1, then 0; otherwise, left cell
		for (int i = 1; i < n; i++)
			obstacleGrid[0][i] = obstacleGrid[0][i] == 1 ? 0 : obstacleGrid[0][i - 1];

		// first column: if 1, then 0; otherwise, top cell
		for (int i = 1; i < m; i++)
			obstacleGrid[i][0] = obstacleGrid[i][0] == 1 ? 0 : obstacleGrid[i - 1][0];

		// rest: if 1, then 0; otherwise, left cell + top cell
		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
				obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 0 : obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];

		// return lower right cell (the end cell)
		return obstacleGrid[m - 1][n - 1];
	}
	
	
}
