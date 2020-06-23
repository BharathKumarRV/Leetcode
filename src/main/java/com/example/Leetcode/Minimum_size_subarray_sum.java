package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Minimum_size_subarray_sum {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		int res = minSubArrayLen(7, nums);
		System.out.println(res);

	}

	public static int minSubArrayLen(int s, int[] nums) {
		int sum = 0, left = 0, result = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while (sum >= s) {
				result = Math.min(result, i - left + 1);
				sum -= nums[left++];
			}
		}
		return (result == Integer.MAX_VALUE) ? 0 : result;
	}

}
