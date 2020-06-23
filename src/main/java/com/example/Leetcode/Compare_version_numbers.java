package com.example.Leetcode;

import java.util.List;

public class Compare_version_numbers {

	public static void main(String[] args) {
		int res = compareVersion("7.5.2.4", "7.5.3");
		System.out.println(res);
	}

	public static int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int n = Math.max(v1.length, v2.length);
		for (int i = 0; i < n; i++) {
			int k = i < v1.length ? Integer.parseInt(v1[i]) : 0;
			int j = i < v2.length ? Integer.parseInt(v2[i]) : 0;
			if (k > j)
				return 1;
			else if (k < j)
				return -1;
			else
				continue;
		}
		return 0;
	}
	
	/*
	 * public static int compareVersion(String version1, String version2) { String[]
	 * v1 = version1.split("\\."); String[] v2 = version2.split("\\."); int n =
	 * Math.max(v1.length, v2.length); for (int i = 0; i < n; i++) { Integer k = i <
	 * v1.length ? Integer.parseInt(v1[i]) : 0; Integer j = i < v2.length ?
	 * Integer.parseInt(v2[i]) : 0; int compare = k.compareTo(j); if (compare != 0)
	 * { return compare; } } return 0; }
	 */
}
