package com.example.Leetcode;

public class House_robber_dp {

	public static void main(String[] args) {

		int nums[] = { 1, 2, 3, 1 };
		int res = rob(nums);
		System.out.print(res);

	}

	public static int rob(int[] nums) {
		if (nums.length == 0)
			return 0;
		int[] memo = new int[nums.length + 1];
		memo[0] = 0;
		memo[1] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int val = nums[i];
			memo[i + 1] = Math.max(memo[i], memo[i - 1] + val);
		}
		return memo[nums.length];
	}
}
