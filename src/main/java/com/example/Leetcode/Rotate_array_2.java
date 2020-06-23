package com.example.Leetcode;

public class Rotate_array_2 {

	public static void main(String[] args) {

		int nums[] = { 1, 2, 3, 4, 5, 6, 7 };
		rotate(nums, 3);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}

	}
	
	/*
	 * The extra-space approach violates the requirement of the problem. The idea is
	 * simple. Find the start index after shifting and traverse the whole array
	 * starting from this index. Every time we visit an element, we put it into a
	 * new array.
	 */
	/*
	 * public static void rotate(int[] nums, int k) { int n = nums.length; k = k %
	 * n; int startIdx = n - k; int[] result = new int[nums.length]; for (int i = 0;
	 * i < n; ++i) { result[i] = nums[(startIdx + i) % n]; }
	 * System.arraycopy(result, 0, nums, 0, n); }
	 */
	
	
	public static void rotate(int[] nums, int k) {
		  int n = nums.length;
		  k = k % n;
		  for (int i = 0; i < k; ++i) { // rotate by k times
		    // each time rotate all elements by one step, starting from the rihgtmost element
		    int prev = nums[n - 1];
		    for (int j = 0; j < n; ++j) {
		      int temp = nums[j]; // backup
		      nums[j] = prev;
		      prev = temp;
		    }
		  }
		}
}
