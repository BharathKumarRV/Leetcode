package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Rain_Trapping_bruteforce {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int res;
		res = trap(nums);
		System.out.println(res);

	}

	public static int trap(int[] height) {
		int res = 0;
		for (int i = 0; i < height.length; i++) {
			int leftMax = 0, rightMax = 0;
			for (int k = i; k >= 0; k--) {
				leftMax = Math.max(leftMax, height[k]);
			}
			for (int j = i; j < height.length; j++) {
				rightMax = Math.max(rightMax, height[j]);
			}
			res += Math.min(leftMax, rightMax) - height[i];
		}
		return res;
	}

}
