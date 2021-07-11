package com.example.Leetcode;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;

public class Longest_substring_k_distinct_characters {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int res = Longest_substring_k_distinct_character("abcabcbb",2);
		System.out.println(res);

	}

	public static int Longest_substring_k_distinct_character(String str, int k) {
		int ans = 0;
		int i = -1, j = -1;

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		while (true) {
			boolean f1 = false;
			boolean f2 = false;

			while (i < str.length() - 1) {
				f1=true;
				i++;
				char ch = str.charAt(i);
				map.put(ch, map.getOrDefault(ch,0)+1);

				if (map.size() < k) {
					continue;
				} else if (map.size() == k) {
					int len = i - j;
					if (len > ans) {
						ans = len;
					}
				} else {
					break;
				}
			}

			while (j < i) {
				f2=true;
				j++;
				char ch = str.charAt(j);

				if (map.get(ch) == 1) {
					map.remove(ch);
				} else {
					map.put(ch, map.get(ch) - 1);
				}
				
				if (map.size() < k) {
					continue;
				} else if (map.size() == k) {
					int len = i - j;
					if (len > ans) {
						ans = len;
					}
					break;
				}
			}
			
			if(f1==false && f2==false) {
				break;
			}
		}
		
		return ans;

	}

}
