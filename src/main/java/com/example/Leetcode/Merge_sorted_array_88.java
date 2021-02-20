package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Merge_sorted_array_88 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = { 4, 5, 6 };
		merge(nums1, 3, nums2, 3);
		for (int i = 0; i < nums1.length; i++) {
			System.out.print(nums1[i] + " ");
		}

	}

	public static void merge(int[] A, int m, int[] B, int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		while (i >= 0 && j >= 0) {
			if (A[i] > B[j])
				A[k--] = A[i--];
			else
				A[k--] = B[j--];
		}
		/*
		 * If A[m - 1] > B[n - 1] (last actual number in A larger than last number in
		 * B), then all of the numbers in A will be moved to the end and fill out the
		 * zeroes. The second loop then replaces the initial numbers of A since we know
		 * the numbers in B are smaller than A.
		 */
		while (j >= 0)
			A[k--] = B[j--];
	}
}
