package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Pow {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		double res = myPow(2, 3);
		System.out.println(res);

	}

	public static double pow(double x, int n) {
		if (n == 0)
			return 1.0;
		if (n == 1)
			return x;
		if (n < 0)
			return pow(1 / x, -n);
		double result = pow(x * x, n / 2);
		if (n % 2 == 1)
			result *= x;
		return result;
	}

	public static double myPow_2(double x, int n) {
		if (n == 0)
			return 1;
		double temp = myPow(x, n / 2);

		if (n % 2 == 0)
			return temp * temp;
		else if (n > 0)
			return temp * temp * x;
		else
			return (temp * temp) / x;
	}

	public static double myPow(double x, int n) {
		if (n == 0)
			return 1;
		if (n < 0) {
			return 1 / x * myPow(1 / x, -(n + 1));
		}
		return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
	}
}
