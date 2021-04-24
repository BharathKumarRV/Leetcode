package com.example.Leetcode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class Restore_ip_addresses {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		List<String> res = restoreIpAddresses("25525");
		System.out.print(res);

	}

	public static List<String> restoreIpAddresses(String s) {
		List<String> allIpAdresses = new ArrayList<>();
		int path[] = new int[4];
		snapshotIP(allIpAdresses, s, 0, path, 0);
		return allIpAdresses;
	}

	public static void snapshotIP(List<String> allIpAdresses, String s, int buildIndex, int[] path, int segment) {

		if (segment == 4 && buildIndex == s.length()) {
			allIpAdresses.add(path[0] + "." + path[1] + "." + path[2] + "." + path[3]);
			return;
		} else if (segment == 4 || buildIndex == s.length()-1) {
			return;
		}

		for (int len = 1; len <= 3 && buildIndex + len <=s.length(); len++) {
			String snapshot = s.substring(buildIndex, buildIndex + len);
			int val = Integer.parseInt(snapshot);
			if (val > 255 || len >= 2 && s.charAt(buildIndex) == '0') {
				return;
			}
			path[segment] = val;
			snapshotIP(allIpAdresses, s, buildIndex + len, path, segment + 1);
			path[segment] = -1;
		}
	}
}
