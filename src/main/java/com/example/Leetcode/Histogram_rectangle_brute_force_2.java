package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Histogram_rectangle_brute_force_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int nums[] = { 2, 1, 5, 6, 2, 3 };
		int res = largestRectangleArea(nums);
		System.out.println(res);

	}

	public static int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0)
			return 0;

		int[] leftSmallerIndices = new int[heights.length];
		for (int i = 0; i < heights.length; i++) {
			int height = heights[i];
			int j = i - 1;
			while (j >= 0 && heights[j] >= height) {
				j--;
			}
			leftSmallerIndices[i] = j;
		}
		int[] rightSmallerIndices = new int[heights.length];
		for (int i = 0; i < heights.length; i++) {
			int height = heights[i];
			int j = i + 1;
			while (j < heights.length && heights[j] >= height) {
				j++;
			}
			rightSmallerIndices[i] = j;
		}

		int maxArea = 0;
		for (int i = 0; i < heights.length; i++) {
			int height = heights[i];
			int leftSmallerIndex = leftSmallerIndices[i];
			int rightSmallerIndex = rightSmallerIndices[i];
			int area = (rightSmallerIndex - leftSmallerIndex - 1) * height;
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}

}
