package com.example.Leetcode;

public class Palindrome {
	
	public boolean isPalindrome(int x) {

		if (x < 0) {
			return false;
		}

		int original = x;

		int result = 0;
		int digit = 0;
		while (x != 0) {

			digit = x % 10;
			result = result * 10 + digit;
			x = x / 10;

		}

		if (result == original) {

			return true;
		}

		return false;

	}

}
