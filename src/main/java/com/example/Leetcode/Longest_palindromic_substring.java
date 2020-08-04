package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Longest_palindromic_substring {

	static int lo = 0, maxLen = 0;

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		String res = longestPalindrome("babad");
		System.out.println(res);

	}
	
	public static String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2)
			return s;

		for (int i = 0; i < len - 1; i++) {
			extendPalindrome(s, i, i + 1); // assume even length. ex: abba
			extendPalindrome(s, i, i); // assume odd length, try to extend Palindrome as possible ex: racecar
		}
		return s.substring(lo, lo + maxLen);
	}

	private static void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--; 
			k++;
		}
		//lo is the index of palindromic string, and the maxlen is the length of palindromic string
		if (maxLen < k - j - 1) {
			lo = j + 1; //Since while loop breaks after j-- it requires lo index to start with j+1.
			maxLen = k - j - 1;
		}
	}
}
