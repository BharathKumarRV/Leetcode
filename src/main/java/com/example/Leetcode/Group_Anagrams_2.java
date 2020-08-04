package com.example.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;

public class Group_Anagrams_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		String str[] = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> res = groupAnagrams(str);
		System.out.println(res);

	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			int[] count = new int[26];
			StringBuilder sb = new StringBuilder();
			for (char c : str.toCharArray())
				++count[c - 'a'];
			for (int c : count)
				sb.append(c);
			String t = sb.toString();
			if (!map.containsKey(t))
				map.put(t, new ArrayList<String>());
			map.get(t).add(str);
		}

		for (List<String> list : map.values())
			res.add(list);
		return res;
	}
}
