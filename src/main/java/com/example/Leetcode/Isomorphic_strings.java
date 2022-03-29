package com.example.Leetcode;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;

public class Isomorphic_strings {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		boolean res = isIsomorphic_3("egg", "add");
		System.out.println(res);

	}

	public static boolean isIsomorphic_3(String s, String t) { // 用hashmap存储一对一的关系
		HashMap<Character, Character> map = new HashMap<>();
		int size = s.length();
		for (int i = 0; i < size; i++) {
			if (map.containsKey(s.charAt(i))) {
				if (t.charAt(i) != map.get(s.charAt(i))) {
					return false;
				}
			} else {
				if (map.containsValue(t.charAt(i))) {
					return false;
				}
				map.put(s.charAt(i), t.charAt(i));
			}
		}
		return true;
	}

	public static boolean isIsomorphic_2(String s, String t) {
		int[] map = new int[128];
		int[] book = new int[128];
		for (int i = 0; i < s.length(); i++) {
			int cs = (int) s.charAt(i);
			int ts = (int) t.charAt(i);
			if (map[cs] == 0 && book[ts] == 0) {
				map[cs] = ts;
				book[ts] = 1;
			} else if (map[cs] != ts)
				return false;
		}
		return true;
	}

	public static boolean isIsomorphic(String s, String t) {
		int[] m1 = new int[256];
		int[] m2 = new int[256];
		int n = s.length();
		int count = 1;
		for (int i = 0; i < n; i++) {
			if (m1[s.charAt(i)] != m2[t.charAt(i)])
				return false;
			m1[s.charAt(i)] = count;
			m2[t.charAt(i)] = count;
			count++;
		}
		return true;
	}
}
