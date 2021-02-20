package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Search_insert_3 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 1, 3, 5, 6 };
		int res = searchInsert(nums, 7);
		System.out.println(res);

	}

	public static int searchInsert(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (target <= nums[i])
				return i;
		}
		return nums.length;
	}
}
