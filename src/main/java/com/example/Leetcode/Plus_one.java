package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Plus_one {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int digits[] = {1,2,0};
		int res[] = plusOne(digits);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}

	}

	public static int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}
		int result[] = new int[digits.length + 1];
		result[0] = 1;
		return result;
	}
}
