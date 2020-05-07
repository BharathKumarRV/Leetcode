package com.example.Leetcode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class Palindromic_partition {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); String s = "aab";
	 * List<List<String>> res = partition(s); System.out.println(res);
	 * 
	 * }
	 */

	public static List<List<String>> partition(String s) {
		// Backtracking
		// Edge case
		if (s == null || s.length() == 0)
			return new ArrayList<>();

		List<List<String>> result = new ArrayList<>();
		helper(s, new ArrayList<>(), result);
		return result;
	}

	public static void helper(String s, List<String> step, List<List<String>> result) {
		// Base case
		if (s == null || s.length() == 0) {
			result.add(new ArrayList<>(step));
			return;
		}
		for (int i = 1; i <= s.length(); i++) {
			String temp = s.substring(0, i);
			if (!isPalindrome(temp))
				continue; // only do backtracking when current string is palindrome

			step.add(temp); // choose
			helper(s.substring(i, s.length()), step, result); // explore
			step.remove(step.size() - 1); // unchoose
		}
		return;
	}

	public static boolean isPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		while (left <= right) {
			if (s.charAt(left) != s.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}
}
