package com.example.Leetcode.DP;

public class Minimum_deletion_required_palindrome {

	public static void main(String args[]) {
		// String s1 = "AGGTAB";
		StringBuffer s1 = new StringBuffer("AGBCBA");

		char[] X = s1.toString().toCharArray();
		int m = X.length;
		int LPS=lcs_2(X, m);
		int res=m-LPS;

		System.out.println("Minimum deletion required for Palindromic Subsequence is"+res);
	}

	//Minimum deletion required is inversely proportional to longest palindromic subsequence
	//so find LPS and subtract length of LPS from total string length to get answer.
	//This is same as minimum insertion to make a palindrome
	static int lcs_2(char[] X, int m) {
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
}
