package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Shortest_word_distance {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		String[] list = { "practice", "makes", "men", "practice" };
		int res = shortestDistance(list, "practice", "men");
		System.out.println(res);

	}

	public static int shortestDistance(String[] words, String word1, String word2) {
		int m = -1;
		int n = -1;

		int min = Integer.MAX_VALUE;

		for (int i = 0; i < words.length; i++) {
			String s = words[i];
			if (word1.equals(s)) {
				m = i;
				if (n != -1)
					min = Math.min(min, m - n);
			} else if (word2.equals(s)) {
				n = i;
				if (m != -1)
					min = Math.min(min, n - m);
			}
		}

		return min;
	}
}
