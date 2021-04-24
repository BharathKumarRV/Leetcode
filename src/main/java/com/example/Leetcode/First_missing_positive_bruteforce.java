package com.example.Leetcode;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;

public class First_missing_positive_bruteforce {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 1 };
		int res;
		res = firstMissingPositive_2(nums);
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

	public static int firstMissingPositive_2(int[] A) {
		int max = 0;
		for (int i : A) {
			if (i > max) {
				max = i;
			}
		}
		int count[] = new int[max];

		for (int i : A) {
			if (i != 0) {
				count[i - 1] = 1;
			}
		}

		for (int i = 0; i < count.length; i++) {
			if (count[i] == 0) {
				return i + 1;
			}
		}

		return -1;
	}

}
