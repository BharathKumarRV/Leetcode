package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Lastword_length {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); int res =
	 * lengthOfLastWord("     "); System.out.println(res);
	 * 
	 * }
	 */

	public static int lengthOfLastWord(String s) {

		if (s == null || s.length() == 0)
			return 0;
		int end = s.length() - 1;
		while (end >= 0 && s.charAt(end) == ' ')
			end--;
		if (end == -1)
			return 0;
		int start = end;
		while (start >= 0 && s.charAt(start) != ' ')
			start--;
		return end - start;
	}

}
