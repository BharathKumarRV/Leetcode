package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Search_2d_matrix_4 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int matrix[][] = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		boolean res = stairSearch(matrix, 30);
		System.out.println(res);

	}

	public static boolean stairSearch(int[][] matrix, int target) {
		int r = matrix.length;
		if (r == 0)
			return false;

		int c = matrix[0].length;
		int r1 = 0, r2 = r - 1, mid;
		//Finding the row where target lies
		while (r1 < r2) {
			mid = r1 + (r2 - r1) / 2;
			if (matrix[mid][c - 1] < target)
				r1 = mid + 1;
			else if (matrix[mid][0] > target)
				r2 = mid - 1;
			else {
				r1 = mid;
				break;
			}
		}

		int c1 = 0, c2 = c - 1;
		//Finding the target in the row
		while (c1 <= c2) {
			mid = c1 + (c2 - c1) / 2;
			if (matrix[r1][mid] < target)
				c1 = mid + 1;
			else if (matrix[r1][mid] > target)
				c2 = mid - 1;
			else
				return true;
		}
		return false;
	}
}
