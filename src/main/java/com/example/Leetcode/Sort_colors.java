package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Sort_colors {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int A[] = { 2, 0, 2, 1, 1, 0 };
		sortColors(A);
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i]);
		}

	}

	public static void sortColors(int[] A) {
		if (A == null || A.length < 2)
			return;
		int low = 0;
		int high = A.length - 1;
		int i = 0;
		while (i <= high) {
			if (A[i] == 0) {
				// swap A[i] and A[low] and i,low both ++
				int temp = A[i];
				A[i] = A[low];
				A[low] = temp;
				i++;
				low++;
			} else if (A[i] == 2) {
				// swap A[i] and A[high] and high--;
				int temp = A[i];
				A[i] = A[high];
				A[high] = temp;
				high--;
			} else {
				i++;
			}
		}
	}

	public static void sortColors2(int[] nums) {

		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			if (nums[left] > nums[right]) {
				int temp = nums[right];
				nums[right] = nums[left];
				nums[left] = temp;
				left++;
				right--;
			} else {
				left++;
			}
		}

	}

}
