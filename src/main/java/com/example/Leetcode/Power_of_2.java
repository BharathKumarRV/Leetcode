package com.example.Leetcode;

import java.util.List;

import org.springframework.boot.SpringApplication;

public class Power_of_2 {

	/*
	 * public static boolean isPowerOfTwo(int n) { if (n <= 0) return false; while
	 * (n % 2 == 0) n /= 2; return n == 1; }
	 * 
	 * public static boolean isPowerOfTwo(int n) { return n > 0 && (n == 1 || (n % 2
	 * == 0 && isPowerOfTwo(n / 2))); }
	 */

	public static boolean isPowerOfTwo(int n) {
		return n > 0 && ((n & (n - 1)) == 0);
	}

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		boolean res = isPowerOfTwo(15);
		System.out.println(res);
	}
}
