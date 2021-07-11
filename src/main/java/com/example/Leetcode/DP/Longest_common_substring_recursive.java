package com.example.Leetcode.DP;

public class Longest_common_substring_recursive {

	static String X, Y;

	public static void main(String[] args) {
		int n, m;
		X = "abcdxyz";
		Y = "xyzabcd";

		n = X.length();
		m = Y.length();

		System.out.println(lcs(n, m, 0));
	}

	public static int lcs(int i, int j, int count) {

		if (i == 0 || j == 0) {
			return count;
		}

		if (X.charAt(i - 1) == Y.charAt(j - 1)) {
			count = lcs(i - 1, j - 1, count + 1);
		}
		count = Math.max(count, Math.max(lcs(i, j - 1, 0), lcs(i - 1, j, 0)));
		return count;
	}
}
