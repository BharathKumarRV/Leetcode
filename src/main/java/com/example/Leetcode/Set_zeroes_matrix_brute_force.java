package com.example.Leetcode;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;

public class Set_zeroes_matrix_brute_force {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		setZeroes(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void setZeroes(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		Set<Integer> rows = new HashSet<>(); // rows that have zero
		Set<Integer> cols = new HashSet<>();
		// calculate zero-rows and columns
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (matrix[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}
		// set zeroes
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (rows.contains(i) || cols.contains(j)) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}
