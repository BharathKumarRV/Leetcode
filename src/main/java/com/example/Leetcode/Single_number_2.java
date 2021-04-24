package com.example.Leetcode;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;

public class Single_number_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 2, 2, 3, 2 };
		int res = singleNumber_2(nums);
		System.out.println(res);

	}

	public static int singleNumber_2(int[] nums) {

		int n = nums.length;
		if (n < 3)
			return nums[0];

		Arrays.sort(nums);
		if (nums[0] != nums[1])
			return nums[0];
		int i = 1;
		while (i < n) {
			if (nums[i] != nums[i - 1])
				return nums[i - 1];
			i += 3;
		}
		return nums[n - 1];
	}
}
