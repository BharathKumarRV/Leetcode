package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Search_2d_matrix_BS {


	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int matrix[][] = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		boolean res = searchMatrix(matrix, 3);
		System.out.println(res);

	}

	static int[][] matrix_new;
    static int target_new;

	public static boolean searchMatrix(int[][] matrix, int target) {
		matrix_new=matrix;
		target_new=target;
		if (matrix.length == 0)
			return false;
		return helper(0, 0, matrix_new.length - 1, matrix_new[0].length - 1);
	}

	private static boolean helper(int x1, int y1, int x2, int y2) {
		if (x2 < x1 || y2 < y1 || x1 >= matrix_new.length || y1 >= matrix_new[0].length || x2 < 0 || y2 < 0)
			return false;
		int mx = (x2 - x1) / 2 + x1;
		int my = (y2 - y1) / 2 + y1;
		// Check the middle element of the matrix, if not found,
		// recursively call on sub matrices where
		// the value could still exist.
		// You will realize that the resultant possible places will
		// form a L shape on the original matrix.
		// This L shape can be broken down into 2 matrices.
		// If number found in any of the 2 matrices, we return true.
		if (matrix_new[mx][my] == target_new)
			return true;
		else if (matrix_new[mx][my] < target_new) {
			return helper(x1, my + 1, x2, y2) || helper(mx + 1, y1, x2, my);
		} else if (matrix_new[mx][my] > target_new) {
			return helper(x1, y1, x2, my - 1) || helper(x1, my, mx - 1, y2);
		} else
			return false;
	}
}
