package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Rotate_Image_2 {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); int[][] matrix = { {
	 * 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }; int rows = matrix.length; int columns
	 * = matrix[0].length; rotate(matrix); for (int i = 0; i < rows; i++) { for (int
	 * j = 0; j < columns; j++) { System.out.print(matrix[i][j]+" "); }
	 * System.out.println(); }
	 * 
	 * }
	 */

	public static void rotate(int[][] matrix) {
		//Swap first and last row
	    int s = 0, e = matrix.length - 1;
	    while(s < e){
	        int[] temp = matrix[s];
	        matrix[s] = matrix[e];
	        matrix[e] = temp;
	        s++; e--;
	    }

	    //swap the symmetry
	    for(int i = 0; i < matrix.length; i++){
	        for(int j = i; j < matrix[i].length; j++){
	            int temp = matrix[i][j];
	            matrix[i][j] = matrix[j][i];
	            matrix[j][i] = temp;
	        }
	    }
	}
}
