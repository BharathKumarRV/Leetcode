package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class SearchIn_rotated_sorted_array_duplicates {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		boolean res = search(nums, 5);
		System.out.println(res);

	}

	/*
	 * The only difference is that due to the existence of duplicates, we can have
	 * nums[left] == nums[mid] and in that case, the first half could be out of
	 * order (i.e. NOT in the ascending order, e.g. [3 1 2 3 3 3 3]) and we have to
	 * deal this case separately. In that case, it is guaranteed that nums[right]
	 * also equals to nums[mid], so what we can do is to check if nums[mid]==
	 * nums[left] == nums[right] before the original logic, and if so, we can move
	 * left and right both towards the middle by 1. and repeat.
	 */
	public static boolean search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		int mid = 0;

		while (left <= right) {
			mid = left + (right - left) / 2;
			if (nums[mid] == target)
				return true;

			// the only difference from the first one, trickly case, just updat left and
			// right
			if ((nums[left] == nums[mid]) && (nums[right] == nums[mid])) {
				++left;
				--right;
			}

			else if (nums[left] <= nums[mid]) {
				if ((nums[left] <= target) && (nums[mid] > target))
					right = mid - 1;
				else
					left = mid + 1;
			} else {
				if ((nums[mid] < target) && (nums[right] >= target))
					left = mid + 1;
				else
					right = mid - 1;
			}
		}
		return false;
	}

	public static boolean search2(int[] nums, int target) {
		int n = nums.length;
		int left = 0;
		int right = n - 1;
		int mid;

		/*
		 * logic:Find which side of the array is strictly increasing and then find if
		 * target element exists in that side
		 */
		// Iterative binary search
		while (left <= right) {
			mid = (left + right) / 2;
			// cout<<nums[mid]<<"\n";
			if (nums[mid] == target)
				return true;
			else if (nums[mid] >= nums[left]) {
				if (target <= nums[mid] || target >= nums[left])
					right = mid - 1;
				else
					left = mid + 1;
			} else {
				if (target >= nums[mid] || target <= nums[right])
					left = mid + 1;
				else
					right = mid - 1;
			}
		}
		return false;
	}
}
