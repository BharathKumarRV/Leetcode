package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Longestcommonprefix {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		String[] strs= {"flow","flower","flight"};
		String res=longestCommonPrefix(strs);
		System.out.println(res);
		
	}
	
	public static String longestCommonPrefix1(String[] strs) {
	    if (strs.length == 0) return "";
	    String pre = strs[0];
	    for (int i = 1; i < strs.length; i++)
	        while(strs[i].indexOf(pre) != 0)
	            pre = pre.substring(0,pre.length()-1);
	    return pre;
	}
	
	public static String longestCommonPrefix(String[] strs) {
	    if (strs.length == 0) return "";
	    String pre = strs[0];
	    for (int i = 1; i < strs.length; i++)
	        while(!strs[i].startsWith(pre)) // It returns true if the str[i] begins with pre, 
	            pre = pre.substring(0,pre.length()-1);
	    return pre;
	}
}
