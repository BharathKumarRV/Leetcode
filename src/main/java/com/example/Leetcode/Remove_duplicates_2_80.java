package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Remove_duplicates_2_80 {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); int nums[] = { 0, 0,
	 * 1, 1, 1, 1, 2, 3, 3 }; int res = removeDuplicates(nums);
	 * System.out.println(res);
	 * 
	 * }
	 */

	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int left = 2;
		for (int right = 2; right < nums.length; right++) {
			if (nums[left - 2] != nums[right]) {
				nums[left++] = nums[right];
			}
		}
		return left;
	}
}
