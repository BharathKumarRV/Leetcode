package com.example.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Repeated_dna_sequences_rolling_hm {

	public static void main(String[] args) {

		List<String> res = findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
		System.out.println(res);
	}

	private static final Map<Character, Integer> A = new HashMap<>();
	
	static {
		A.put('A', 0);
		A.put('C', 1);
		A.put('G', 2);
		A.put('T', 3);
	}
	private static final int A_SIZE_POW_9 = (int) Math.pow(A.size(), 9);

	public static List<String> findRepeatedDnaSequences(String s) {
		Set<String> res = new HashSet<>();
		Set<Integer> hashes = new HashSet<>();
		for (int i = 0, rhash = 0; i < s.length(); i++) {
			if (i > 9)
				rhash -= A_SIZE_POW_9 * A.get(s.charAt(i - 10));
			rhash = A.size() * rhash + A.get(s.charAt(i));
			if (i > 8 && !hashes.add(rhash))
				res.add(s.substring(i - 9, i + 1));
		}
		return new ArrayList<>(res);
	}
}
