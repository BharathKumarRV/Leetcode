package com.example.Leetcode;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;

public class Valid_anagrams {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		boolean res = isAnagram("anagram", "nagaram");
		System.out.println(res);

	}

	/*
	 * public static boolean isAnagram(String s, String t) { int[] alphabet = new
	 * int[26]; for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
	 * for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--; for (int
	 * i : alphabet) if (i != 0) return false; return true; }
	 */

	public static boolean isAnagram(String s, String t) {
		HashMap<Character, Integer> smap = new HashMap<>();
		int sl = s.length();
		int tl = t.length();
		if (sl != tl) {
			return false;
		}
		for (int i = 0; i < sl; i++) {
			smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
			smap.put(t.charAt(i), smap.getOrDefault(t.charAt(i), 0) - 1);
		}
		for (char c : smap.keySet()) {
			if (smap.get(c) != 0) {
				return false;
			}
		}

		return true;
	}
}
