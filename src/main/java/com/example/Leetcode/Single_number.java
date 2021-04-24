package com.example.Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;

public class Single_number {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 4, 1, 2, 1, 2 };
		int res = singleNumber_4(nums, nums.length);
		System.out.println(res);

	}

	public static int singleNumber(int[] A) {

		Set<Integer> s = new HashSet<Integer>();
		for (int i : A) {
			if (!s.add(i)) {
				s.remove(i);
			}
		}
		return s.iterator().next();

	}

	public static int singleNumber_2(int A[], int n) {
		int result = 0;
		for (int i = 0; i < n; i++) {
			result ^= A[i];
		}
		return result;
	}
	
	public static int singleNumber_3(int A[], int n) {
		int result = 0;
		for (int i = 0; i < n; i=i+2) {
			if(A[i]!=A[i+1]) {
				return A[i];
			}
		}
		return result;
	}
	
	public static int singleNumber_4(int[] nums, int n) {

		if (n < 2)
			return nums[0];

		Arrays.sort(nums);
		if (nums[0] != nums[1])
			return nums[0];
		int i = 1;
		while (i < n) {
			if (nums[i] != nums[i - 1])
				return nums[i - 1];
			i += 2;
		}
		return nums[n - 1];
	}
}
