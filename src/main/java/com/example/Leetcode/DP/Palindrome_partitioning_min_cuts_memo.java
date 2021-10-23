package com.example.Leetcode.DP;

public class Palindrome_partitioning_min_cuts_memo {

	static boolean isPalindrome(String string, int i, int j) {
		while (i < j) {
			if (string.charAt(i) != string.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	static int minPalPartion(String string, int i, int j, int dp[][]) {
		if (i >= j || isPalindrome(string, i, j))
			return 0;
		int ans = Integer.MAX_VALUE;
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		for (int k = i; k < j; k++) {
			int count = minPalPartion(string, i, k, dp) + minPalPartion(string, k + 1, j, dp) + 1;

			ans = Math.min(ans, count);
		}
		return dp[i][j] = ans;
	}

	static int minPalPartion_2(String string, int i, int j, int dp[][]) {
		if (i >= j || isPalindrome(string, i, j))
			return 0;
		int ans = Integer.MAX_VALUE;
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		int left, right;
		for (int k = i; k < j; k++) {

			if (dp[i][k] != -1) {
				left = dp[i][k];
			} else {
				left = minPalPartion(string, i, k, dp);
			}
			if (dp[k + 1][j] != -1) {
				right = dp[k + 1][j];
			} else {
				right = minPalPartion(string, k + 1, j, dp);
			}
			int count = left + right + 1;

			ans = Math.min(ans, count);
		}
		return dp[i][j] = ans;
	}

	// Driver code
	public static void main(String args[]) {
		String str = "ababbbabbababa";
		int n = str.length();
		int dp[][] = new int[n + 1][n + 1];

		// Loop to initially filled the
		// table with -1
		for (int i = 0; i < n + 1; i++)
			for (int j = 0; j < n + 1; j++)
				dp[i][j] = -1;

		System.out.println(
				"Min cuts needed for " + "Palindrome Partitioning is " + minPalPartion_2(str, 0, str.length() - 1, dp));
	}
}
