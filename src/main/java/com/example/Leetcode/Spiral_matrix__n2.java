package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Spiral_matrix__n2 {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); int[][] res =
	 * spiralOrder(4); for(int i=0;i<res.length;i++) { for(int
	 * j=0;j<res[0].length;j++) { System.out.print(res[i][j]+" "); }
	 * System.out.println(); }
	 * 
	 * 
	 * }
	 */

	public static int[][] spiralOrder(int n) {

		int[][] res=new int[n][n];

		int rowBegin = 0;
		int rowEnd = n - 1;
		int colBegin = 0;
		int colEnd = n - 1;
		int counter=1;

		while (rowBegin <= rowEnd && colBegin <= colEnd) {
			// Traverse Right
			for (int j = colBegin; j <= colEnd; j++) {
				res[rowBegin][j]=counter++;
			}
			rowBegin++;

			// Traverse Down
			for (int j = rowBegin; j <= rowEnd; j++) {
				res[j][colEnd]=counter++;
			}
			colEnd--;

			if (rowBegin <= rowEnd) {
				// Traverse Left
				for (int j = colEnd; j >= colBegin; j--) {
					res[rowEnd][j]=counter++;
				}
			}
			rowEnd--;

			if (colBegin <= colEnd) {
				// Traver Up
				for (int j = rowEnd; j >= rowBegin; j--) {
					res[j][colBegin]=counter++;
				}
			}
			colBegin++;
		}

		return res;
	}
}
