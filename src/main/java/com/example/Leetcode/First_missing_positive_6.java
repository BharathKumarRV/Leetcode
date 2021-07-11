package com.example.Leetcode;

public class First_missing_positive_6 {

	public static void main(String[] args) {
		int arr[] = { 3, 4, 7, 1 };
		int arr_size = arr.length;
		int missing = firstMissingPositive(arr);
		System.out.println("The smallest positive missing number is " + missing);
	}

	public static int firstMissingPositive(int[] nums) {
		boolean contains_one = false;
		for (int x : nums) {
			if (x == 1) {
				contains_one = true;
				break;
			}
		}
		if (!contains_one)
			return 1;

		int n = nums.length;
		if (n == 1)
			return 2;

		for (int i = 0; i < n; ++i)
			if (nums[i] <= 0 || nums[i] > n)
				nums[i] = 1;
		// By now it is clear all the numbers lie between 1 and n
		for (int i = 0; i < n; ++i) {
			int x = Math.abs(nums[i]);
			if (nums[x - 1] > 0) // To avoid double negation
				nums[x - 1] *= -1;
		}

		for (int i = 0; i < n; ++i)
			if (nums[i] > 0)
				return i + 1;

		return n + 1;
	}
}
