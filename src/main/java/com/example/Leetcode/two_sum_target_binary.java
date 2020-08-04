package com.example.Leetcode;

import java.util.Arrays;

public class two_sum_target_binary {

	public static void main(String[] args) {
		int nums[] = { 0, 4, 3, 0 };
		int res[] = twoSum(nums, 0);
		System.out.println(res[0] + " " + res[1]);
	}

	//works only for sorted arrays
	public static int[] twoSum(int[] numbers, int target) {
		int res[] = new int[2];
		Arrays.sort(numbers);
		for (int i = 0; i < numbers.length - 1; i++) {
			// start=i+1 since we are subtracting numbers[i] from target
			//keeping i as element to search every time in the loop
			//starting start from i+1
			int start = i + 1, end = numbers.length - 1, gap = target - numbers[i];
			while (start <= end) {
				int m = start + (end - start) / 2;
				if (numbers[m] == gap) {
					res[0] = i;
					res[1] = m;
					return res;
				} else if (numbers[m] > gap)
					end = m - 1;
				else
					start = m + 1;
			}
		}
		return res;
	}
}
