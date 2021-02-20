package com.example.Leetcode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class GenerateParenthesis_3 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int n = 3;
		List<String> res = generateParenthesis(n);
		System.out.println(res);

	}

	/*
	 * @proGeekCoder This is for the backtrack(ing) to the previous state.
	 * StringBuilder, unlike String which is immutable, is like pass-by-reference.
	 * The reference on different levels of call stacks gets to the same reference
	 * of the StringBuilder. That is why removal the trailing character,
	 * appended/added in the previous state, is necessary, to backtrack to the
	 * previous state. The adding/appending one character to a StringBuilder costs
	 * O(1).
	 * 
	 * In contract, Strings in different call stacks are newly generated,
	 * pass-by-value. In another word, it refers to a different String on a
	 * different level of the call stacks. That is the reason why there is no need
	 * to do anything on the String to backtrack to the previous state. Simply
	 * backtracking to the previous call stack works. The adding/appending one
	 * character to a String costs O(L). L is the length of that specific String.
	 */
	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		if (n <= 0) {
			return res;
		}
		StringBuilder curr = new StringBuilder();
		backTracking(n, n, res, curr);
		return res;
	}

	private static void backTracking(int left, int right, List<String> res, StringBuilder curr) {
		if (left == 0 && right == 0) {
			res.add(curr.toString());
			return;
		}
		if (left > 0) {
			curr.append("(");
			backTracking(left - 1, right, res, curr);
			curr.deleteCharAt(curr.length() - 1);
		}
		if (right > left) {
			curr.append(")");
			backTracking(left, right - 1, res, curr);
			curr.deleteCharAt(curr.length() - 1);
		}
	}
}
