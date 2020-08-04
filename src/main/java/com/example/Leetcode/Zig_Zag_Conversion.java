package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Zig_Zag_Conversion {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		String res = convert("PAYPALISHIRING",4);
		System.out.println(res);

	}

	public static String convert(String s, int nRows) {

		//char[] c = s.toCharArray();
		int len = s.length();
		StringBuilder[] sb = new StringBuilder[nRows];
		for (int i = 0; i < sb.length; i++)
			sb[i] = new StringBuilder();

		int i = 0;
		while (i < len) {
			for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
				sb[idx].append(s.charAt(i++));
			for (int idx = nRows - 2; idx >= 1 && i < len; idx--) // obliquely up
				sb[idx].append(s.charAt(i++));
		}
		return String.join("", sb);

		/*
		 * for (int idx = 1; idx < sb.length; idx++) sb[0].append(sb[idx]); return
		 * sb[0].toString();
		 */
	}
}
