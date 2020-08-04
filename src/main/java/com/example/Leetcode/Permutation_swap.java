package com.example.Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.boot.SpringApplication;

public class Permutation_swap {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> res = new ArrayList<>();
		res = permuteUnique(nums);
		System.out.println(res);

	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return ans;
		}
		permute(ans, nums, 0);
		return ans;
	}

	private static void permute(List<List<Integer>> ans, int[] nums, int index) {
		if (index == nums.length) {
			List<Integer> temp = new ArrayList<>();
			for (int num : nums) {
				temp.add(num);
			}
			ans.add(temp);
			return;
		}
		Set<Integer> appeared = new HashSet<>();
		for (int i = index; i < nums.length; ++i) {
			if (appeared.add(nums[i])) {
				swap(nums, index, i);
				permute(ans, nums, index + 1);
				swap(nums, index, i);
			}
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int save = nums[i];
		nums[i] = nums[j];
		nums[j] = save;
	}
}
