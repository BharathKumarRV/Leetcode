package com.example.Leetcode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class Combination_sum_3 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);

		List<List<Integer>> res = combinationSum3(3, 9);
		System.out.println(res);

	}

	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> ans = new ArrayList<>();
		combination(ans, new ArrayList<Integer>(), k, 1, n);
		return ans;
	}

	private static void combination(List<List<Integer>> ans, List<Integer> comb, int k, int start, int n) {

		if (comb.size() > k) {
			return;
		}

		if (comb.size() == k && n == 0) {
			List<Integer> li = new ArrayList<Integer>(comb);
			ans.add(li);
			return;
		}
		for (int i = start; i <= 9; i++) {
			comb.add(i);
			combination(ans, comb, k, i + 1, n - i);
			comb.remove(comb.size() - 1);
		}
	}
}
