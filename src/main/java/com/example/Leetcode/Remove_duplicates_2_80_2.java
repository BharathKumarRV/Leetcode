package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Remove_duplicates_2_80_2 {

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

		int i = 0;
		for (int n : nums)
			if (i < 2 || n > nums[i - 2])
				nums[i++] = n;
		return i;
	}
}
