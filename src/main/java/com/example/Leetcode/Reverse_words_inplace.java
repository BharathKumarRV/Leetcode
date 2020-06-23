package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Reverse_words_inplace {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		// int[] nums= {4,1,2,1,2};
		String s = "  sky    blue  ";
		String res = reverseWords(s);
		System.out.println(res);

	}
	
	public static String reverseWords(String s) {
		if (s.length() < 1)
			return s; // empty string
		int fillIdx = 0;
		char[] str = s.toCharArray();
		
		// reverse whole string
		reverse(str, 0, str.length - 1);
		// reverse word one by one
		for (int i = 0; i < str.length; i++) {
			//skipping leading and trailing spaces
			if (str[i] == ' ') {
				continue;
			}
			//space between each words
			if (fillIdx != 0) {
				str[fillIdx++] = ' ';
			}
			int nowStartIdx = fillIdx; //nowStartIdx -> start of each word
			while(i < str.length && str[i] != ' ') {
				str[fillIdx++] = str[i++];
			}
			reverse(str, nowStartIdx, fillIdx-1);
		}
		return new String(str, 0, fillIdx);
	}
	
	private static void reverse(char[] a, int i, int j) {
		while (i < j) {
			char t = a[i];
			a[i++] = a[j];
			a[j--] = t;
		}
	}
}
