package com.example.Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.springframework.boot.SpringApplication;

public class Longest_substring {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int res = lengthOfLongestSubstring_bruteforce("abcabcbb");
		System.out.println(res);

	}

	public static int lengthOfLongestSubstring_3(String s) {

		int i = 0, j = 0, max = 0;
		Set<Character> set = new HashSet<>();

		while (j < s.length()) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				max = Math.max(max, set.size());
			} else {
				set.remove(s.charAt(i++));
			}
		}

		return max;

	}

	public static int lengthOfLongestSubstring_2(String s) {
		int left = 0, right = 0, max = 0;
		Set<Character> set = new HashSet<>();
		while (right < s.length()) {
			if (set.add(s.charAt(right))) {
				right++;
				max = Math.max(max, right - left);
			} else {
				set.remove(s.charAt(left++));
			}
		}
		return max;

	}

	public static int lengthOfLongestSubstring_4(String s) {
		Queue<Character> queue = new LinkedList<>();
		int res = 0;
		for (char c : s.toCharArray()) {
			if (queue.contains(c)) {
				queue.poll();
			}
			queue.offer(c);
			res = Math.max(res, queue.size());
		}
		return res;
	}

	public static int lengthOfLongestSubstring(String s) {
		if (s.length() == 0)
			return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		for (int i = 0, j = 0; i < s.length(); ++i) {
			if (map.containsKey(s.charAt(i))) {
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i - j + 1);
		}
		return max;
	}

	public static int lengthOfLongestSubstring_5(String s) {
		if (s.length() == 0)
			return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		int left = 0, right = 0;
		while (right < s.length()) {
			if (map.containsKey(s.charAt(right))) {
				left = Math.max(left, map.get(s.charAt(right)) + 1);
			}
			map.put(s.charAt(right), right);
			max = Math.max(max, right - left + 1);
		    right++;
		}
		return max;
	}
	
	public static int lengthOfLongestSubstring_bruteforce(String s) {
        // prepare for final int
        int ans = 0;
        
        // check for extreme condition
        if (s == null || s.length() == 0) {
            return ans;
        }
        if (s.length() == 1) {
            return 1;
        }
        
        int n = s.length();
        ans = 1;
        
        for (int i = 0; i < n; i++) {
            HashSet<Character> set = new HashSet<> ();
            set.add(s.charAt(i));
            int record_num = 1;
            for (int j = i+1; j < n; j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                }
                
                set.add(s.charAt(j));
                record_num += 1;
                
                ans = Math.max(ans, record_num);
            }
        }
        
        return ans;
    }
}
