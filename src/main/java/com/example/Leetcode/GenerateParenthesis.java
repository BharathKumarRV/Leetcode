package com.example.Leetcode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class GenerateParenthesis {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int n = 3;
		List<String> res = generateParenthesis(n);
		System.out.println(res);

	}

	public static List<String> generateParenthesis(int n) {

		List<String> list = new ArrayList<String>();
		backtrack(list, "", 0, 0, n);
		return list;
	}

	public static void backtrack(List<String> list, String str, int open, int close, int max) {

		if (str.length() == max * 2) {
			list.add(str);
			return;
		}

		if (open < max)
			backtrack(list, str + "(", open + 1, close, max);
		if (close < open)
			backtrack(list, str + ")", open, close + 1, max);

	}
}
