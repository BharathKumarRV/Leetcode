package com.example.Leetcode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class Spiral_matrix_2 {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); int R = 3; int C = 6;
	 * int a[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15,
	 * 16, 17, 18 } }; List<Integer> res=spiralOrder(a); System.out.println(res);
	 * 
	 * }
	 */

	 public static List<Integer> spiralOrder(int[][] matrix) {
	        
	        List<Integer> res = new ArrayList<Integer>();
	        
	        if (matrix.length == 0) {
	            return res;
	        }
	        
	        int rowBegin = 0;
	        int rowEnd = matrix.length-1;
	        int colBegin = 0;
	        int colEnd = matrix[0].length - 1;
	        
	        while (rowBegin <= rowEnd && colBegin <= colEnd) {
	            // Traverse Right
	            for (int j = colBegin; j <= colEnd; j ++) {
	                res.add(matrix[rowBegin][j]);
	            }
	            rowBegin++;
	            
	            // Traverse Down
	            for (int j = rowBegin; j <= rowEnd; j ++) {
	                res.add(matrix[j][colEnd]);
	            }
	            colEnd--;
	            
	            if (rowBegin <= rowEnd) {
	                // Traverse Left
	                for (int j = colEnd; j >= colBegin; j --) {
	                    res.add(matrix[rowEnd][j]);
	                }
	            }
	            rowEnd--;
	            
	            if (colBegin <= colEnd) {
	                // Traver Up
	                for (int j = rowEnd; j >= rowBegin; j --) {
	                    res.add(matrix[j][colBegin]);
	                }
	            }
	            colBegin ++;
	        }
	        
	        return res;
	    }
}
