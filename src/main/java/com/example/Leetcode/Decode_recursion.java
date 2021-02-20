package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Decode_recursion {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int res = numDecodings("226");
		System.out.print(res);

	}

	public static int numDecodings(String s) {
		return helper(s, s.length());
	}

	public static int helper(String s, int k) {
		if (k == 0) {
			return 1;
		}
		int start = s.length() - k;
		if (s.charAt(start) == '0') {
			return 0;
		}
		int res = helper(s, k - 1);

		if (k >= 2 && Integer.valueOf(s.substring(start, start + 2)) <= 26) {
			res += helper(s, k - 2);
		}
		return res;
	}
}
