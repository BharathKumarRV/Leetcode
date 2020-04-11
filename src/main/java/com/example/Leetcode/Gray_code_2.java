package com.example.Leetcode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class Gray_code_2 {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); List<Integer> res =
	 * grayCode(3); System.out.print(res);
	 * 
	 * }
	 */

	public static List<Integer> grayCode(int n) {
		List<Integer> list = new ArrayList<>();
		list.add(0);
		if (n == 0)
			return list;
		list.add(1);
		int curr = 1;
		for (int i = 2; i <= n; i++) {
			curr *= 2;
			int len = list.size();
			for (int j = len - 1; j >= 0; j--) {
				list.add(curr + list.get(j));
			}
		}
		return list;
	}
}
