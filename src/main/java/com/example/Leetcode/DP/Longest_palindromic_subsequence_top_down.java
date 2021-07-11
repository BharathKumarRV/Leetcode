package com.example.Leetcode.DP;

public class Longest_palindromic_subsequence_top_down {

	public static void main(String args[]) {
		// String s1 = "AGGTAB";
		StringBuffer s1 = new StringBuffer("AGBCBA");
		String s2 = s1.reverse().toString();

		char[] X = s1.toString().toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		System.out.println("Length of Palindromic Subsequence is" + " " + lcs_2(X, Y, m, n));
	}

	static int lcs(char[] X, char[] Y, int m, int n) {
		int L[][] = new int[m + 1][n + 1];

		/*
		 * Following steps build L[m+1][n+1] in bottom up fashion. Note that L[i][j]
		 * contains length of LCS of X[0..i-1] and Y[0..j-1]
		 */
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					L[i][j] = 0;
				else if (X[i - 1] == Y[j - 1])
					L[i][j] = L[i - 1][j - 1] + 1;
				else
					L[i][j] = max(L[i - 1][j], L[i][j - 1]);
			}
		}
		return L[m][n];
	}

	static int lcs_2(char[] X, char[] Y, int m, int n) {
		int dp[][] = new int[m][m];

		for (int g = 0; g < X.length; g++) {
			for (int i = 0, j = g; j < dp.length; i++, j++) {
				if (g == 0) {
					dp[i][j] = 1;
				} else if (g == 1) {
					dp[i][j] = (X[i] == X[j]) ? 2 : 1;
				} else {
					if (X[i] == X[j]) {
						dp[i][j] = 2 + dp[i + 1][j - 1];
					} else {
						dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
					}
				}
			}

		}

		return dp[0][X.length - 1];
	}

	static int max(int a, int b) {
		return (a > b) ? a : b;
	}
}
