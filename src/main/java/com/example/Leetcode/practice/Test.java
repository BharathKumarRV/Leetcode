package com.example.Leetcode.practice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;

import com.example.Leetcode.LeetcodeApplication;

public class Test {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int nums[] = { 1, 2, 2 };
		List<List<Integer>> res = combinationsum(nums);
		System.out.println(res);

	}

	// static private List<List<Integer>> res = new ArrayList<>();

	public static List<List<Integer>> combinationsum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		helper(nums, res, new ArrayList<>(), 0);
		return res;
	}

	public static void helper(int nums[], List<List<Integer>> res, List<Integer> temp, int start) {

		if (!res.contains(temp)) {
			res.add(new ArrayList<>(temp));
		}
		for (int i = start; i < nums.length; i++) {
			temp.add(nums[i]);
			helper(nums, res, temp, i + 1);
			temp.remove(temp.size() - 1);

		}
	}
}
