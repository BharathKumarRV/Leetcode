package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Remove_duplicates_2 {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); LeetcodeApplication
	 * la = new LeetcodeApplication(); int[] A= {1,1,2,3,4,4}; int res =
	 * la.removeDuplicates(A); System.out.println(res);
	 * 
	 * }
	 */

	public int removeDuplicates(int[] nums) {
	    int i = 0;
	    for (int n : nums)
	        if (i == 0 || n > nums[i-1]) // works only if array is sorted so replace > with !=
	            nums[i++] = n;
	    return i;
	}
}
