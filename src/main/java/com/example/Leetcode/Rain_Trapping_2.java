package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Rain_Trapping_2 {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); int[] nums =
	 * {0,1,0,2,1,0,1,3,2,1,2,1}; int res; res = trap(nums);
	 * System.out.println(res);
	 * 
	 * }
	 */

	public static int trap(int[] A) {

		int a = 0;
		int b = A.length - 1;
		int max = 0;
		int leftmax = 0;
		int rightmax = 0;
		while (a < b) {
			leftmax = Math.max(leftmax, A[a]);
			rightmax = Math.max(rightmax, A[b]);
			if (leftmax < rightmax) {
				max += (leftmax - A[a]); // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
				a++;
			} else {
				max += (rightmax - A[b]);
				b--;
			}
		}
		return max;

	}
}
