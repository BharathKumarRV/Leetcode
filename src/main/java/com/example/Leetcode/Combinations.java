package com.example.Leetcode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class Combinations {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		List<List<Integer>> res = combine(4, 2);
		System.out.println(res);

	}

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> combs = new ArrayList<List<Integer>>();
		combine(combs, new ArrayList<Integer>(), 1, n, k);
		return combs;
	}
	
	/*
	 * For anyone stumped by why this change is necessary, it's because you should
	 * not continue exploring (recursing) when you know that there won't be enough
	 * numbers left until n to fill the needed k slots. If n = 10, k = 5, and you're
	 * in the outermost level of recursion, you choose only i = 1...6 , because if
	 * you pick i=7 and go into backTracking() you only have 8,9,10 to pick from, so
	 * at most you will get [7,8,9,10]... but we need 5 elements!
	 */

	public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
		if (k == 0) {
			combs.add(new ArrayList<Integer>(comb));
			return;
		}
		for (int i = start; i <= n; i++) {
			comb.add(i);
			combine(combs, comb, i + 1, n, k - 1);
			comb.remove(comb.size() - 1);
		}
		
		// for (int i = start; i <= n-k + 1 ; i++) ->Improvisation
	}
}
