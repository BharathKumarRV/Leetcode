package com.example.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class Triangle {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		List<List<Integer>> res = generate(5);
		System.out.print(res);

	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> slist = new ArrayList<>(Arrays.asList(-1));
		list.add(slist);
		List<Integer> slist1 = new ArrayList<>(Arrays.asList(2, 3));
		list.add(slist1);
		List<Integer> slist2 = new ArrayList<>(Arrays.asList(1, -1, -3));
		list.add(slist2);
		// List<Integer> slist3=new ArrayList<>(Arrays.asList(4,1,8,3));
		// list.add(slist3);

		int res = minimumTotal(list);
		System.out.println(res);
		return list;

	}

	public static int minimumTotal(List<List<Integer>> triangle) {
		int res = 0;

		for (int i = 0; i < triangle.size(); i++) {
			List<Integer> slist = triangle.get(i);
			int j = 0;
			int k = slist.size() - 1;
			while (j < k) {
				if (slist.get(j) < slist.get(k)) {
					k--;
				} else {
					j++;
				}
			}
			res += slist.get(j);
		}
		return res;
	}

	public static int minimumTotal_2(List<List<Integer>> triangle) {
		if (triangle.size() == 0)
			return 0;

		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				List<Integer> nextRow = triangle.get(i + 1);
				int sum = Math.min(nextRow.get(j), nextRow.get(j + 1)) + triangle.get(i).get(j);
				triangle.get(i).set(j, sum);
			}
		}
		return triangle.get(0).get(0);
	}

	public static int minimumTotal_3(List<List<Integer>> triangle) {
		if (triangle.size() == 0)
			return 0;

		List<Integer> dp = new ArrayList<Integer>(triangle.get(triangle.size() - 1));

		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				dp.set(j, Math.min(dp.get(j), dp.get(j + 1)) + triangle.get(i).get(j));
			}
		}
		return dp.get(0);
	}

}
