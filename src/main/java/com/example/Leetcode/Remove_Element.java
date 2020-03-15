package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Remove_Element {
	
	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); LeetcodeApplication
	 * la = new LeetcodeApplication(); int[] A = {3,2,2,3}; int res =
	 * la.removeElement(A,2); System.out.println(res);
	 * 
	 * }
	 */

	public int removeElement(int[] nums, int val) {
		int begin = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++)
			if (nums[i] != val)
				nums[begin++] = nums[i];
		return begin;
	}

}
