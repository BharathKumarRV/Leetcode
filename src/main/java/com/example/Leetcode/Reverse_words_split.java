package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Reverse_words_split {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		// int[] nums= {4,1,2,1,2};
		String s = " $$ __ ";
		String res = reverseWords(s);
		System.out.println(res);

	}
	
	/*
	 * public String reverseWords(String s) { String[] words = s.trim().split(" +");
	 * Collections.reverse(Arrays.asList(words)); return String.join(" ", words); }
	 */

	public static String reverseWords(String s) {
		StringBuilder sb = new StringBuilder();
		if (s == null || s.length() == 0)
			return sb.toString();

		// If string only contains special characters then empty string is returned.
		String reg = "[^a-zA-Z0-9]+";
		if (s.matches(reg))
			return sb.toString();

		// Removing the end spaces using the trim and split("\\s+") to remove bunnch of
		// consistent white spaces.
		String[] str = s.trim().split("\\s+");
		for (int i = str.length - 1; i >= 0; i--) {
			sb.append(str[i]);
			sb.append(" ");
		}
		// To remove the last the " " provided to the function
		return sb.toString().trim();
	}
	
	 public String reverseWords_2(String s) {
		    String result = new String();
		    int i = 0;
		    int n = s.length();

		    while(i < n){
		        while(i < n && s.charAt(i) == ' ') i++;
		        if(i >= n) break;
		        int j = i + 1;
		        while(j < n && s.charAt(j) != ' ') j++;
		        String sub = s.substring(i, j);
		        if(result.length() == 0) result = sub;
		        else result = sub + " " + result;
		        i = j+1;
		    }
		    return result;
		}
}
