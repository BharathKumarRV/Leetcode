package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Search_In_rotated_sorted_array_3 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };

		int res = search(nums, 0);
		System.out.println(res);

	}

	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		int lo = 0, hi = nums.length - 1;
		while (lo <= hi) { // take care of this =
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			// Find out which side of the array is sorted
			// If left side of the array is sorted
			if (nums[lo] <= nums[mid]) {
				// If target lies in this interval move left side
				if (target <= nums[mid] && target >= nums[lo]) {
					hi = mid - 1;
				}
				// move left side
				else {
					lo = mid + 1;
				}
			}
			// If right side of the array is sorted
			else {
				if (target >= nums[mid] && target <= nums[hi]) {
					lo = mid + 1;

				} else {
					hi = mid - 1;
				}
			}
		}

		return -1;
	}
}
