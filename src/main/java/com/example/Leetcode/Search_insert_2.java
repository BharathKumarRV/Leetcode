package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Search_insert_2 {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); int[] nums = { 1, 3,
	 * 5, 6 }; int res = searchInsert(nums, 5); System.out.println(res);
	 * 
	 * }
	 */

	public static int searchInsert(int[] nums, int target) {

		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high-low) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] > target)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return low;

	}
}
