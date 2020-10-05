package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class SearchIn_rotated_sorted_array {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		int res = search(nums, 1);
		System.out.println(res);

	}

	/*Find the pivot element-> All the elements to the left of pivot are lessar than all the
	 * elements to the right of pivot element
	 */
	
	//There is atleast one strictly increasing subarray
	public static int search(int[] nums, int target) {
		if (nums.length == 0)
			return -1;
		int start = findMinIdx(nums);// Finding minimum value's index
		if (target == nums[start])
			return start;
		int left = 0;
		int right = nums.length - 1;

		if (target >= nums[start] && target <= nums[right]) {
			left = start; // {4,5,6,7,0,1,2}
		} else {
			right = start;
		}

		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target)
				return mid;
			else if (target > nums[mid])
				left = mid + 1;
			else
				right = mid - 1;
		}
		return -1;
	}

	public static int findMinIdx(int[] nums) {
		int left = 0, right = nums.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] > nums[right])
				left = mid + 1;
			else
				right = mid;
		}
		return left;
	}
}
