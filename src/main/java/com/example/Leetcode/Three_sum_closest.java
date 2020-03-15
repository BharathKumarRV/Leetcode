package com.example.Leetcode;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;

public class Three_sum_closest {
	
	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); LeetcodeApplication
	 * la = new LeetcodeApplication(); int nums[] = {-1, 2, 1, -4}; int target=1;
	 * int res = la.threeSumClosest(nums,target); System.out.println(res);
	 * 
	 * }
	 */

	public int threeSumClosest(int[] nums, int target) {

		Arrays.sort(nums);
		int sum = nums[0] + nums[1] + nums[nums.length - 1];
		int closestSum = sum;

		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				int left = i + 1, right = nums.length - 1;
				while (left < right) {
					sum = nums[left] + nums[right] + nums[i];
					if (sum < target) {
						// move closer to target sum.
						while (left < right && nums[left] == nums[left + 1]) {
							left++;
						}
						left++;
					} else if (sum > target) {
						// move closer to target sum.
						while (left < right && nums[right] == nums[right - 1]) {
							right--;
						}
						right--;
					} else {
						return sum;
					}
					// update the closest sum if needed.
					if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
						closestSum = sum;
					}
				}
			}

		}
		return closestSum;

	}
}
