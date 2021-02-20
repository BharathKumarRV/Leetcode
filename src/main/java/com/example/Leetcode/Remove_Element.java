package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Remove_Element {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] A = { 3, 2, 2, 3 };
		int res = removeElement_2(A, 2);
		System.out.println(res);

	}

	public static int removeElement(int[] nums, int val) {
		int begin = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++)
			if (nums[i] != val)
				nums[begin++] = nums[i];
		return begin;
	}

	
	
	public static int removeElement_2(int[] nums, int val) {
		int begin = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++)
			if (nums[i] == val)
				begin++;
		return nums.length-begin;
	}

}
