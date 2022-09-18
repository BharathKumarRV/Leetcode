package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class ShortestPalindrome {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		String res = shortestPalindrome("racecart");
		System.out.println(res);
	}

	public static String shortestPalindrome(String s) {

		String strDash = s + "#" + new StringBuilder(s).reverse().toString();
		int lps = LPS(strDash);

		String ans = new StringBuilder(s.substring(lps)).reverse().toString() + s;

		return ans;
	}

	private static int LPS(String s) {
		int lps[] = new int[s.length()];

		int len = 0;
		int i = 1;

		while (i < s.length()) {

			if (s.charAt(i) == s.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len > 0) {
					len = lps[len - 1];
				} else {
					i++;
				}
			}
		}

		return lps[lps.length - 1];
	}
}
