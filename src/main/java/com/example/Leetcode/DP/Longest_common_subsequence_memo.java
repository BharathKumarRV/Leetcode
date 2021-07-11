package com.example.Leetcode.DP;

public class Longest_common_subsequence_memo {

	public static void main(String args[]) {
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;
		int dp[][] = new int[m + 1][n + 1];

		// Loop to initially filled the
		// table with -1
		for (int i = 0; i < m + 1; i++)
			for (int j = 0; j < n + 1; j++)
				dp[i][j] = -1;

		System.out.println("Length of LCS is" + " " + lcs(X, Y, m, n, dp));
	}

	public static int lcs(char[] X, char[] Y, int m, int n, int dp[][]) {
		if (m == 0 || n == 0)
			return 0;
		if (dp[m][n] != -1) {
			return dp[m][n];
		}
		if (X[m - 1] == Y[n - 1])
			return dp[m][n] = 1 + lcs(X, Y, m - 1, n - 1, dp);
		else
			return dp[m][n] = max(lcs(X, Y, m, n - 1, dp), lcs(X, Y, m - 1, n, dp));
	}

	/* Utility function to get max of 2 integers */
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}
}
