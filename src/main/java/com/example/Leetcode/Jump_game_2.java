package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Jump_game_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 2, 3, 1, 1, 4 };
		int res = jump(nums);
		System.out.println(res);

	}

	public static int jump(int[] A) {
		return helper(A, 0);
	}

	private static int helper(int[] A, int start) {
		if (start >= A.length - 1)
			return 0;

		int minJump = Integer.MAX_VALUE;
		for (int i = start + 1; i <= start + A[start]; i++)
			minJump = Math.min(minJump, 1 + helper(A, i));

		return minJump;
	}
}
