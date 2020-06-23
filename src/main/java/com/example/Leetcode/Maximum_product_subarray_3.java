package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Maximum_product_subarray_3 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int nums[] = { 2, 3, -2, 4 };
		int res = maxProduct(nums);
		System.out.println(res);

	}

	public static int maxProduct(int[] nums) {
		int max = Integer.MIN_VALUE, imax = 1, imin = 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				int tmp = imax;
				imax = imin;
				imin = tmp;
			}
			imax = Math.max(imax * nums[i], nums[i]);
			imin = Math.min(imin * nums[i], nums[i]);

			max = Math.max(max, imax);
		}
		return max;
	}
}
