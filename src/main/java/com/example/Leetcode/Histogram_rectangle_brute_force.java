package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Histogram_rectangle_brute_force {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int nums[] = { 2, 1, 5, 6, 2, 3 };
		int res = largestRectangleArea(nums);
		System.out.println(res);

	}

	public static int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0)
			return 0;

		int maxArea = 0;
		for (int i = 0; i < heights.length; i++) {
			int height = heights[i];
			int leftSmallerIndex = findLeftSmallerIndex(heights, i);
			int rightSmallerIndex = findRightSmallerIndex(heights, i);
			int area = (rightSmallerIndex - leftSmallerIndex - 1) * height;
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}

	/**
	 * Returns index of the first smaller item to the left or -1 if such an item is
	 * not found.
	 */
	private static int findLeftSmallerIndex(int[] heights, int i) {
		int height = heights[i];
		while (i >= 0 && heights[i] >= height) {
			i--;
		}
		return i;
	}

	/**
	 * Returns index of the first smaller item to the right or (last index + 1) if
	 * such an item is not found.
	 */
	private static int findRightSmallerIndex(int[] heights, int i) {
		int height = heights[i];
		while (i < heights.length && heights[i] >= height) {
			i++;
		}
		return i;
	}

}
