package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class SearchIn_rotated_sorted_array_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		int res = search(nums, 1);
		System.out.println(res);

	}

	// https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/14435/Clever-idea-making-it-simple
	public static int search(int[] nums, int target) {
		int lo = 0, hi = nums.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;

			int num = nums[mid];
			// If nums[mid] and target are "on the same side" of nums[0], we just take
			// nums[mid].
			if ((nums[mid] < nums[0]) == (target < nums[0])) {
				num = nums[mid];
			} else {
				num = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}

			if (num < target)
				lo = mid + 1;
			else if (num > target)
				hi = mid - 1;
			else
				return mid;
		}
		return -1;
	}

}
