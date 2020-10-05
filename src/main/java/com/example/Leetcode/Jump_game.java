package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Jump_game {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 3, 2, 1, 0, 4 };
		boolean res = canJump2(nums);
		System.out.println(res);

	}

	public static boolean canJump(int[] nums) {
		int lastGoodIndexPosition = nums.length - 1;

		for (int i = nums.length - 1; i >= 0; i--) {
			if (i + nums[i] >= lastGoodIndexPosition) {
				lastGoodIndexPosition = i;
			}
		}

		return lastGoodIndexPosition == 0;
	}

	public static boolean canJump2(int[] nums) {
		int n = nums.length;
		int reachable = 0;
		for (int i = 0; i < n; i++) {
			if (reachable < i) {
				return false;
			}
			reachable = Math.max(reachable, i + nums[i]);
		}

		return true;
	}
}
