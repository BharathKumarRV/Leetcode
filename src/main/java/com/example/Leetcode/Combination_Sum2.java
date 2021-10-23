package com.example.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class Combination_Sum2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 10, 1, 2, 7, 6, 1, 5 };
		List<List<Integer>> res;
		res = combinationSum2(nums, 8);
		System.out.println(res);
	}

	public static List<List<Integer>> combinationSum2(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		dfs_com(nums, 0, target, path, res);
		return res;
	}

	public static void dfs_com(int[] nums, int cur, int target, List<Integer> path, List<List<Integer>> res) {
		if (target == 0) {
			res.add(new ArrayList(path));
			return;
		}
		if (target < 0)
			return;
		for (int i = cur; i < nums.length; i++) {
			if (nums[i] > target) {
				return;
			}
			/*
			 * if (i > cur && nums[i] == nums[i - 1]) { System.out.println("skipping");
			 * continue; }
			 */
			path.add(nums[i]);
			dfs_com(nums, i + 1, target - nums[i], path, res);
			path.remove(path.size() - 1);

			if ((i + 1) < nums.length - 1 && nums[i] == nums[i + 1]) {
				i++;
			}
		}
	}
}
