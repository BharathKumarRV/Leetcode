package com.example.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.SpringApplication;

public class Word_break_2_memo {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 4, 1, 2, 1, 2 };
		String s = "catsanddog";
		List<String> dict = new LinkedList<>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		//String s = "leetcode";
		List<String> dict2 = new ArrayList<>();
		dict2.add("leet");
		dict2.add("code");
		List<String> res = wordBreak(s, dict);
		System.out.println(res);

	}

	static Map<String, List<String>> map = new HashMap();

	public static List<String> wordBreak(String s, List<String> wordDict) {
		List<String> result = new LinkedList<>();
		if (wordDict.contains(s))
			result.add(s);
		if (map.containsKey(s))
			return map.get(s);
		for (int i = 1; i <= s.length(); i++) {
			String left = s.substring(0, i);
			if (wordDict.contains(left)) {
				for (String ss : wordBreak(s.substring(i), wordDict)) {
					result.add(left + " " + ss);
				}
			}
		}

		map.put(s, result);
		return result;
	}

	public static List<String> wordBreak_2(String s, List<String> wordDict) {
		List<String> result = new LinkedList<>();
		if (wordDict.contains(s))
			result.add(s);
		for (int i = 1; i <= s.length(); i++) {
			String left = s.substring(0, i);
			if (wordDict.contains(left)) {
				for (String ss : wordBreak(s.substring(i), wordDict)) {
					result.add(left + " " + ss);
				}
			}
		}
		return result;
	}
}
