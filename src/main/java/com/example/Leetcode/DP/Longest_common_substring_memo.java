package com.example.Leetcode.DP;

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

		System.out.println(lcs(m, n, dp));
	}

	static int count = 0;

	public static int lcs(int i, int j, int dp[][]) {

		if (i == 0 || j == 0) {
			return 0;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		if (X.charAt(i - 1) == Y.charAt(j - 1)) {
			dp[i][j] = 1 + lcs(i - 1, j - 1, dp);
			count = Math.max(count, dp[i][j]);
		}
		count = Math.max(lcs(i, j - 1, dp), lcs(i - 1, j, dp));
		return count;
	}
}
