package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Maximum_product_subarray_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int nums[] = { 2, 3, -2, 4 , -3 , -1, 3};
		int res = maxProduct(nums);
		System.out.println(res);

	}

	//https://leetcode.com/problems/maximum-product-subarray/discuss/48230/Possibly-simplest-solution-with-O(n)-time-complexity/337552
	//Forms the max product for 2, 3, -2, 4 , -3  till -3 (even number of -ve)
	public static int maxProduct(int[] nums) {

		int prod = 1;
		int result = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			prod = prod * nums[i];
			result = Math.max(prod, result);
			if (prod == 0) {
				prod = 1; // start the prod afresh since element is 0
			}
		}
		prod = 1;
		//Forms the max product for 4 , -3 , -1, 3 till 4 (even number of -ve)
		for (int i = nums.length - 1; i >= 0; i--) {

			prod = prod * nums[i];
			result = Math.max(prod, result);// comparing pre result with this prod
			if (prod == 0) {
				prod = 1;
			}
		}
		return result;
	}
}
