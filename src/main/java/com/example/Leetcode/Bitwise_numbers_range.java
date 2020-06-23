package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Bitwise_numbers_range {

	public static int rangeBitwiseAnd(int m, int n) {
		int i = 0; // i means we have how many bits are 0 on the right
		while (m != n) {
			m >>= 1;
			n >>= 1;
			i++;
		}
		return m << i;
	}

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int res = rangeBitwiseAnd(26,30);
		System.out.println(res);

	}

}
