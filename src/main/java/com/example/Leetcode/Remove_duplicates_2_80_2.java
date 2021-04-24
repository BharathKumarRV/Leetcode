package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Remove_duplicates_2_80_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int nums[] = { 1, 1, 1, 2, 2, 3 };
		int res = removeDuplicates(nums);
		System.out.println(res);

	}

	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int i = 0;
		for (int n : nums)
			if (i < 2 || n > nums[i - 2])
				nums[i++] = n;
		return i;
	}

	public static int removeDuplicates_2(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i < 2 || nums[i] > nums[i - 2]) {
				nums[count++] = nums[i];
			}
		}
		return count;
	}

}
