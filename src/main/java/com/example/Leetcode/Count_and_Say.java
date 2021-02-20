package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Count_and_Say {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		String res = countAndSay(4);
		System.out.println(res);

	}

	public static String countAndSay(int n) {
		if (n <= 0)
			return "-1";
		String result = "1";
		for (int i = 1; i < n; i++) {
			result = build(result);
		}
		return result;
	}

	private static String build(String result) {
		StringBuilder builder = new StringBuilder();
		int p = 0;
		while (p < result.length()) {
			char val = result.charAt(p);
			int count = 0;

			while (p < result.length() && result.charAt(p) == val) {
				p++;
				count++;
			}
			builder.append(String.valueOf(count));
			builder.append(val);
		}
		return builder.toString();
	}
}
