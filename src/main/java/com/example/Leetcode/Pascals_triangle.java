package com.example.Leetcode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class Pascals_triangle {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		List<List<Integer>> res = generate_2(5);
		System.out.print(res);

	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> allrows = new ArrayList<List<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		for (int i = 0; i < numRows; i++) {
			row.add(0, 1);
			for (int j = 1; j < row.size() - 1; j++)
				row.set(j, row.get(j) + row.get(j + 1));
			allrows.add(new ArrayList<Integer>(row));
		}
		return allrows;

	}

	//Go through this
	public static List<List<Integer>> generate_2(int numRows) {
		List<List<Integer>> allrows = new ArrayList<List<Integer>>();
		ArrayList<Integer> row, pre = null;
		for (int i = 0; i < numRows; i++) {
			row = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					row.add(1);
				} else {
					row.add(pre.get(j - 1) + pre.get(j));
				}
			}

			pre = row;
			allrows.add(row);

		}
		return allrows;

	}
}
