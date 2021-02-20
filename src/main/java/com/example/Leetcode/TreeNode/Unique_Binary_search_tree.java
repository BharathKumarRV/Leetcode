package com.example.Leetcode.TreeNode;

import org.springframework.boot.SpringApplication;

import com.example.Leetcode.LeetcodeApplication;

public class Unique_Binary_search_tree {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int res = numTrees(2);
		System.out.println(res);

	}

	public static int numTrees(int n) {
		if (n < 2) {
			return 1;
		}
		int[] sol = new int[n + 1];
		sol[0] = 1;
		sol[1] = 1;
		for (int i = 2; i <= n; i++)
			for (int j = 0; j < i; j++)
				sol[i] += sol[i - j - 1] * sol[j];
		return sol[n];
	}

}
