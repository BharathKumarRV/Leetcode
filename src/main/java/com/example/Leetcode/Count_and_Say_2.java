package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Count_and_Say_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		String res = countAndSay(4);
		System.out.println(res);

	}

	public static String countAndSay(int n) {
		if (n == 1)
			return "1";
		String prev = countAndSay(n - 1);
		StringBuilder str = new StringBuilder();
		int i = 0;
		while (i < prev.length()) {
			char curr = prev.charAt(i);
			int j = 0;
			while (i + j < prev.length() && prev.charAt(i + j) == curr)
				j++;
			str.append(j);
			str.append(curr);
			i += j;
		}
		return str.toString();
	}
}
