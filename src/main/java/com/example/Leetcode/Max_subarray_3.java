package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Max_subarray_3 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int nums[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int res = maxSubArray_2(nums);
		System.out.println(res);

	}

	public static int maxSubArray(int[] A) {
		int n = A.length;
		int max_sum = A[0];
		int current_sum = max_sum;

		for (int i = 1; i < n; i++) {
			current_sum = Math.max(A[i] + current_sum, A[i]);
			max_sum = Math.max(current_sum, max_sum);
		}

		return max_sum;
	}

	public static int maxSubArray_2(int[] A) {
		int n = A.length;
		int max_sum = A[0];
		int current_sum = 0;

		for (int i = 0; i < n; i++) {
			current_sum += A[i];
			max_sum = Math.max(current_sum, max_sum);
			if (current_sum < 0) {
				current_sum = 0;
			}
		}

		return max_sum;
	}
}
