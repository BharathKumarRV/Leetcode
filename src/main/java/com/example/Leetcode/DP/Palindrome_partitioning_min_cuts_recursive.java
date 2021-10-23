package com.example.Leetcode.DP;

public class Palindrome_partitioning_min_cuts_recursive {

	static boolean isPalindrome(String string, int i, int j) {
		while (i < j) {
			if (string.charAt(i) != string.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	static int minPalPartion(String string, int i, int j) {
		if (i >= j || isPalindrome(string, i, j))
			return 0;
		int ans = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int count = minPalPartion(string, i, k) + minPalPartion(string, k + 1, j) + 1;

			ans = Math.min(ans, count);
		}
		return ans;
	}

	// Driver code
	public static void main(String args[]) {
		String str = "ababbbabbababa";
		System.out.println(
				"Min cuts needed for " + "Palindrome Partitioning is " + minPalPartion(str, 0, str.length() - 1));
	}
}
