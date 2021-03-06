package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class WaterContainer {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] heights = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int res = maxArea(heights);
		System.out.println(res);

	}

	public static int maxArea(int[] heights) {

		int maxArea = 0;
		int left = 0;
		int right = heights.length - 1;

		int minHeight = 0;

		while (left < right) {
			// because the length is always decreasing
			// we only need to consider a pair if its height
			// is greater than any pair's height we've used so far
			if (heights[left] > minHeight && heights[right] > minHeight) {
				minHeight = Math.min(heights[left], heights[right]);
				maxArea = Math.max(maxArea, minHeight * (right - left));
			}

			// move pointers
			if (heights[left] == heights[right]) {
				left++;
				right--;
			} else if (heights[left] < heights[right]) {
				left++;
			} else {
				right--;
			}
		}

		return maxArea;
	}
}
