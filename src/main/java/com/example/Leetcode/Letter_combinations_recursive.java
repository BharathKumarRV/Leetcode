package com.example.Leetcode;

import java.util.LinkedList;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class Letter_combinations_recursive {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);

		String nums = "23";
		List<String> res = letterCombinations(nums);
		System.out.println(res);

	}
	
	private static final String[] KEYS = { "", "", "ab", "cd", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    
	public static List<String> letterCombinations(String digits) {
		List<String> ret = new LinkedList<String>();
		combination("", digits, 0, ret);
		return ret;
	}

	private static void combination(String prefix, String digits, int offset, List<String> ret) {
		if (offset >= digits.length()) {
			ret.add(prefix);
			return;
		}
		String letters = KEYS[(digits.charAt(offset) - '0')];
		for (int i = 0; i < letters.length(); i++) {
			combination(prefix + letters.charAt(i), digits, offset + 1, ret);
		}
	}
}
