package com.example.Leetcode;

public class ReverseInteger {

	public int reverse(int x) {

		int result = 0;

		while (x != 0) {
			int tail = x % 10;
			int newResult = result * 10 + tail;
			if ((newResult - tail) / 10 != result) { // If overflow occurs then newResult!= result
				return 0;
			}
			result = newResult;
			x = x / 10;
		}

		return result;

	}

	/*
	 * Assume we are dealing with an environment which could only hold integers
	 * within the 32-bit signed integer range.
	 * 
	 * Using long is against the rules.
	 */
	public static int reverse2(int x) {
		long rev = 0;
		while (x != 0) {
			rev = rev * 10 + x % 10;
			x = x / 10;
			if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
				return 0;
		}
		return (int) rev;
	}

	static long res = 0;

	public static int reverse3(int x) {

		if (x / 10 == 0) {
			res = (res * 10) + (x % 10);

			return (int) res;
		} else {
			res = (res * 10) + (x % 10);
			reverse3(x / 10);
		}
		if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
			return 0;
		else
			return (int) res;
	}
}
