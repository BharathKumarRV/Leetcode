package com.example.Leetcode;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;

public class Word_break {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 4, 1, 2, 1, 2 };
		String s = "leetcode";
		Set<String> dict = new HashSet<>();
		dict.add("leet");
		dict.add("code");
		boolean res = wordBreak(s, dict);
		System.out.println(res);

	}

	public static boolean wordBreak(String s, Set<String> dict) {

		boolean[] f = new boolean[s.length() + 1];

		f[0] = true;

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (f[j] && dict.contains(s.substring(j, i))) {
					f[i] = true;
					break;
				}
			}
		}

		return f[s.length()];
	}

	public static boolean wordBreak_dp(String s, Set<String> dict) {

		int[] dp = new int[s.length() + 1];

		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j <= i; j++) {
				String w2check = s.substring(j, i);
				if (dict.contains(w2check)) {
					if (j > 0) {
						dp[i] += dp[j - 1];
					} else {
						dp[i] = 1;
					}
				}
			}
		}

		return dp[s.length() - 1] > 0;
	}
}
