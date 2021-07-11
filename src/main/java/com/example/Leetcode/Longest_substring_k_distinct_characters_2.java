package com.example.Leetcode;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;

public class Longest_substring_k_distinct_characters_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int res = Longest_substring_k_distinct_character("abcabcbb", 2);
		System.out.println(res);

	}

	public static int Longest_substring_k_distinct_character(String str, int k) {
		int ans = 0;
		int i = 0, j = 0;

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		while (j < str.length()) {

			char ch = str.charAt(j);
			map.put(ch, map.getOrDefault(ch, 0) + 1);

			if (map.size() < k) {
				j++;
			} else if (map.size() == k) {
				int len = j - i + 1;
				if (len > ans) {
					ans = len;
				}
				j++;
			} else if (map.size() > k) {

				while (map.size() > k) {
					char ch2 = str.charAt(i);

					if (map.get(ch2) == 1) {
						map.remove(ch2);
					} else {
						map.put(ch2, map.get(ch2) - 1);
					}
					i++;
				}
				j++;
			}

		}

		return ans;

	}
}
