package com.example.Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class GenerateParenthesis_DP {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		// LeetcodeApplication la = new LeetcodeApplication();
		int n = 3;
		List<String> res = generateParenthesis(n);
		System.out.println(res);

	}

	public static List<String> generateParenthesis(int n) {
		List<List<String>> lists = new ArrayList<>();
		lists.add(Collections.singletonList(""));

		for (int i = 1; i <= n; ++i) {
			final List<String> list = new ArrayList<>();

			for (int j = 0; j < i; ++j) {
				for (final String first : lists.get(j)) {
					for (final String second : lists.get(i - 1 - j)) {
						list.add("(" + first + ")" + second);
					}
				}
			}

			lists.add(list);
		}

		return lists.get(lists.size() - 1);
	}
}
