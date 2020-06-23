package com.example.Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.SpringApplication;

public class Contains_duplicates_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int nums[] = { 1, 0, 1, 1 };
		boolean res = containsNearbyDuplicate(nums, 1);
		System.out.println(res);

	}

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!set.add(nums[i]))
				return true;

    		if (set.size() > k)
				set.remove(nums[i - k]);

		}
		return false;
	}

	/*
	 * public static boolean containsNearbyDuplicate(int[] nums, int k) {
	 * Map<Integer, Integer> map = new HashMap<Integer, Integer>(); for (int i = 0;
	 * i < nums.length; i++) { if (map.containsKey(nums[i])) { if (i -
	 * map.get(nums[i]) <= k) return true; } map.put(nums[i], i); } return false; }
	 */
}
