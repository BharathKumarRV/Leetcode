package com.example.Leetcode;

import java.util.Stack;

import org.springframework.boot.SpringApplication;

public class Max_rectangle_area_histogram {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); int[] heights =
	 * {2,1,5,6,2,3}; int res = largestRectangleArea(heights);
	 * System.out.println(res);
	 * 
	 * }
	 */

	public static int largestRectangleArea(int heights[]) {
	      if (heights == null || heights.length == 0) {
	            return 0;
	        }
	        
	        int maxArea = 0;
	        Stack<Integer> stack = new Stack<>();
	        stack.push(-1);
	        
	        for (int i = 0; i < heights.length; i++) {
	            int currentBarHeight = heights[i];
	            
	            while (stack.peek() != -1 && currentBarHeight <= heights[stack.peek()]) {
	                int height = heights[stack.pop()];
	                int width = i - stack.peek() - 1; //-1 because we are dealing with array
	                
	                int area = height * width;
	                maxArea = Math.max(area, maxArea);
	            }          
	            
	            stack.push(i);
	        }
	        
	        while (stack.peek() != -1) {
	            int height = heights[stack.pop()];
	            int width = heights.length - stack.peek() - 1;
	            
	            int area = height * width;
	            maxArea = Math.max(area, maxArea);
	        }
	        
	        return maxArea;
	        
	        // Time complexity : O(n). n numbers are pushed and popped.
	        // Space complexity : O(n). Stack is used.
	    }
}
