package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Next_Permutation {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); int num[] = {3,2,1};
	 * nextPermutation(num);
	 * 
	 * }
	 */

	public static void nextPermutation(int[] num) {
		int n = num.length;
		if (n < 2)
			return;
		int index = n - 1;
		while (index > 0) {
			if (num[index - 1] < num[index])
				break;
			index--;
		}
		if (index == 0) {
			reverseSort(num, 0, n - 1);
			return;
		} else {
			int val = num[index - 1];
			int j = n - 1;
			while (j >= index) {
				if (num[j] > val)
					break;
				j--;
			}
			swap(num, j, index - 1);
			reverseSort(num, index, n - 1);
			for (int i = 0; i < num.length; i++)
				System.out.print(num[i] + " ");
			return;
		}
	}

	public static void swap(int[] num, int i, int j) {
		int temp = 0;
		temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	public static void reverseSort(int[] num, int start, int end) {
		while (start < end) {
			swap(num, start++, end--);
		}
		return;
	}

}
