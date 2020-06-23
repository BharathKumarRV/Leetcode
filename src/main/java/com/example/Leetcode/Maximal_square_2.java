package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Maximal_square_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		char matrix[][] = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		int res = maximalSquare(matrix);
		System.out.println(res);

	}

	public static int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}

		int res = 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] sq = new int[m][n];

		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == '1') {
				sq[i][0] = 1;
				res = 1;
			} else {
				sq[i][0] = 0;
			}
		}
		for (int j = 0; j < n; j++) {
			if (matrix[0][j] == '1') {
				sq[0][j] = 1;
				res = 1;
			} else {
				sq[0][j] = 0;
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == '1') {
					//min coz we cannot extend square matrix if 0 is found
					int min = Math.min(Math.min(sq[i][j - 1], sq[i - 1][j]), sq[i - 1][j - 1]);
					// if(min != 0) {
					sq[i][j] = (int) Math.pow(Math.sqrt(min) + 1, 2);
					res = Math.max(res, sq[i][j]);
					// }
				}
			}
		}

		return res;
	}
}
