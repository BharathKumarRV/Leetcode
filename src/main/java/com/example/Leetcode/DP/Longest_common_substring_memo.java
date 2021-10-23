package com.example.Leetcode.DP;

import java.util.HashMap;

public class Longest_common_substring_memo {

	static String X, Y;

	public static void main(String[] args) {
		int n, m;
		X = "abcdxyz";
		Y = "xyzabcd";

		m = X.length();
		n = Y.length();
		int dp[][] = new int[m + 1][n + 1];

		// Loop to initially filled the
		// table with -1
		for (int i = 0; i < m + 1; i++)
			for (int j = 0; j < n + 1; j++)
				dp[i][j] = -1;

		System.out.println(lcs(m, n, dp, 0));
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		System.out.println(lcs_2(0, 0, 0, hm));
	}

	static int count = 0;
	static int res = 0;

	public static int lcs(int i, int j, int dp[][], int count) {

		if (i == 0 || j == 0) {
			return count;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		int same = count;

		if (X.charAt(i - 1) == Y.charAt(j - 1)) {
			same = lcs(i - 1, j - 1, dp, count + 1);

		}
		// res = Math.max(count, dp[i][j]);
		int res = Math.max(same, Math.max(lcs(i, j - 1, dp, 0), lcs(i - 1, j, dp, 0)));
		dp[i][j] = res;
		return res;
	}

	public static int lcs_2(int i, int j, int count, HashMap<String, Integer> hm) {
		if (i >= X.length() || j >= Y.length())
			return count;
		String key = i + "_" + j + "_" + count; //need to consider count also to get correct answer
		if (hm.containsKey(key))
			return hm.get(key);

		int same = count;
		if (X.charAt(i) == Y.charAt(j)) {
			same = lcs_2(i + 1, j + 1, count + 1, hm);
		}
		int diff1 = lcs_2(i, j + 1, 0, hm);
		int diff2 = lcs_2(i + 1, j, 0, hm);
		int res = Math.max(same, Math.max(diff1, diff2));
		hm.put(key, res);
		return res;
	}
}
