package com.example.Leetcode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class Word_break_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 4, 1, 2, 1, 2 };
		//String s="catsandog";
		String s="leetcode";
		List<String> dict= new ArrayList<>();
		//dict.add("cats");
		//dict.add("dog");
		//dict.add("sand");
		//dict.add("and");
		//dict.add("cat");
		dict.add("leet");
		dict.add("code");
		boolean res = wordBreak(s,dict);
		System.out.println(res);

	}
	
	 public static boolean wordBreak(String s, List<String> wordDict) {
	        boolean[] isWordBreak = new boolean[s.length() + 1];
	        
	        isWordBreak[0] = true;
	        
	        for (int i = 0; i < s.length() + 1; i++) {
	            for (int j = 0; j < i; j++) {
	                if (!isWordBreak[j]) {
	                    continue;
	                }
	                
	                if (wordDict.contains(s.substring(j, i))) {
	                    isWordBreak[i] = true;
	                    break;
	                }
	            }
	        }
	        
	        return isWordBreak[s.length()];
	    }
}
