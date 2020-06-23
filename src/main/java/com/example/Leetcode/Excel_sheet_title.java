package com.example.Leetcode;

public class Excel_sheet_title {

	public static void main(String[] args) {
		String res = convertToTitle(26);
		System.out.println(res);

	}

	/*
	 * public static String convertToTitle(int n) { StringBuilder result = new
	 * StringBuilder();
	 * 
	 * while (n > 0) { n--; char toAdd = (char) ((n % 26) + 65); result.insert(0,
	 * toAdd); n /= 26; }
	 * 
	 * return result.toString(); }
	 */

	public static String convertToTitle(int n) {
		return n == 0 ? "" : convertToTitle(--n / 26) + (char) ('A' + (n % 26));
	}
}
