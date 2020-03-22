package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Lastword_length_2 {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); int res =
	 * lengthOfLastWord("Hello world"); System.out.println(res);
	 * 
	 * }
	 */

	//single line code
	//return s.trim().length()-s.trim().lastIndexOf(" ")-1;
	
	public static int lengthOfLastWord(String s) {

		int len = 0, tail = s.length() - 1;
		while (tail >= 0 && s.charAt(tail) == ' ')
			tail--;
		while (tail >= 0 && s.charAt(tail) != ' ') {
			len++;
			tail--;
		}
		return len;
	}
}
