package com.example.Leetcode;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;

public class First_missing_positive_bruteforce {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 1, 2, 3 };
		int res;
		res = firstMissingPositive(nums);
		System.out.println(res);

	}

	public static int firstMissingPositive(int[] A) {
		Set s = new HashSet();
		for (int a : A) {
			s.add(a);
		}
		for (int i = 1; i <= A.length; i++) {
			if (!s.contains(i)) {
				return i;
			}
		}
		return A.length + 1;
	}

}
