package com.example.Leetcode;

import java.util.Stack;

import org.springframework.boot.SpringApplication;

public class Longest_Valid_Parenthesis_3 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		String s = ")))()";
		int res = longestValidParentheses(s);
		System.out.println(res);

	}

	public static int longestValidParentheses(String s) {
		int maxans = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if (stack.empty()) {
					stack.push(i);
				} else {
					maxans = Math.max(maxans, i - stack.peek());
				}
			}
		}
		return maxans;
	}

}
