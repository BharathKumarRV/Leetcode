package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Set_zeroes_matrix {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); int[][] matrix=
	 * {{1,0,1},{1,1,1},{1,1,1}}; setZeroes(matrix); for(int
	 * i=0;i<matrix.length;i++) { for(int j=0;j<matrix[0].length;j++) {
	 * System.out.print(matrix[i][j]+" "); } System.out.println(); }
	 * 
	 * }
	 */

	 public static void setZeroes(int[][] matrix) {
	        if(matrix == null || matrix.length == 0 || matrix[0].length==0) return;
	        boolean firstRowToSet = false, firstColToSet = false;
	        int row = matrix.length, col = matrix[0].length;
	        for(int i = 0;i<row;i++){
	            if(matrix[i][0] == 0) {
	                firstColToSet = true;
	                break;
	            }
	        }
	        for(int j = 0;j<col;j++){
	            if(matrix[0][j] == 0){
	                firstRowToSet = true;
	                break;
	            }
	        }
	        
	   //     1 0 1  	1 0 1
	   //     1 1 1		1 0 1
	   //     1 1 1		1 0 1
	        for(int i = 1;i < row;i++){
	            for(int j =1;j<col;j++){
	                if(matrix[i][j] == 0){
	                    matrix[i][0] = 0;
	                    matrix[0][j] = 0; 
	                }
	            }
	        }
	        for(int i = 1;i<row;i++){
	            for(int j = 1;j<col;j++){
	                if(matrix[i][0] ==0 || matrix[0][j] == 0) matrix[i][j] = 0;
	            }
	        }
	        if(firstColToSet){
	            for(int i = 0;i<row;i++) matrix[i][0] = 0;
	        }
	        if(firstRowToSet){
	            for(int j = 0; j< col;j++) matrix[0][j] = 0;
	        }
	    }
}
