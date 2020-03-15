package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class search_Insert {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); int[] nums =
	 * {1,3,5,6}; int res= searchInsert(nums,7); System.out.println(res);
	 * 
	 * }
	 */

	 public static int searchInsert(int[] nums, int target) {
	        
	        int low = 0, high = nums.length;
			while (low <high) {
				int mid = low + (high - low) / 2; // low<=mid, mid<high
				if (nums[mid] >= target)
					high = mid; // high always decreases (even high-low==1)
				else
					low = mid + 1; // low always increases
			}
			return low;
	        
	    }
}
