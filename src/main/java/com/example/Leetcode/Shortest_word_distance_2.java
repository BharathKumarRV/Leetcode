package com.example.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.boot.SpringApplication;

public class Shortest_word_distance_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		String[] list = { "practice", "makes", "men", "practice" };
		Shortest_word_distance_2 s1 = new Shortest_word_distance_2(list);
		int res = shortest("practice", "men");
		System.out.println(res);

		String[] list2 = { "Nothing", "is", "impossible" };
		Shortest_word_distance_2 s2 = new Shortest_word_distance_2(list2);
		int res2 = shortest("Nothing", "impossible");
		System.out.println(res2);

	}

	static HashMap<String, ArrayList<Integer>> map;

	public Shortest_word_distance_2() {

	}

	public Shortest_word_distance_2(String[] words) {
		map = new HashMap<String, ArrayList<Integer>>();
		for (int i = 0; i < words.length; i++) {
			if (map.containsKey(words[i])) {
				map.get(words[i]).add(i);
			} else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(words[i], list);
			}
		}
	}

	public static int shortest(String word1, String word2) {

		ArrayList<Integer> l1 = map.get(word1);
		ArrayList<Integer> l2 = map.get(word2);

		int result = Integer.MAX_VALUE;
		for (int i1 : l1) {
			for (int i2 : l2) {
				result = Math.min(result, Math.abs(i1 - i2));
			}
		}
		return result;
	}

	/*
	 * public static int shortest(String word1, String word2) {
	 * 
	 * ArrayList<Integer> l1 = map.get(word1); ArrayList<Integer> l2 =
	 * map.get(word2);
	 * 
	 * int result = Integer.MAX_VALUE; int i = 0; int j = 0; while (i < l1.size() &&
	 * j < l2.size()) { result = Math.min(result, Math.abs(l1.get(i) - l2.get(j)));
	 * if (l1.get(i) < l2.get(j)) { i++; } else { j++; } }
	 * 
	 * return result; }
	 */
}
