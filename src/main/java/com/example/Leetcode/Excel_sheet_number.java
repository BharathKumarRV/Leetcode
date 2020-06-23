package com.example.Leetcode;

public class Excel_sheet_number {

	public static void main(String[] args) {
		int res = titleToNumber("AB");
		System.out.println(res);

	}

	public static int titleToNumber(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			result = result * 26;
			result += s.charAt(i) - 'A' + 1;
		}
		return result;
	}
}
