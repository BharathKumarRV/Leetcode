package com.example.Leetcode.practice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;

import com.example.Leetcode.LeetcodeApplication;

public class Test {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int nums[] = { 2, 3, 6, 7 };
		List<List<Integer>> res = combinationsum(nums, 7);
		System.out.println(res);

	}

	static private List<List<Integer>> res = new ArrayList<>();

	public static List<List<Integer>> combinationsum(int nums[], int target) {
		if (nums == null || nums.length == 0) {
			return res;
		}

		helper(nums, new ArrayList<>(), target, 0);
		return res;
	}

	public static void helper(int nums[], List<Integer> temp, int target, int start) {
		if (target < 0) {
			return;
		} else if (target == 0) {
			res.add(new ArrayList<>(temp));
		} else {
			for (int i = start; i < nums.length; i++) {
				temp.add(nums[i]);
				helper(nums, temp, target - nums[i], i);
				temp.remove(temp.size() - 1);
			}
		}
	}
}
