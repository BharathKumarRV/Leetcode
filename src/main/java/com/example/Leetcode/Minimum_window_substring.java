package com.example.Leetcode;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;

public class Minimum_window_substring {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);

		String res = minWindow("ADOBECODEBANC", "ABC");
		System.out.println(res);

	}

	public static String minWindow(String s, String t) {

		Map<Character, Integer> map1 = new HashMap<>();

		for (char c : t.toCharArray()) {
			map1.put(c, map1.getOrDefault(c, 0) + 1);
		}

		int mct = 0;
		int dmct = t.length();

		int i = -1;
		int j = -1;
		String ans = "";
		Map<Character, Integer> map2 = new HashMap<>();

		while (true) {
			boolean f1 = false;
			boolean f2 = false;
			while (i < s.length() - 1 && mct < dmct) {
				i++;
				Character c = s.charAt(i);
				map2.put(c, map2.getOrDefault(c, 0) + 1);

				if (map2.getOrDefault(c, 0) <= map1.getOrDefault(c, 0)) {
					mct++;
				}

				f1 = true;
			}

			while (j < i && mct == dmct) {
				String pans = s.substring(j + 1, i + 1);
				if (ans.length() == 0 || pans.length() < ans.length()) {
					ans = pans;
				}

				j++;
				Character c = s.charAt(j);
				if (map2.getOrDefault(c, 0) == 1) {
					map2.remove(c);
				} else {
					map2.put(c, map2.getOrDefault(c, 0) - 1);
				}

				if (map2.getOrDefault(c, 0) < map1.getOrDefault(c, 0)) {
					mct--;
				}
				f2 = true;

			}

			if (f1 == false && f2 == false) {
				break;
			}

		}

		return ans;
	}
}
