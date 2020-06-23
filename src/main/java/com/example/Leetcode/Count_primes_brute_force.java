package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Count_primes_brute_force {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int res = countPrimes(10);
		System.out.println(res);

	}

	public static int countPrimes(int n) {

		int count = 0;
		for (int i = 2; i < n; i++) {
			if (isPrime(i))
				count++;
		}

		return count;

	}

	private static boolean isPrime(int x) {
		for (int i = 2; i * i <= x; i++) {
			if (x % i == 0)
				return false;
		}
		return true;
	}
}
