package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class SearchIn_rotated_sorted_array_recursive {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 1, 3, 1, 1, 1 };
		int res = search(nums, 3);
		System.out.println(res);

	}

	public static int search(int[] nums, int target) {
		return binarySearch(0, nums.length - 1, nums, target);
	}

	public static int binarySearch(int low, int high, int[] nums, int target) {
		int mid = (low + high) / 2;
		if (nums[mid] == target)
			return mid;
		if (low > high)
			return -1;

		if (nums[mid] >= nums[low]) {// array between nums[low] and nums[mid] are sorted
			if (nums[low] <= target && target < nums[mid])// target is between nums[low] and nums[mid]
				return binarySearch(low, mid - 1, nums, target);
			else
				return binarySearch(mid + 1, high, nums, target);
		} else {// unsorted part of array
			if (nums[mid] < target && target <= nums[high])
				return binarySearch(mid + 1, high, nums, target);
			else
				return binarySearch(low, mid - 1, nums, target);
		}
	}
}
