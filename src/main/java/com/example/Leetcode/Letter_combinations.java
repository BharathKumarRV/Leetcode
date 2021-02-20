package com.example.Leetcode;

import java.util.LinkedList;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class Letter_combinations {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);

		String nums = "23";
		List<String> res = letterCombinations(nums);
		System.out.println(res);

	}

	public static List<String> letterCombinations(String digits) {

		LinkedList<String> ans = new LinkedList<String>();
		if (digits.isEmpty())
			return ans;
		String[] mapping = new String[] { "0", "1", "ab", "cd", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		ans.add("");
		for (int i = 0; i < digits.length(); i++) {
			int x = digits.charAt(i)-'0';
			while (ans.peek().length() == i) {
				String t = ans.remove();
				for (char s : mapping[x].toCharArray())
					ans.add(t + s);
			}
		}
		return ans;
	}
}
