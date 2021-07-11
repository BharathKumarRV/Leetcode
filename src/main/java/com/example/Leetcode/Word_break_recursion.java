package com.example.Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.boot.SpringApplication;

public class Word_break_recursion {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 4, 1, 2, 1, 2 };
		/*
		 * String s = "catsandog"; Set<String> dict = new HashSet<>(); dict.add("cats");
		 * dict.add("dog"); dict.add("sand"); dict.add("and"); dict.add("cat");
		 * dict.add("og");
		 */
		String s = "leetcode";
		List<String> dict = new ArrayList<>();
		dict.add("leet");
		dict.add("code");
		// boolean res = wordBreak(s, dict);
		wordBreak_2(s, dict);
		// System.out.println(res);

	}

	public static boolean wordBreak(String s, Set<String> wordDict) {
		// put all words into a hashset
		// Set<String> set = new HashSet<>(wordDict);
		return wb(s, wordDict);
	}

	public static void wordBreak_2(String s, List<String> wordDict) {
		// put all words into a hashset
		// Set<String> set = new HashSet<>(wordDict);
		// return wb(s, wordDict);
		List<String> res = new ArrayList<String>();
		wb_3(s, wordDict, "", res);
		System.out.println(res);
	}

	private static boolean wb(String s, Set<String> set) {
		int len = s.length();
		if (len == 0) {
			return true;
		}
		for (int i = 1; i <= len; ++i) {
			if (set.contains(s.substring(0, i)) && wb(s.substring(i), set)) {
				return true;
			}
		}
		return false;
	}

	private static void wb_2(String s, Set<String> set, String ans) {
		int len = s.length();
		if (len == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < len; ++i) {
			String left = s.substring(0, i + 1);
			if (set.contains(left)) {
				String right = s.substring(i + 1);
				wb_2(right, set, ans + left + " ");
			}
		}
	}

	private static void wb_3(String s, List<String> list, String ans, List<String> res) {
		int len = s.length();
		if (len == 0) {
			res.add(ans.trim());
			return;
		}
		for (int i = 0; i < len; ++i) {
			String left = s.substring(0, i + 1);
			if (list.contains(left)) {
				String right = s.substring(i + 1);
				wb_3(right, list, ans + left + " ", res);
			}
		}
	}

}
