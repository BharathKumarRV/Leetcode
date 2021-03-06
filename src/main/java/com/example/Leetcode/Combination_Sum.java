package com.example.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class Combination_Sum {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 2, 3, 6, 7 };
		List<List<Integer>> res;
		res = combinationSum(nums, 7);
		System.out.println(res);
	}

	public static List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums); // sort is needed as we can be sure that if nums[i]>remain then nums[j]>remain
							// where j>i
		backtrack(list, new ArrayList<>(), nums, target, 0);
		return list;
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
		if (remain < 0)
			return;
		if (remain == 0)
			list.add(new ArrayList<>(tempList));

		for (int i = start; i < nums.length; i++) {
			if (nums[i] > remain) // sort can be usefull here
				return;
			tempList.add(nums[i]);
			backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
			tempList.remove(tempList.size() - 1);
		}

	}
}
