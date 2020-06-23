package com.example.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Missing_ranges {

	public static void main(String[] args) {
		int[] array = { 0, 1, 3, 50, 75 };
		List<String> res = findMissingRanges(array, 0, 0);
		System.out.println(res);
	}

	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
		long l = (long) lower;
		long u = (long) upper;
		List<String> res = new ArrayList<>();
		//int n = nums.length;
		int n=0;

		if (n == 0) {
			add(res, l - 1, u + 1);
			return res;
		}

		add(res, l - 1, nums[0]);
		for (int i = 1; i < n; i++) {
			add(res, nums[i - 1], nums[i]);
		}
		add(res, nums[n - 1], u + 1);
		return res;
	}

	private static void add(List<String> res, long lo, long hi) {
		if (lo == hi) {
			return;
		} else if (lo + 1 == hi) {
			return;
		} else if (lo + 1 == hi - 1) {
			res.add(String.valueOf(lo + 1));
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append(String.valueOf(lo + 1));
			sb.append("->");
			sb.append(String.valueOf(hi - 1));
			res.add(sb.toString());
		}
	}
}
