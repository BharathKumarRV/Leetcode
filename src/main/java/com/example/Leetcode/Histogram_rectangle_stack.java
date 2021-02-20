package com.example.Leetcode;

import java.util.Stack;

import org.springframework.boot.SpringApplication;

public class Histogram_rectangle_stack {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int nums[] = { 2, 1, 5, 6, 2, 3 };
		int res = largestRectangleArea(nums);
		System.out.println(res);

	}
	
	public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= len;) {
            int h = (i == len ? 0 : heights[i]);
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
                i++;
            }else {
                int curHeight = heights[stack.pop()];
                int rightBoundary = i - 1;
                int leftBoundary = stack.isEmpty() ? 0 : stack.peek() + 1;
                int width = rightBoundary - leftBoundary + 1;
                maxArea = Math.max(maxArea, (curHeight * width));
            }
        }
        return maxArea;
    }
}
