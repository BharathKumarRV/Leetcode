package com.example.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;

public class Word_break_4 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 4, 1, 2, 1, 2 };
		// String s = "catsanddog";
		// Set<String> dict = new HashSet<>();
		String s = "leetcode";
		List<String> dict = new ArrayList<>();
		dict.add("leet");
		dict.add("code");
		/*
		 * dict.add("cat"); dict.add("cats"); dict.add("and"); dict.add("sand");
		 * dict.add("dog");
		 */
		boolean res = wordBreak(s, dict);
		System.out.println(res);

	}

	static Map<String, Boolean> map = new HashMap();

	public static boolean wordBreak(String s, List<String> wordDict) {
		if (wordDict.contains(s))
			return true;
		if (map.containsKey(s))
			return map.get(s);
		for (int i = 1; i <= s.length(); i++) {
			String left = s.substring(0, i);
			if (wordDict.contains(left) && wordBreak(s.substring(i), wordDict)) {
				map.put(s, true);
				return true;
			}
		}
		map.put(s, false);
		return false;
	}
}
