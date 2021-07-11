package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Jump_game_greedy {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 2, 3, 1, 1, 4 };
		int res = jump(nums);
		System.out.println(res);

	}

	public static int jump(int[] A) {
		int jump = 0, currentEnd = 0, nextEnd = 0;
		for (int i = 0; i < A.length - 1; i++) {
			nextEnd = Math.max(nextEnd, i + A[i]);
			if (i == currentEnd) {
				jump++;
				currentEnd = nextEnd;
			}
		}

		return jump;
	}
}
