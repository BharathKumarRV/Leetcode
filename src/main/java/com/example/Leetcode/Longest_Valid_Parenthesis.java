package com.example.Leetcode;

import java.util.Stack;

import org.springframework.boot.SpringApplication;

public class Longest_Valid_Parenthesis {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		String s = ")(())))";
		int res = longestValidParentheses(s);
		System.out.println(res);

	}

	public static int longestValidParentheses(String s) {

		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		int left = -1;
		for (int j = 0; j < s.length(); j++) {
			if (s.charAt(j) == '(')
				stack.push(j);
			else {
				if (stack.isEmpty())
					left = j;
				else {
					stack.pop();
					if (stack.isEmpty())
						max = Math.max(max, j - left);
					else
						max = Math.max(max, j - stack.peek());
				}
			}
		}
		return max;

	}

	public static int longestValidParentheses_2(String s) {

		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		int left = -1;
		for (int j = 0; j < s.length(); j++) {
			if (s.charAt(j) == '(')
				stack.push(j);
			else {
				if (stack.isEmpty())
					left = j;
				else {
					stack.pop();
					max = Math.max(max, j - stack.peek());
				}
			}
		}
		return max;

	}

	public static int longestValidParentheses_3(String s) {

		Stack<Integer> st = new Stack<>();
		st.push(-1);
		int max = 0;
		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);

			if (c == '(') {
				st.push(i);
			} else {
				st.pop();
				if (st.isEmpty()) {
					st.push(i);
				} else {
					int len = i - st.peek();
					max = Math.max(max, len);
				}
			}
		}

		return max;
	}

}