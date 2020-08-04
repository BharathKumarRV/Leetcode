package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Palindrome_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		boolean res = isPalindrome(323);
		System.out.println(res);

	}

	private static int multiplier = 10;

	public static boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		return x == reverse(x);
	}

	private static int reverse(int x) {
		if (x < 10)
			return x;
		int reverse = reverse(x / 10) + (x % 10) * multiplier;
		multiplier *= 10;
		return reverse;
	}

}
