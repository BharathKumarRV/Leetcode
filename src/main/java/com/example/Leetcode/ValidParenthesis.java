package com.example.Leetcode;

import java.util.List;
import java.util.Stack;

import org.springframework.boot.SpringApplication;

public class ValidParenthesis {
	
	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); LeetcodeApplication
	 * la = new LeetcodeApplication(); String s="()"; boolean res = la.isValid(s);
	 * System.out.println(res);
	 * 
	 * }
	 */

	public boolean isValid(String s) {

		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();

	}
}
