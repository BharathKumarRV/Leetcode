package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Minimum_rotated_sorted_array_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int nums[] = { 4, 5, 6, 0, 1, 2, 3 };
		int res = findMin(nums);
		System.out.println(res);

	}
	
	/*
	 * The Binary Search basically split the range into two different part, one is
	 * [lo, mid], the one is [mid + 1, high], therefore we change the next lo equals
	 * to mid + 1, or the high equals to mid, depending on the search. Also, it
	 * makes sure that the loop (low < high) won't be infinite.
	 */	
	
	
	public static int findMin(int[] num) {
		int low = 0, high = num.length - 1;
		
		 while (low < high) {
	            int mid = low + (high - low) / 2;
	            if (num[mid] < num[high])
	                // the mininum is in the left part
	                high = mid;
	            else if (num[mid] > num[high])
	                // the mininum is in the right part
	                low = mid + 1;
	        }

	        return num[low];
	}
}
