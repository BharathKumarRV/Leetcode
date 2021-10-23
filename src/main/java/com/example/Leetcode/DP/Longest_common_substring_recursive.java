package com.example.Leetcode.DP;

import java.util.HashMap;

public class Longest_common_substring_recursive {

	static String X = "abcdxyz";
	static String Y = "xyzabcd";

	static int n = X.length();
	static int m = Y.length();

	public static void main(String[] args) {
		// int n, m;
		/*
		 * X = "abcdxyz"; Y = "xyzabcd";
		 */

		/*
		 * n = X.length(); m = Y.length();
		 */

		System.out.println(lcs(n, m, 0));

		//System.out.println(lcs(0, 0, 0));
	}

	public static int lcs(int i, int j, int count) {

		if (i == 0 || j == 0) {
			return count;
		}

		if (X.charAt(i - 1) == Y.charAt(j - 1)) {
			count = lcs(i - 1, j - 1, count + 1);
		}
		count = Math.max(count, Math.max(lcs(i, j - 1, 0), lcs(i - 1, j, 0)));// zero coz we have to start from zero
		return count;
	}

	public static int lcs_2(int i, int j, int count) {

		if (i >=n || j >=m) {
			return count;
		}

		int same = count;
		if (X.charAt(i) == Y.charAt(j)) {
			same = lcs_2(i + 1, j + 1, count + 1);
		}
		int res = Math.max(same, Math.max(lcs_2(i, j + 1, 0), lcs_2(i + 1, j, 0)));// zero coz we have to start from
															// zero
		return res;
	}

	public static int lcs_3(int i, int j, int count) {
		if (i >= X.length() || j >= Y.length())
			return count;

		int same = count;
		if (X.charAt(i) == Y.charAt(j)) {
			same = lcs_3(i + 1, j + 1, count + 1);
		}
		int diff1 = lcs_3(i, j + 1, 0);
		int diff2 = lcs_3(i + 1, j, 0);
		int res = Math.max(same, Math.max(diff1, diff2));
		return res;
	}
}
