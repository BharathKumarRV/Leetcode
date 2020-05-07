package com.example.Leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.springframework.boot.SpringApplication;

public class Word_break_bfs {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums = { 4, 1, 2, 1, 2 };
		String s="catsandog";
		Set<String> dict= new HashSet<>();
		dict.add("cats");
		dict.add("dog");
		dict.add("sand");
		dict.add("and");
		dict.add("cat");
		boolean res = wordBreak(s,dict);
		System.out.println(res);

	}
	
	public static boolean wordBreak(String s, Set<String> dict) {
	    if (dict.contains(s)) return true;
	    Queue<Integer> queue = new LinkedList<Integer>();
	    queue.offer(0);
	    // use a set to record checked index to avoid repeated work.
	    // This is the key to reduce the running time to O(N^2).
	    Set<Integer> visited = new HashSet<Integer>();
	    visited.add(0);
	    while (!queue.isEmpty()) {
	        int curIdx = queue.poll();
	        for (int i = curIdx+1; i <= s.length(); i++) {
	            if (visited.contains(i)) continue;
	            if (dict.contains(s.substring(curIdx, i))) {
	                if (i == s.length()) return true;
	                queue.offer(i);
	                visited.add(i);
	            }
	        }
	    }
	    return false;
	}
}
