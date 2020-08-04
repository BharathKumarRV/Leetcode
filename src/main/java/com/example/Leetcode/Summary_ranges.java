package com.example.Leetcode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class Summary_ranges {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int nums[] = { 0, 2, 3, 4, 6, 8, 9 };
		List<String> res = summaryRanges2(nums);
		System.out.println(res);
	}

	public static List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		int count = 0;
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if ((i + 1 < nums.length) && (nums[i] + 1 == nums[i + 1])) {
				count++;
				continue;
			}
			if (count == 0) {
				res.add(String.valueOf(nums[i]));
			} else {
				StringBuilder sb = new StringBuilder();
				sb.append(nums[i - count]);
				sb.append("->");
				sb.append(nums[i]);
				res.add(String.valueOf(sb));
				count = 0;
			}
		}

		return res;
	}
	
	public static List<String> summaryRanges2(int[] nums) {
		List<String> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		int count = 0;
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if ((i + 1 < nums.length) && (nums[i] + 1 == nums[i + 1])) {
				count++;
				continue;
			}
			if (count == 0) {
				res.add(String.valueOf(nums[i]));
			} else {
				res.add(nums[i-count]+"->"+nums[i]);
				count = 0;
			}
		}

		return res;
	}
}
