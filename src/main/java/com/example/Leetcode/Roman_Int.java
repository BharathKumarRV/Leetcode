package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Roman_Int {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int res = romanToInt("IX");
		System.out.println(res);

	}

	public static int romanToInt(String s) {
		int res = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			switch (c) {
			case 'I':
				res += (res >= 5 ? -1 : 1);
				break;
			case 'V':
				res += 5;
				break;
			case 'X':
				res += 10 * (res >= 50 ? -1 : 1);
				break;
			case 'L':
				res += 50;
				break;
			case 'C':
				res += 100 * (res >= 500 ? -1 : 1);
				break;
			case 'D':
				res += 500;
				break;
			case 'M':
				res += 1000;
				break;
			}
		}
		return res;

	}

}
