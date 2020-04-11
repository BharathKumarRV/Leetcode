package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class SearchIn_rotated_sorted_duplicates {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); int[] nums = { 2, 5,
	 * 6, 0, 0, 1, 2 }; boolean res = search(nums,1); System.out.println(res);
	 * 
	 * }
	 */
	public static boolean search(int[] nums, int target) {
		int n = nums.length;
		int lo = 0, hi = n - 1;

		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] == target)
				return true;

			if (nums[lo] < nums[mid] || nums[mid] > nums[hi]) {
				if (target > nums[mid] || target < nums[lo]) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			} else if (nums[mid] < nums[hi] || nums[lo] > nums[mid]) {
				if (target < nums[mid] || target > nums[hi]) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			} else {
				hi--;
			}
		}

		return false;
	}
}
