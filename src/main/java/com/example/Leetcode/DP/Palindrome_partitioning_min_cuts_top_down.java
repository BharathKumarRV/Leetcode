package com.example.Leetcode.DP;

public class Palindrome_partitioning_min_cuts_top_down {

	public static int minPalPartion(String s) {
		int n = s.length();
		boolean dp[][] = new boolean[n][n];

		for (int g = 0; g < dp.length; g++) {
			for (int i = 0, j = g; j < dp.length; i++, j++) {
				if (g == 0) {
					dp[i][j] = true;
				} else if (g == 1) {
					dp[i][j] = s.charAt(i) == s.charAt(j);
				} else {
					if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
						dp[i][j] = true;
					} else {
						dp[i][j] = false;
					}
				}
			}
		}

		int strg[][] = new int[n][n];

		for (int g = 0; g < strg.length; g++) {
			for (int i = 0, j = g; j < strg.length; i++, j++) {
				if (g == 0) {
					strg[i][j] = 0;
				} else if (g == 1) {
					if (s.charAt(i) == s.charAt(j)) {
						strg[i][j] = 0;
					} else {
						strg[i][j] = 1;
					}
				} else {
					if (dp[i][j]) {
						strg[i][j] = 0;
					} else {
						int min = Integer.MAX_VALUE;
						for (int k = i; k < j; k++) {
							int left = strg[i][k];
							int right = strg[k + 1][j];
							int cuts = left + right + 1;
							if (cuts < min) {
								min = cuts;
							}

						}
						strg[i][j] = min;
					}
				}
			}

		}

		return strg[0][s.length() - 1];
	}

	public static void main(String args[]) {
		String str = "ababbbabbababa";
		System.out.println("Min cuts needed for " + "Palindrome Partitioning is " + minPalPartion(str));
	}
}
