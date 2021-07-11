package com.example.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Repeated_dna_sequences {

	public static void main(String[] args) {

		List<String> res = findRepeatedDnamap("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
		System.out.println(res);
	}

	/*
	 * public static List<String> findRepeatedDnaSequences(String s) { Set seen =
	 * new HashSet(), repeated = new HashSet(); for (int i = 0; i + 9 < s.length();
	 * i++) { String ten = s.substring(i, i + 10); if (!seen.add(ten))
	 * repeated.add(ten); } return new ArrayList(repeated); }
	 */

	//Time complexity of this approach is O(m*n) where m=length of string, n=
	public static List<String> findRepeatedDnamap(String s) {
		List<String> repeated = new ArrayList<String>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int i = 0;
		while (i + 10 <= s.length()) {
			String ten = s.substring(i, i + 10);
			i++;
			map.put(ten, map.getOrDefault(ten, 0) + 1);
			if (map.get(ten) == 2) {
				repeated.add(ten);
			}
		}
		return repeated;
	}
}
