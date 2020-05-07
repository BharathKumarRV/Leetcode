package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Is_Palindrome_2 {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); String s=
	 * "A man, a plan, a canal: Panama"; boolean res = isPalindrome(s);
	 * System.out.print(res);
	 * 
	 * }
	 */

	 public static boolean isPalindrome(String s) {
	        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
	        String rev = new StringBuffer(actual).reverse().toString();
	        return actual.equals(rev);
	    }
}
