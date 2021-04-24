package com.example.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class Pascals_recursive {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		List<List<Integer>> res = generate(5);
		System.out.print(res);

	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<>();
		generate(list, numRows);
		return list;

	}

	public static void generate(List<List<Integer>> list, int numRows) {
		if (numRows == 1) {
			list.add(Arrays.asList(1));
			return;
		}
		generate(list, numRows - 1);
		List<Integer> previousList = list.get(numRows - 2);
		List<Integer> thisList = new ArrayList<>();
		for (int i = 0; i < previousList.size(); i++) {
			if (i == 0)
				thisList.add(1);
			if (i > 0)
				thisList.add(previousList.get(i) + previousList.get(i - 1));
			if (i == previousList.size() - 1)
				thisList.add(1);
		}
		list.add(thisList);
	}
}
