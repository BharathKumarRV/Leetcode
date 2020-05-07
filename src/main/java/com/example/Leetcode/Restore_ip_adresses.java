package com.example.Leetcode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class Restore_ip_adresses {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); List<String> res =
	 * restoreIpAddresses("25525511135"); System.out.print(res);
	 * 
	 * }
	 */

	public static List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<>();

		int n = s.length();

		for (int i = 1; i < n && i < 4; i++) {
			String first = s.substring(0, i);
			if (!isValid(first))
				continue;
			for (int j = 1; i + j < n && j < 4; ++j) {
				String second = s.substring(i, i + j);
				if (!isValid(second))
					continue;
				for (int k = 1; i + j + k < n && k < n; ++k) {
					String third = s.substring(i + j, i + j + k);
					String fourth = s.substring(i + j + k);
					if (!isValid(third) || !isValid(fourth))
						continue;
					res.add(first + "." + second + "." + third + "." + fourth);
				}
			}
		}
		return res;
	}

	public static boolean isValid(String s) {
		if (s.length() > 3)
			return false;
		// 0 is valid but 00,01,000 are not valid
		if (s.startsWith("0") && s.length() > 1)
			return false;
		int val = Integer.parseInt(s);

		return val >= 0 && val <= 255;

	}
}
