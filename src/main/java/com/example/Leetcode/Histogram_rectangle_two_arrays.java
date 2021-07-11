package com.example.Leetcode;

import java.util.Stack;

import org.springframework.boot.SpringApplication;

public class Histogram_rectangle_two_arrays {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int nums[] = { 2, 4 };
		int res = largestRectangleArea(nums);
		System.out.println(res);

	}

	public static int largestRectangleArea(int[] heights) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(heights.length - 1);

		int rb[] = new int[heights.length];

		rb[heights.length - 1] = heights.length;

		for (int i = heights.length - 2; i >= 0; i--) {
			while (st.size() > 0 && heights[i] <= heights[st.peek()]) {
				st.pop();
			}
			if (st.size() == 0) {
				rb[i] = heights.length;
			} else {
				rb[i] = st.peek();
			}

			st.push(i);
		}

		int lb[] = new int[heights.length];
		st = new Stack<Integer>();
		st.push(0);
		lb[0] = -1;

		for (int i = 1; i < heights.length; i++) {
			while (st.size() > 0 && heights[i] <= heights[st.peek()]) {
				st.pop();
			}
			if (st.size() == 0) {
				lb[i] = -1;
			} else {
				lb[i] = st.peek();
			}

			st.push(i);
		}

		int maxArea = 0;
		for (int i = 0; i < heights.length; i++) {
			maxArea = Math.max(maxArea, heights[i] * (rb[i] - lb[i] - 1));
		}

		return maxArea;

	}
}
