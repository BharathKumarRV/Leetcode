package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class ValidParenthesis_3 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		String s = "[()]";
		boolean res = isValid(s);
		System.out.println(res);

	}

	public static boolean isValid(String s) {
		int len;

		do {
			len = s.length();
			s = s.replace("()", "");
			s = s.replace("[]", "");
			s = s.replace("{}", "");
		} while (len != s.length());

		return s.trim().isEmpty();
	}
}
