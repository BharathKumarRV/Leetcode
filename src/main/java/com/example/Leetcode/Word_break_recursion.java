package com.example.Leetcode;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;

public class Word_break_recursion {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 4, 1, 2, 1, 2 };
		String s = "catsandog";
		Set<String> dict = new HashSet<>();
		dict.add("cats");
		dict.add("dog");
		dict.add("sand");
		dict.add("and");
		dict.add("cat");
		boolean res = wordBreak(s, dict);
		System.out.println(res);

	}

	public static boolean wordBreak(String s, Set<String> wordDict) {
		// put all words into a hashset
	//	Set<String> set = new HashSet<>(wordDict);
		return wb(s, wordDict);
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
}
