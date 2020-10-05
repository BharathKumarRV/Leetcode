package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class First_last_position_in_array_3 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int res[] = new int[2];
		res[0] = findStartingIndex(nums, 8);
		res[1] = findEndingIndex(nums, 8);
		System.out.println(res[0] + " " + res[1]);

	}

	public static int findStartingIndex(int[] nums, int target) {
		int index = -1;
		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {
			int midpoint = start + (end - start) / 2;
			// { 5, 7, 7, 8, 8, 10 }
			/*
			 * We need to find the leftmost element here So in this if condition we are
			 * saying if midpoint is greater or equal to equal to because even if we find
			 * the value, we want to find the left most value
			 */

			if (nums[midpoint] == target) {
				index = midpoint;
				end = midpoint - 1;
			} else if (nums[midpoint] > target) {
				end = midpoint - 1;
			} else {
				start = midpoint + 1;
			}

		}

		return index;

	}

	public static int findEndingIndex(int[] nums, int target) {
		int index = -1;
		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {
			int midpoint = start + (end - start) / 2;
			// { 5, 7, 7, 8, 8, 10 }
			/*
			 * We need to find the rightmost element here So in this if condition we are
			 * saying if midpoint is lesser or equal to, equal to because even if we find
			 * the value, we want to find the right most value
			 */
			if (nums[midpoint] == target) {
				index = midpoint;
				start = midpoint + 1;
			} else if (nums[midpoint] > target) {
				end = midpoint - 1;
			} else {
				start = midpoint + 1;
			}
		}

		return index;
	}
}
