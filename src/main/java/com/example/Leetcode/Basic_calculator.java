package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Basic_calculator {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int res = calculate("3+2*2");
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
}
