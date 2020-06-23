package com.example.Leetcode;

import java.util.TreeSet;

import org.springframework.boot.SpringApplication;

public class Contains_duplicates_3 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int nums[] = { 1, 5, 9, 1, 5, 9 };
		boolean res = containsNearbyAlmostDuplicate(nums, 2, 3);
		System.out.println(res);

	}

	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums.length < 2 || k == 0) {
			return false;
		}
		TreeSet<Long> set = new TreeSet<>();

		for (int i = 0; i < nums.length; i++) {
			Long floor = set.floor((long) nums[i]);
			Long ceiling = set.ceiling((long) nums[i]);
			if ((floor != null && nums[i] - floor <= t) || (ceiling != null && ceiling - nums[i] <= t)) {
				return true;
			}
			set.add((long) nums[i]);
			if (set.size() > k) {
				set.remove((long) nums[i - k]);
			}
		}
		return false;
	}
}
