package com.example.Leetcode;

public class two_sum_target_binary {

	public static void main(String[] args) {
		int nums[] = { 1, 2, 3, 4, 4, 9, 56, 90 };
		int res[] = twoSum(nums,8);
		System.out.println(res[0] + " " + res[1]);
	}

	public static int[] twoSum(int[] numbers, int target) {
		int res[] = new int[2];
		for (int i = 0; i < numbers.length - 1; i++) {
			//start=i+1 since we are subtracting numbers[i] from target
			int start = i+1, end = numbers.length - 1, gap = target - numbers[i];
			while (start <= end) {
				int m = start + (end - start) / 2;
				if (numbers[m] == gap) {
					res[0] = i + 1;
					res[1] = m + 1;
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
