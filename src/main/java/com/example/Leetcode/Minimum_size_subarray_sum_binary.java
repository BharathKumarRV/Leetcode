package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Minimum_size_subarray_sum_binary {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		int res = minSubArrayLen(7, nums);
		System.out.println(res);

	}

	public static int minSubArrayLen(int s, int[] nums) {
		return solveNLogN(s, nums);
	}

	private static int solveNLogN(int s, int[] nums) {
		int[] sums = new int[nums.length + 1];
		for (int i = 1; i < sums.length; i++)
			sums[i] = sums[i - 1] + nums[i - 1];
		int minLen = Integer.MAX_VALUE;
		for (int i = 0; i < sums.length; i++) {
			int end = binarySearch(i + 1, sums.length - 1, sums[i] + s, sums);
			if (end == sums.length)
				break;
			if (end - i < minLen)
				minLen = end - i;
		}
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}

	private static int binarySearch(int lo, int hi, int key, int[] sums) {
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (sums[mid] >= key) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return lo;
	}
}
