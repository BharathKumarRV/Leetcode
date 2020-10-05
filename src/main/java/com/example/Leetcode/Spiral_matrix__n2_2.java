package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Spiral_matrix__n2_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[][] res = generateMatrix(4);
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void helper(int[][] num, int rowBegin, int colBegin, int loop, int start) {
		if (loop <= 0) {
			return;
		}
		for (int i = colBegin; i < colBegin + loop; ++i, ++start) {
			num[rowBegin][i] = start;
		}
		for (int i = rowBegin + 1; i < rowBegin + loop; ++i, ++start) {
			num[i][colBegin + loop - 1] = start;
		}
		for (int i = colBegin + loop - 2; i > colBegin - 1; --i, ++start) {
			num[rowBegin + loop - 1][i] = start;
		}
		for (int i = rowBegin + loop - 2; i > rowBegin; --i, ++start) {
			num[i][colBegin] = start;
		}
		helper(num, rowBegin + 1, colBegin + 1, loop - 2, start);
	}

	public static int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		helper(result, 0, 0, n, 1);
		return result;
	}

}
