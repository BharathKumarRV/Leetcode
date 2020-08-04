package com.example.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class Permutation_unique {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 1, 1, 2 };
		List<List<Integer>> res = new ArrayList<>();
		res = permuteUnique(nums);
		System.out.println(res);

	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return res;
		boolean[] used = new boolean[nums.length];
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(nums); // So that duplicate numbers sit next to each other
		dfs(nums, used, list, res);
		// dfs_2(nums, list, res);
		return res;
	}

	public static void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
		if (list.size() == nums.length) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i])
				continue;
			if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1])
				continue;
			used[i] = true; // keep one number constant(ex:1)and find permute of other two.
			list.add(nums[i]);
			dfs(nums, used, list, res); // Finding permute of other numbers
			used[i] = false; // Un mark the number
			list.remove(list.size() - 1); // Also remove the number(ex:1)
			// Removing the duplicates

			/*
			 * while ((i + 1) < nums.length && nums[i] == nums[i + 1]) { ++i; }
			 */

		}
	}

	public static void dfs_2(int[] nums, List<Integer> list, List<List<Integer>> res) {
		if (list.size() == nums.length) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (list.contains(nums[i]))
				continue;
			list.add(nums[i]);
			dfs_2(nums, list, res);
			list.remove(list.size() - 1); // Also remove the number(ex:1)

		}
	}
}
