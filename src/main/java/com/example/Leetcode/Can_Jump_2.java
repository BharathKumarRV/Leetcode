package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Can_Jump_2 {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); int[] nums =
	 * {3,2,1,0,4}; boolean res = canJump(nums); System.out.println(res);
	 * 
	 * }
	 */

	public static boolean canJump(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int n = nums.length;
		int furthestReachSoFar = 0;
		for (int i = 0; i < n; i++) {
			if (i > furthestReachSoFar || furthestReachSoFar >= n - 1)
				break;
			furthestReachSoFar = Math.max(furthestReachSoFar, i + nums[i]);
		}
		return furthestReachSoFar >= n - 1;
	}
}
