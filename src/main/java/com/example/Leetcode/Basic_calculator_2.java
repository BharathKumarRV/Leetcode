package com.example.Leetcode;

import java.util.Stack;

import org.springframework.boot.SpringApplication;

public class Basic_calculator_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int res = calculate_2("3+2*2");
		System.out.println(res);
	}

	public static int calculate(String s) {
		int sum = 0;
		int tempSum = 0;
		int num = 0;
		char lastSign = '+';
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c))
				num = num * 10 + c - '0';
			if (i == s.length() - 1 || !Character.isDigit(c) && c != ' ') {
				switch (lastSign) {
				case '+':
					sum += tempSum;
					tempSum = num;
					break;
				case '-':
					sum += tempSum;
					tempSum = -num;
					break;
				case '*':
					tempSum *= num;
					break;
				case '/':
					tempSum /= num;
					break;
				}
				lastSign = c;
				num = 0;
			}
		}
		sum += tempSum;
		return sum;
	}
	
	
	 public static int calculate_2(String s) {
	        int len;
			if (s == null || (len = s.length()) == 0)
				return 0;
			Stack<Integer> stack = new Stack<Integer>();
			int num = 0;
			char sign = '+';
			for (int i = 0; i < len; i++) {
				if (Character.isDigit(s.charAt(i))) {
					num = num * 10 + s.charAt(i) - '0'; //To address two digits ex:20
				}
				if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1) {
					if (sign == '-') {
						stack.push(-num);
					}
	 				if (sign == '+') {
						stack.push(num);
					}
					if (sign == '*') {
						stack.push(stack.pop() * num);
					}
					if (sign == '/') {
						stack.push(stack.pop() / num);
					}
					sign = s.charAt(i);
					num = 0;
				}
			}

			int re = 0;
			for (int i : stack) {
				re += i;
			}
			return re;
	    }
}
