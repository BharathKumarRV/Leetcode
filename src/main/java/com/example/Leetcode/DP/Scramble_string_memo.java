package com.example.Leetcode.DP;

import java.util.HashMap;
import java.util.Map;

public class Scramble_string_memo {

	// Driver code
	static Map<String, Boolean> map = new HashMap<String, Boolean>();

	public static void main(String args[]) {
		System.out.println(isScramble_2("great", "eatgr"));
	}

	public static boolean isScramble(String s1, String s2) {
		int len1 = s1.length(), len2 = s2.length();
		if (len1 != len2)
			return false;
		if (len1 == 0)
			return true;
		String key = s1 + "-" + s2;
		if (map.containsKey(key)) {
			return map.get(key);
		}
		// pruning
		if (s1.equals(s2))
			return true;
		int[] count = new int[26];
		for (int i = 0; i < len1; i++) {
			count[s1.charAt(i) - 'a']++;
			count[s2.charAt(i) - 'a']--;
		}
		for (int i = 0; i < len1; i++) {
			if (count[s1.charAt(i) - 'a'] != 0)
				return false;
		}
		boolean flag = false;
		for (int i = 1; i < len1; i++) {
			if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))// no
																													// swap
				flag = true;
			if (isScramble(s1.substring(0, i), s2.substring(len1 - i))
					&& isScramble(s1.substring(i), s2.substring(0, len1 - i)))// swap
				flag = true;
		}
		map.put(key, flag);
		return map.get(key);
	}

	public static boolean isScramble_2(String s1, String s2) {
		int len1 = s1.length(), len2 = s2.length();
		if (len1 != len2)
			return false;
		if (len1 < 0 || len2 < 1)
			return false;
		String key = s1 + "-" + s2;
		if (map.containsKey(key)) {
			return map.get(key);
		}
		// pruning
		if (s1.equals(s2))
			return true;
		boolean flag = false;
		for (int i = 1; i < len1; i++) {
			if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))// no
																													// swap
				flag = true;
			if (isScramble(s1.substring(0, i), s2.substring(len1 - i))
					&& isScramble(s1.substring(i), s2.substring(0, len1 - i)))// swap
				flag = true;
		}
		map.put(key, flag);
		return map.get(key);
	}

}
