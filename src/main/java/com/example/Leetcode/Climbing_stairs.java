package com.example.Leetcode;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;

public class Climbing_stairs {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int res = climbStairs3(3);
		System.out.println(res);
	}

	public static int climbStairs(int n) {
		int[] ways = new int[n + 1];
		if (n <= 1) {
			return 1;
		}
		ways[0] = 1;
		ways[1] = 1;
		for (int i = 2; i <= n; i++) {
			ways[i] = ways[i - 1] + ways[i - 2];
		}
		return ways[n];
	}

	public static int climbStairs2(int n) {
		// base cases
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		int one_step_before = 2;
		int two_steps_before = 1;
		int all_ways = 0;

		for (int i = 3; i <= n; i++) {
			all_ways = one_step_before + two_steps_before;
			two_steps_before = one_step_before;
			one_step_before = all_ways;
		}
		return all_ways;
	}

	static Map<Integer, Integer> map = new HashMap<>();

	public static int climbStairs3(int n) {
		if (n == 1) {
			map.put(1, 1);
		}
		if (n == 2) {
			map.put(2, 2);
		}
		if (map.containsKey(n))
			return map.get(n);
		map.put(n, climbStairs3(n - 1) + climbStairs3(n - 2));
		return map.get(n);
	}
}
