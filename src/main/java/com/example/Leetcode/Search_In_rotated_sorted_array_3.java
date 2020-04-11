package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Search_In_rotated_sorted_array_3 {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); int[] nums = { 6, 7,
	 * 0, 1, 2, 4, 6 }; int res = search(nums, 4); System.out.println(res);
	 * 
	 * }
	 */

	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		int lo = 0, hi = nums.length - 1;
		while (lo <= hi) { // take care of this =
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			//Find out which side of the array is sorted
			// If left side of the array is sorted
			if (nums[lo] <= nums[mid]) {
				// If target lies beyond this interval move right side
				if (nums[mid] < target || nums[lo] > target) {
					lo = mid + 1;
				}
				// move left side
				else {
					hi = mid - 1;
				}
			}
			// If right side of the array is sorted
			else {
				if (target < nums[mid] || target > nums[hi]) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			}
		}

		return -1;
	}
}
