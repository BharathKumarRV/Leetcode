package com.example.Leetcode;

public class Water_Container_2 {

	public int maxArea(int[] heights) {

		int maxArea = 0;
		int left = 0;
		int right = heights.length - 1;

		int minHeight = 0;

		while (left < right) {
			minHeight = Math.min(heights[left], heights[right]);
			maxArea = Math.max(maxArea, minHeight * (right - left));
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
