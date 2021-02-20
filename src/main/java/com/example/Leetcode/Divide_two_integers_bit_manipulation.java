package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Divide_two_integers_bit_manipulation {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int res = divide_3(43, 8);
		System.out.println(res);

	}

	public static int divide(int dividend, int divisor) {
		if (dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;
		int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
		long ldividend = Math.abs((long) dividend);
		long ldivisor = Math.abs((long) divisor);
		long lres = 0;

		long temp = 0;

		for (int i = 31; i >= 0; i--) {
			if (temp + (ldivisor << i) <= ldividend) {
				temp += ldivisor << i;
				lres += 1 << i;
			}
		}

		if (sign < 0) {
			lres = -lres;
		}
		/*
		 * if (lres >= Integer.MAX_VALUE || lres < Integer.MIN_VALUE) { lres =
		 * Integer.MAX_VALUE; }
		 */
		return (int) lres;
	}

	public static int divide_2(int dividend, int divisor) {
		if (dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;

		int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
		int result = 0;
		long x = Math.abs((long) dividend);
		long y = Math.abs((long) divisor);

		while (x >= y) {
			int shift = 1;

			while (x >= (y << shift)) {
				shift++;
			}
			x -= y << (shift - 1);
			result += 1 << (shift - 1);
		}
		return result * sign;
	}

	public static int divide_3(int A, int B) {
		if (A == 1 << 31 && B == -1)
			return (1 << 31) - 1;
		int a = Math.abs(A), b = Math.abs(B), res = 0, x = 0;
		while (a - b >= 0) {
			for (x = 0; a - (b << x << 1) >= 0; x++) {
				System.out.println("Nothing");
			}
			res += 1 << x;
			a -= b << x;
		}
		return (A > 0) == (B > 0) ? res : -res;
	}
}
