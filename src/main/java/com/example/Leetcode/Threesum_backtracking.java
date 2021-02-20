package com.example.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class Threesum_backtracking {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int num[] = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> res = threeSum(num);
		System.out.println(res);

	}

	static List<List<Integer>> superlist = new ArrayList<>();

	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		help(nums, new ArrayList<>(), 0);
		return superlist;
	}

	public static void help(int[] nums, List<Integer> list, int start) {
		/* is list full? then chek if list elements added = 0 */
		if (list.size() == 3) {
			int check = 0;
			for (int i : list)
				check += i;
			if (check == 0)
				superlist.add(new ArrayList<>(list));
		} /* add to list if not full and recursion call itself */
		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1])
				continue;
			list.add(nums[i]);
			help(nums, list, i + 1);
			list.remove(list.size() - 1);
		}

	}

}
