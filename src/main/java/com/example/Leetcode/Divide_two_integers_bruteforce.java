package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Divide_two_integers_bruteforce {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int res = divide(10, 3);
		System.out.println(res);

	}

	public static int divide(int dividend, int divisor) {
		int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
		long ldividend = Math.abs((long) dividend);
		long ldivisor = Math.abs((long) divisor);

		// Take care the edge cases.

		long lres = 0;

		while(ldivisor<=ldividend) {
			ldividend -= ldivisor;
			lres++;
		}
		
		if (sign < 0) {
			lres = -lres;
		}
		if (lres >= Integer.MAX_VALUE || lres < Integer.MIN_VALUE) {
			lres = Integer.MAX_VALUE;
		}
		return (int) lres;
	}
}
