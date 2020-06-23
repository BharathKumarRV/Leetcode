package com.example.Leetcode;

import java.util.Stack;

import org.springframework.boot.SpringApplication;

public class Eval_rpn {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		// int[] nums= {4,1,2,1,2};
		String s[] = { "4", "13", "5", "/", "+" };
		int res = evalRPN(s);
		System.out.println(res);

	}

	public static int evalRPN(String[] tokens) {
		int a, b;
		Stack<Integer> S = new Stack<Integer>();
		for (String s : tokens) {
			if (s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-")) {
				int right = S.pop();
				int left = S.pop();
				if (s.equals("*")) {
					S.add(left * right);
				}
				if (s.equals("/")) {
					S.add(left / right);
				}

				if (s.equals("+")) {
					S.add(left + right);
				}

				if (s.equals("-")) {
					S.add(left - right);
				}

			} else {
				S.add(Integer.parseInt(s));
			}
		}
		return S.pop();
	}

}
