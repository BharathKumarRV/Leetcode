package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Water_Container_3 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] heights = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int res = maxArea(heights);
		System.out.println(res);

	}

	public static int maxArea(int[] height) {
		int max = 0;
		for (int i = 0; i < height.length - 1; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int smallest = height[i] < height[j] ? height[i] : height[j];
				int area = smallest * (j - i);

				max = Math.max(area, max);
				// System.out.println("i = "+ height[i] + " j = " + height[j]+ " smallest " +
				// smallest+ " max = " +max);
			}
		}
		return max;
	}

}
