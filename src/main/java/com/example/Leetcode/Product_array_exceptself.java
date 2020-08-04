package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Product_array_exceptself {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 1, 2, 3, 4 };
		int[] res;
		res = productExceptSelf(nums);
		for(int i=0;i<res.length;i++) {
		System.out.print(res[i]+" ");
		}

	}

	public static int[] productExceptSelf(int[] nums) {

		int len = nums.length;
		int[] output = new int[len];

		int leftMult = 1, rightMult = 1;

		for (int i = len - 1; i >= 0; i--) {
			output[i] = rightMult;
			rightMult *= nums[i];
		}
		for (int j = 0; j < len; j++) {
			output[j] *= leftMult;
			leftMult *= nums[j];

		}

		return output;

	}
}
