package com.example.Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.SpringApplication;

public class Decode_ways_without_dp {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); int res =
	 * numDecodings("226"); System.out.print(res);
	 * 
	 * }
	 */

	public static int numDecodings(String s) {

		if (s == null || s.length() == 0)
			return 0;

		Set<String> symbols = new HashSet<String>();
		for (int i = 1; i <= 26; i++) {
			symbols.add(String.valueOf(i));
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		return numDec(s, 0, map, symbols);
	}

	private static int numDec(String str, int start, Map<Integer, Integer> map, Set<String> symbols) {
		Integer count = map.get(start);
		if (count != null) {
			return count;
		}

		if (start == str.length()) {
			return 1;
		}

		int numWays = 0;
		if ((start + 1 <= str.length()) && symbols.contains(str.substring(start, start + 1)))
			numWays += numDec(str, start + 1, map, symbols);

		if ((start + 2 <= str.length()) && symbols.contains(str.substring(start, start + 2)))
			numWays += numDec(str, start + 2, map, symbols);

		map.put(start, numWays);

		return numWays;
	}
}
