package com.example.Leetcode;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;

public class Three_sum_closest {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int nums[] = { -3, -2, -5, 3, -4 };
		int target = -1;
		int res = threeSumClosest_bruteforce(nums, target);
		System.out.println(res);

	}

	public static int threeSumClosest_bruteforce(int[] nums, int target) {

		int closest = nums[0]+nums[1]+nums[nums.length-1];

		// int diffO = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length - 2; i++) {

			for (int j = i + 1; j < nums.length - 1; j++) {

				for (int k = j + 1; k < nums.length; k++) {
					int v = nums[i] + nums[j] + nums[k];

					if (v == target) {
						return v;
					} else {
						if (Math.abs(v - target) < Math.abs(closest - target)) {
							closest = v;
						}
					}
				}

			}
		}

		return closest;
	}

	public static int threeSumClosest(int[] num, int target) {
		int result = num[0] + num[1] + num[num.length - 1];
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			int start = i + 1, end = num.length - 1;
			while (start < end) {
				int sum = num[i] + num[start] + num[end];
				if (sum > target) {
					end--;
				} else {
					start++;
				}
				if (Math.abs(sum - target) < Math.abs(result - target)) {
					result = sum;
				}
			}
		}
		return result;
	}

	public int threeSumClosest_2(int[] nums, int target) {

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
