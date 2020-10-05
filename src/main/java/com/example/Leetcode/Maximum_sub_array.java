package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Maximum_sub_array {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int nums[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int res = maxSubArray(nums);
		System.out.println(res);

	}

	public static int maxSubArray(int[] A) {
		int n = A.length;
		int[] dp = new int[n];// dp[i] means the maximum subarray ending with A[i];
		dp[0] = A[0];
		int max = dp[0];

		for (int i = 1; i < n; i++) {
			dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
			max = Math.max(max, dp[i]);
		}

		return max;
	}
}
