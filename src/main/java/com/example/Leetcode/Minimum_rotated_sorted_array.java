package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Minimum_rotated_sorted_array {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int nums[] = { 4, 5, 6, 0, 1, 2, 3 };
		int res = findMin(nums);
		System.out.println(res);

	}

	// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/discuss/48484/A-concise-solution-with-proof-in-the-comment/48551

	public static int findMin(int[] nums) {
		if (nums.length == 0)
			return -1;
		if (nums.length == 1)
			return nums[0];

		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (mid > 0 && nums[mid] < nums[mid - 1]) {
				return nums[mid];
			} else if (nums[left] <= nums[mid] && nums[mid] > nums[right]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return nums[left];
	}
}
