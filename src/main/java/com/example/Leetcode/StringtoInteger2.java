package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class StringtoInteger2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int res = myAtoi("   -42");
		System.out.println(res);

	}

	public static int myAtoi(String str) {
		if (str == null || str.length() == 0)
			return 0;
		int start = 0, sign = 1, base = 0;
		while (str.charAt(start) == ' ') {
			start++;
		}
		if (str.isEmpty()) {
			return 0;
		}
		if (str.charAt(start) == '-' || str.charAt(start) == '+') {
			sign = (str.charAt(start) == '-' ? -1 : 1);
			start++;
		}
		// why we're doing str[i] - '0 > 7 in particular?
		// INT_MAX == 2147482647; Attention the last number is 7;
		// When base == INT_MAX / 10 and current str[i] is bigger than '7', overflow!
		// Integer.MAX_VALUE % 10 yeilds 7
		while (start < str.length() && str.charAt(start) >= '0' && str.charAt(start) <= '9') {
			if (base > Integer.MAX_VALUE / 10
					|| (base == Integer.MAX_VALUE / 10 && (str.charAt(start) - '0' > Integer.MAX_VALUE % 10))) {
				return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			base = base * 10 + (str.charAt(start++) - '0');
		}
		return base * sign;
	}
}
