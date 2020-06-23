package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Eval_rpn_recursive {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		// int[] nums= {4,1,2,1,2};
		String s[] = { "4", "13", "5", "/", "+" };
		int res = evalRPN(s);
		System.out.println(res);

	}

	static int back;

	public static int evalRPN(String[] tokens) {
		back = tokens.length;
		return helper(tokens);
	}

	public static int helper(String[] tokens) {
		String str = tokens[--back];
		if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
			int second = helper(tokens);
			int first = helper(tokens);

			switch (str) {
			case "+":
				return first + second;
			case "-":
				return first - second;
			case "*":
				return first * second;
			default:
				return first / second;
			}
		}

		return Integer.parseInt(str);
	}
}
