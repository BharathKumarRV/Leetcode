package com.example.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.boot.SpringApplication;

public class Word_break_2_dp {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 4, 1, 2, 1, 2 };
		String s="catsanddog";
		Set<String> dict= new HashSet<>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		List<String> res = wordBreak(s,dict);
		System.out.println(res);

	}
	
	public static List<String> wordBreak(String s, Set<String> wordDict) {
	    List<String> rst = new ArrayList<>();
	    if (s == null || s.length() == 0 || wordDict == null) {
	        return rst;
	    }
	    
	    boolean[] canBreak = new boolean[s.length()];
	    Arrays.fill(canBreak, true);
	    StringBuilder sb = new StringBuilder();
	    dfs(rst, sb, s, wordDict, canBreak, 0);
	    return rst;
	}

	private static  void dfs(List<String> rst, StringBuilder sb, String s, Set<String> dict, 
	    boolean[] canBreak, int start) {
	    if (start == s.length()) {
	        rst.add(sb.substring(1));
	        return;
	    }
	    
	    if (!canBreak[start]) {
	        return;
	    }
	    
	    for (int i = start + 1; i <= s.length(); i++) {
	        String word = s.substring(start, i);
	        if (!dict.contains(word)) continue;
	        
	        int sbBeforeAdd = sb.length();
	        sb.append(" " + word);
	        
	        int rstBeforeDFS = rst.size();
	        dfs(rst, sb, s, dict, canBreak, i);
	        if (rst.size() == rstBeforeDFS) {
	            canBreak[i] = false;
	        }
	        sb.delete(sbBeforeAdd, sb.length());
	    }
	}

	private int getMaxLen(Set<String> wordDict) {
	    int max = 0;
	    for (String s : wordDict) {
	        max = Math.max(max, s.length());
	    }
	    return max;
	}
}
