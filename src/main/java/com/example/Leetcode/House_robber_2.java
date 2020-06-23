package com.example.Leetcode;

import java.util.Arrays;

public class House_robber_2 {

	public static void main(String[] args) {

		int nums[] = { 1, 2, 3, 1 };
		int res = rob(nums);
		System.out.print(res);

	}
	
	static int[] memo;
	public static int rob(int[] nums) {
	    memo = new int[nums.length + 1];
	    Arrays.fill(memo, -1);
	    return rob(nums, nums.length - 1);
	}

	private static int rob(int[] nums, int i) {
	    if (i < 0) {
	        return 0;
	    }
	    if (memo[i] >= 0) {
	        return memo[i];
	    }
	    int result = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
	    memo[i] = result;
	    return result;
	}
}
