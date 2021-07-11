package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Sort_colors_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int A[] = { 2, 0, 2, 1, 1, 0 };
		sortColors(A);
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i]);
		}

	}

	public static void sortColors(int[] A) {
		int n0 = -1, n1 = -1, n2 = -1;
		int n = A.length;
		for (int i = 0; i < n; ++i) {
			if (A[i] == 0) {
				A[++n2] = 2;
				A[++n1] = 1;
				A[++n0] = 0;
			} else if (A[i] == 1) {
				A[++n2] = 2;
				A[++n1] = 1;
			} else if (A[i] == 2) {
				A[++n2] = 2;
			}
		}
	}

	//Dutch-national flag algo
	//All the elements to the left of low are 0
	//All the elements to the right of high are 2
	public static void sortColors2(int[] nums) {
		int low = 0, mid = 0;
		int high = nums.length - 1;
		int temp;

		while (mid <= high) {
			switch (nums[mid]) {
			case 0: {
				temp = nums[low];
				nums[low] = nums[mid];
				nums[mid] = temp;
				low++;
				mid++;
				break;
			}

			case 1:
				mid++;
				break;
			case 2: {
				temp = nums[high];
				nums[high] = nums[mid];
				nums[mid] = temp;
				high--;
				break;
			}

			}
		}
	}

}
