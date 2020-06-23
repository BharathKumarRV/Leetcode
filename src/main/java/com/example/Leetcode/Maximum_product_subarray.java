package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Maximum_product_subarray {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int nums[]= {2,3,-2,4};
		int res = maxProduct(nums);
		System.out.println(res);

	}

	public static int maxProduct(int[] A) {
		if (A.length == 0) {
			return 0;
		}

		int maxherepre = A[0];
		int minherepre = A[0];
		int maxsofar = A[0];
		int maxhere, minhere;

		for (int i = 1; i < A.length; i++) {
			maxhere = Math.max(Math.max(maxherepre * A[i], minherepre * A[i]), A[i]);
			minhere = Math.min(Math.min(maxherepre * A[i], minherepre * A[i]), A[i]);
			maxsofar = Math.max(maxhere, maxsofar);
			maxherepre = maxhere;
			minherepre = minhere;
		}
		return maxsofar;
	}

}
