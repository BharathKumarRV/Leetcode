package com.example.Leetcode;

import java.util.Arrays;

public class Edit_distance_memo {

	public static void main(String args[]) {
		String str1 = "abc";
		String str2 = "bcd";

		int m = str1.length();
		int n = str2.length();
		int dp[][] = new int[m+1][n+1];


		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				dp[i][j] = -1;
			}
		}

		System.out.println(editDist(m, n, str1, str2, dp));
		//System.out.println(editDist_2(0, 0, str1, str2, dp));
	}

	public static int editDist(int i, int j, String s1, String s2, int dp[][]) {
		if (i == 0)
			return j;

		if (j == 0)
			return i;

		if (dp[i][j] != -1)
			return dp[i][j];

		if (s1.charAt(i-1) == s2.charAt(j-1)) {
			return dp[i][j] = editDist(i - 1, j - 1, s1, s2, dp);
		}

		else { // if both are not same;
			int left = 1 + editDist(i, j - 1, s1, s2, dp); // insert
			int mid = 1 + editDist(i - 1, j, s1, s2, dp); // remove
			int right = 1 + editDist(i - 1, j - 1, s1, s2, dp); // replace
			return dp[i][j] = Math.min(left, Math.min(mid, right));
		}
	}

	public static int editDist_2(int i, int j, String s1, String s2, int dp[][]) {
		if (i == s1.length())
			return s2.length() - j;

		if (j == s2.length())
			return s1.length() - i;

		if (dp[i][j] != -1)
			return dp[i][j];

		if (s1.charAt(i) == s2.charAt(j)) {
			return dp[i][j] = editDist(i + 1, j + 1, s1, s2, dp);
		}

		else { // if both are not same;
			int left = 1 + editDist(i, j + 1, s1, s2, dp); // insert
			int mid = 1 + editDist(i + 1, j, s1, s2, dp); // remove
			int right = 1 + editDist(i + 1, j + 1, s1, s2, dp); // replace
			return dp[i][j] = Math.min(left, Math.min(mid, right));
		}
	}

}
