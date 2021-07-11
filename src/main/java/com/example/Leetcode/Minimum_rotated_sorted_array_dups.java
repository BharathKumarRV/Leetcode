package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Minimum_rotated_sorted_array_dups {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int nums[] = {1, 0, 1, 1, 1};
		int res = findMin(nums);
		System.out.println(res);

	}

	public static int findMin(int[] nums) {
		int low = 0, high = nums.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] < nums[high])
				high = mid;
			else if (nums[mid] > nums[high])
				low = mid + 1;
			else // nums[mid] == nums[high])
			if (high != 0 && nums[high] >= nums[high - 1])
				high--;
			else
				if (nums[high - 1] > nums[high]) {
				    low = high;
				    break;
				}
				high--;
		}
		 return nums[low];
	}
	
	 public int findMin_2(int[] num) {
         int low = 0, high = num.length - 1;
		
		 while (low < high) {
	            int mid = low + (high - low) / 2;
	            if (num[mid] < num[high])
	                // the mininum is in the left part
	                high = mid;
	            else if (num[mid] > num[high])
	                // the mininum is in the right part
	                low = mid + 1;
                else
                    high--;
	        }

	        return num[low];
    }

}