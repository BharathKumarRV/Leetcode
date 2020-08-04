package com.example.Leetcode;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;

public class Longest_substring {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int res = lengthOfLongestSubstring("abcabcbb");
		System.out.println(res);

	}

	/*
	 * public static int lengthOfLongestSubstring(String s) {
	 * 
	 * int i = 0, j = 0, max = 0; Set<Character> set = new HashSet<>();
	 * 
	 * while (j < s.length()) { if (!set.contains(s.charAt(j))) {
	 * set.add(s.charAt(j++)); max = Math.max(max, set.size()); } else {
	 * set.remove(s.charAt(i++)); } }
	 * 
	 * return max;
	 * 
	 * }
	 */

	/*
	 * public static int lengthOfLongestSubstring(String s) { int left = 0, right =
	 * 0, max = 0; Set<Character> set = new HashSet<>(); while (right < s.length())
	 * { if (set.add(s.charAt(right))) { right++; max = Math.max(max, right - left);
	 * } else { set.remove(s.charAt(left++)); } } return max;
	 * 
	 * }
	 */

	/*
	 * public static int lengthOfLongestSubstring(String s) { Queue<Character> queue
	 * = new LinkedList<>(); int res = 0; for (char c : s.toCharArray()) { if
	 * (queue.contains(c)) { queue.poll(); } queue.offer(c); res = Math.max(res,
	 * queue.size()); } return res; }
	 */
	
	public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
	        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	        int max=0;
	        for (int i=0, j=0; i<s.length(); ++i){
	            if (map.containsKey(s.charAt(i))){
	                j = Math.max(j,map.get(s.charAt(i))+1);
	            }
	            map.put(s.charAt(i),i);
	            max = Math.max(max,i-j+1);
	        }
	        return max;
   }
}
