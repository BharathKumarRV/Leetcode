package com.example.Leetcode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class Gray_code {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		List<Integer> res = grayCode(2);
		System.out.print(res);

	}

	public static List<Integer> grayCode(int n) {
		List<Integer> rs = new ArrayList<Integer>();
		rs.add(0);
		for (int i = 0; i < n; i++) {
			int size = rs.size();
			for (int k = size - 1; k >= 0; k--)
				rs.add(rs.get(k) | 1 << i); // put a "1" in the "head" of the old number. (e.g. make "101" to be 1101
											// (101 | 1000 == 1101))
		}
		return rs;
	}
}
