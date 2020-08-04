package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Zig_Zag_Conversion_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		String res = convert("PAYPALISHIRING", 4);
		System.out.println(res);

	}

	public static String convert(String s, int numRows) {
		if (numRows <= 1)
			return s;
		StringBuilder[] sb = new StringBuilder[numRows];
		for (int i = 0; i < sb.length; i++) {
			sb[i] = new StringBuilder(""); // init every sb element **important step!!!!
		}
		int incre = 1;
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			sb[index].append(s.charAt(i));
			if (index == 0) {
				incre = 1;
			}
			if (index == numRows - 1) {
				incre = -1;
			}
			index += incre;
		}
		String re = "";
		for (int i = 0; i < sb.length; i++) {
			re += sb[i];
		}
		return re.toString();
	}

}
