package com.example.Leetcode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class Pascals_2 {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); List<Integer>
	 * res=getRow(3); System.out.print(res);
	 * 
	 * }
	 */

	public static List<Integer> getRow(int rowIndex) {
		List<Integer> ret = new ArrayList<Integer>();
		ret.add(1);
		for (int i = 1; i <= rowIndex; i++) {
			for (int j = i - 1; j >= 1; j--) {
				int tmp = ret.get(j - 1) + ret.get(j);
				ret.set(j, tmp);
			}
			ret.add(1);
		}
		return ret;
	}
}
