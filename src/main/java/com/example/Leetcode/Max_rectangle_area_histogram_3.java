package com.example.Leetcode;

import java.util.Stack;

import org.springframework.boot.SpringApplication;

public class Max_rectangle_area_histogram_3 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] heights = { 2, 1, 5, 6, 2, 3 };
		int res = largestRectangleArea(heights);
		System.out.println(res);

	}

	public static int largestRectangleArea(int heights[]) {
		int n = heights.length;
		int left[] = new int[n];
		int right[] = new int[n];

		Stack<Integer> mystack=new Stack();
		for (int i = 0; i < n; ++i) // Fill left
		{
			if (mystack.empty()) {
				left[i] = 0;
				mystack.push(i);
			} else {
				while (!mystack.empty() && heights[mystack.peek()] >= heights[i])
					mystack.pop();
				left[i] = mystack.empty() ? 0 : mystack.peek() + 1;
				mystack.push(i);
			}
		}
		while (!mystack.empty()) // Clear stack
			mystack.pop();

		for (int i = n - 1; i >= 0; --i) // Fill right
		{
			if (mystack.empty()) {
				right[i] = n - 1;
				mystack.push(i);
			} else {
				while (!mystack.empty() && heights[mystack.peek()] >= heights[i])
					mystack.pop();
				right[i] = mystack.empty() ? n - 1 : mystack.peek() - 1;
				mystack.push(i);
			}
		}
		int mx_area = 0; // Stores max_area
		for (int i = 0; i < n; ++i)
			mx_area = Math.max(mx_area, heights[i] * (right[i] - left[i] + 1));
		return mx_area;
	}
}
