package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Power_of_2_new {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		double res = myPow(2.00000, -2);
		System.out.println(res);
	}

	public static double myPow(double x, int n) {

		double ans = 1.0;
		long nn = n;

		if (n < 0) {
			nn = -1 * n;
		}

		while (nn > 0) {
			if (nn % 2 == 1) {
				ans = ans * x;
				nn = nn - 1;
			} else {
				x = x * x;
				nn = nn / 2;
			}
		}

		if (n < 0) {
			ans = (double) (1.0) / (double) (ans);
		}

		return ans;
	}
}
