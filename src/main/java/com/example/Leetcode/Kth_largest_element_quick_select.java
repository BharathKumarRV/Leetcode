package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Kth_largest_element_quick_select {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		int res = findKthLargest(nums, 2);
		System.out.println(res);

	}

	public static int findKthLargest(int[] nums, int k) {
		return quickSelect(nums, 0, nums.length - 1, k);
	}

	// after partition only the pivot element moves into it's correct position
	private static int quickSelect(int[] nums, int lo, int hi, int k /* index we're looking for */) {
		int i = lo, j = hi, pivot = nums[hi];

		// partition numbers into either side of pivot
		while (i < j) {
			if (nums[i++] > pivot)
				swap(nums, --i, --j);
		}

		swap(nums, i, hi);

		// how many elements were greater than pivot
		if (i == k)
			return nums[i];
		else if (i > k)
			return quickSelect(nums, lo, i - 1, k);
		else
			return quickSelect(nums, i + 1, hi, k);
	}

	static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
