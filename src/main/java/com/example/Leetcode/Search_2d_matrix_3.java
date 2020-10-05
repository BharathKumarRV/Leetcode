package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Search_2d_matrix_3 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int matrix[][] = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		boolean res = stairSearch(matrix, 11);
		System.out.println(res);

	}

	public static boolean stairSearch(int matrix[][], int element) {
		int n = matrix.length;
		if (element < matrix[0][0] || element > matrix[n - 1][n - 1])
			return false;
		int r = 0;
		int c = n - 1;
		while (r <= n - 1 && c >= 0) {
			if (matrix[r][c] < element)
				r++;
			else if (matrix[r][c] > element)
				c--;
			else
				return true;
		}
		return false;
	}
}
