package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Reverse_words {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		// int[] nums= {4,1,2,1,2};
		String s = "  sky    blue  ";
		String res = reverseWords(s);
		System.out.println(res);

	}

	public static String reverseWords(String s) {
		if (s == null)
			return null;

		char[] a = s.toCharArray();
		int n = a.length;

		// step 1. reverse the whole string
		reverse(a, 0, n - 1);
		// step 2. reverse each word
		reverseWords(a, n);
		// step 3. clean up spaces
		return cleanSpaces(a, n);
	}

	static void reverseWords(char[] a, int n) {
		int i = 0, j = 0;

		while (i < n) {
			while (i < n && a[i] == ' ')
				i++; // skip spaces
			j=i+1;
			while (j < n && a[j] != ' ')
				j++; // skip non spaces
			reverse(a, i, j - 1); // reverse the word
			i=j+1;
		}
	}

	// trim leading, trailing and multiple spaces
	static String cleanSpaces(char[] a, int n) {
		int i = 0, j = 0;

		while (j < n) {
			while (j < n && a[j] == ' ')
				j++; // skip spaces
			while (j < n && a[j] != ' ')
				a[i++] = a[j++]; // keep non spaces
			/*
			 * while (j < n && a[j] == ' ') j++; // skip spaces
			 */			
			if (j < n)
				a[i++] = ' '; // keep only one space
		}

		return new String(a).substring(0, i);
	}

	// reverse a[] from a[i] to a[j]
	private static void reverse(char[] a, int i, int j) {
		while (i < j) {
			char t = a[i];
			a[i++] = a[j];
			a[j--] = t;
		}
	}
}
