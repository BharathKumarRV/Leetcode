package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Add_Binary_recursion {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		String res = addBinary("1010", "1011");
		System.out.println(res);
	}
	
	

	public static String addBinary(String a, String b) {
		if (a == null || a.isEmpty() || b == null || b.isEmpty())
			return "";
		return addBinaryRec(a, b, a.length() - 1, b.length() - 1, 0);
	}

	private static String addBinaryRec(String a, String b, int aIdx, int bIdx, int carry) {
		if (aIdx < 0 && bIdx < 0 && carry == 0)
			return "";

		int aVal = aIdx >= 0 ? a.charAt(aIdx) - '0' : 0;
		int bVal = bIdx >= 0 ? b.charAt(bIdx) - '0' : 0;

		int sum = aVal + bVal + carry;
		int val = sum % 2;
		int newCarry = sum / 2;

		return addBinaryRec(a, b, aIdx - 1, bIdx - 1, newCarry) + val;
	}

}
