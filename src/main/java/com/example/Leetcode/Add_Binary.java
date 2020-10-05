package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Add_Binary {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		String res = addBinary("1010", "1011");
		System.out.println(res);
	}

	// 11 and 11
	public static String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1, j = b.length() - 1, carry = 0;
		while (i >= 0 || j >= 0) {
			int sum = carry;
			if (j >= 0)
				sum += b.charAt(j--) - '0';
			if (i >= 0)
				sum += a.charAt(i--) - '0';
			sb.append(sum % 2);
			carry = sum / 2;
		}
		if (carry != 0)
			sb.append(carry);
		return sb.reverse().toString();
	}
}
