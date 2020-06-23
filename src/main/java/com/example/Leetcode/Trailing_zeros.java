package com.example.Leetcode;

public class Trailing_zeros {

	public static void main(String[] args) {
		int res = trailingZeroes(10);
		System.out.println(res);

	}

	public static int trailingZeroes(int n) {
		int count = 0;
		while (n != 0) {
			int tmp = n / 5;
			count += tmp;
			n = tmp;
		}
		return count;
	}

	/*
	 * public static int trailingZeroes(int n) { return n == 0 ? 0 : n / 5 +
	 * trailingZeroes(n / 5); }
	 * 
	 * public static int trailingZeroes(int n) { if (n < 5) return 0; else return (n
	 * / 5) + trailingZeroes(n / 5); }
	 */

}
