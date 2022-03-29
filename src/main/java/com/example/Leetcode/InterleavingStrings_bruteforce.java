package com.example.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class InterleavingStrings_bruteforce {

	public static void main(String[] args) {
		String a = "aa";
		String b = "bb";
		String c = "aabb";
		boolean res = isInterleave(a, b, c);
		System.out.print(res);

	}

	private static boolean isInterleaving(String a, String b, String c) {
		if (a.isEmpty() && b.isEmpty() && c.isEmpty())
			return true;

		if (!a.isEmpty() && a.charAt(0) == c.charAt(0) && isInterleaving(a.substring(1), b, c.substring(1))) {
			return true;
		}
		if (!b.isEmpty() && b.charAt(0) == c.charAt(0) && isInterleaving(a, b.substring(1), c.substring(1))) {
			return true;
		}

		return false;
	}

	public static boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length())
			return false;
		return isInterleaving(s1, s2, s3);
	}
}
