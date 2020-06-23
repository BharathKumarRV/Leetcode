package com.example.Leetcode;

public class House_robber {

	public static void main(String[] args) {

		int nums[] = { 1, 2, 3, 1 };
		int res = rob(nums);
		System.out.print(res);

	}

	public static int rob(int[] nums) {
		return rob(nums, nums.length - 1);
	}

	private static int rob(int[] nums, int i) {
		if (i < 0) {
			return 0;
		}
		return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
	}
}
