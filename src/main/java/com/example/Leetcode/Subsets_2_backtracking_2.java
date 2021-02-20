package com.example.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class Subsets_2_backtracking_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int nums[] = { 1, 2, 2 };
		List<List<Integer>> res = subsetsWithDup(nums);
		System.out.println(res);

	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		helper(res, new ArrayList<>(), nums, 0, false);
		return res;
	}

	public static void helper(List<List<Integer>> res, List<Integer> ls, int[] nums, int pos, boolean choosePre) {
		if (pos == nums.length) {
			res.add(new ArrayList<>(ls));
			return;
		}
		helper(res, ls, nums, pos + 1, false);
		if (pos >= 1 && nums[pos] == nums[pos - 1] && !choosePre)
			return;
		ls.add(nums[pos]);
		helper(res, ls, nums, pos + 1, true);
		ls.remove(ls.size() - 1);
	}
}
