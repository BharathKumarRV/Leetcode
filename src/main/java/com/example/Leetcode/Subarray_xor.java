package com.example.Leetcode;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;

public class Subarray_xor {

	public static int solve(int[] A, int B) {
		int c = 0;
		for (int i = 0; i < A.length; i++) {
			int current_xor = 0;
			for (int j = i; j < A.length; j++) {
				current_xor ^= A[j];
				if (current_xor == B)
					c++;
			}
		}
		return c;
	}

	public static int solve2(int[] A, int B) {
		HashMap<Integer, Integer> visited = new HashMap<Integer, Integer>();
		int c = 0;
		int cpx = 0;
		int n = A.length;
		for (int i = 0; i < n; i++) {
			cpx = cpx ^ A[i];
			if (visited.get(cpx ^ B) != null)
				c += visited.get(cpx ^ B);
			if (cpx == B) {
				c++;
			}
			if (visited.get(cpx) != null)
				visited.put(cpx, visited.get(cpx) + 1);
			else
				visited.put(cpx, 1);
		}
		return c;
	}

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] A = new int[] { 4, 2, 2, 6, 4 };
		int res = solve(A, 6);
		System.out.println(res);

	}

}
