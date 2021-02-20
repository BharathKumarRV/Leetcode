package com.example.Leetcode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class Substring_concatination_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		String s = "barfoofoomanfoobar";
		String str[] = { "foo", "bar" };
		List<Integer> res = findSubstring(s, str);
		System.out.println(res);

	}

	public static List<Integer> findSubstring(String s, String[] words) {
		String concat[] = new String[2];
		String pre1 = "";
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			concat[0] = pre1 + words[i];
			pre1 = concat[0];
		}
		String pre2 = "";
		for (int i = words.length - 1; i >= 0; i--) {
			concat[1] = pre2 + words[i];
			pre2 = concat[1];
		}
		for (int k = 0; k < concat.length; k++) {
			for (int i = 0; i < s.length() - concat[k].length() + 1; i++) {
				int j;
				for (j = 0; j < concat[k].length(); j++) {
					if (s.charAt(i + j) != concat[k].charAt(j)) {
						break;
					}
				}
				if (j == concat[k].length()) {
					res.add(i);
				}
			}
		}

		return res;
	}
}
