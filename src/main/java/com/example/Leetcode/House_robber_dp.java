package com.example.Leetcode;

public class House_robber_dp {

	public static void main(String[] args) {

		int nums[] = { 2, 7, 9, 12, 1 };
		int res = rob_2(nums);
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

	public static int rob_2(int[] nums) {
		int two_prev = 0, one_prev = 0, max_amount = 0;

		for (int num : nums) {
			max_amount = Math.max(two_prev + num, one_prev);
			two_prev = one_prev;
			one_prev = max_amount;
		}

		return max_amount;
	}
	
	 public int rob_3(int[] nums) {
	       if (nums.length == 0)
				return 0;
	       if (nums.length == 1)
				return nums[0];
			int[] memo = new int[nums.length];
			memo[0] = nums[0];
			memo[1] = Math.max(nums[0],nums[1]);
			for (int i = 2; i < nums.length; i++) {
				memo[i]=Math.max(nums[i]+memo[i-2],memo[i-1]);
			}
			return memo[nums.length-1];
	    }

}
