package com.example.Leetcode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class Permutation1_iterative {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> res = new ArrayList<>();
		res = permute(nums);
		System.out.println(res);

	}

	public static List<List<Integer>> permute(int[] num) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		if (num.length == 0)
			return ans;
		List<Integer> l0 = new ArrayList<Integer>();
		l0.add(num[0]);
		ans.add(l0);
		for (int i = 1; i < num.length; ++i) {
			List<List<Integer>> new_ans = new ArrayList<List<Integer>>();
			for (int j = 0; j <= i; ++j) {
				for (List<Integer> l : ans) {
					List<Integer> new_l = new ArrayList<Integer>(l);
					new_l.add(j, num[i]);
					new_ans.add(new_l);
				}
			}
			ans = new_ans;
		}
		return ans;
	}

}
