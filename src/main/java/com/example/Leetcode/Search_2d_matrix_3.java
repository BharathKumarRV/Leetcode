package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Search_2d_matrix_3 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int matrix[][] = { { 1, 3 } };
		boolean res = stairSearch(matrix, 3);
		System.out.println(res);

	}


	public static boolean stairSearch(int[][] matrix, int target) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int row = 0;
		int col = matrix[0].length - 1;
		while (row < matrix.length && col >= 0) {
			if (matrix[row][col] == target) {
				return true;
			} else if (matrix[row][col] < target) {
				row++;
			} else {
				col--;
			}
		}
		return false;
	}
}
