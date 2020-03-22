package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Max_subarray_2 {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); int nums[]=
	 * {-2,1,-3,4,-1,2,1,-5,4}; int res = maxSubArray(nums);
	 * System.out.println(res);
	 * 
	 * }
	 */

	public static int maxSubArray(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        int max = dp[0];
        int compare=0;
        
        for(int i = 1; i < n; i++){
           compare=dp[i-1]+A[i];
           dp[i]=Math.max(A[i],compare);
           max=Math.max(max,dp[i]);
        }
        
        return max;
}
}
