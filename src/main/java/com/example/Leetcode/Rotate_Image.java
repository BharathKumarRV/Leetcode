package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Rotate_Image {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int rows = matrix.length;
		int columns = matrix[0].length;
		rotate(matrix);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void rotate(int[][] matrix) {

		int N = matrix.length;

		// swap the symmetry
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		// exchange the first and last numbers in a row
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < (N / 2); j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][N - 1 - j];
				matrix[i][N - 1 - j] = temp;
			}
		}
	}
}
