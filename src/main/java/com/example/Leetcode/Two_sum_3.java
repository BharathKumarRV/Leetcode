package com.example.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class Two_sum_3 {

	public static void main(String[] args) {
		int nums[] = { 3, 2, 3 };
		Two_sum_3 two_sum = new Two_sum_3();
		add(6);
		add(1);
		add(2);
		add(2);
		boolean res = find(4);
		System.out.println(res);
		boolean res1 = find(9);
		System.out.println(res1);

	}

	private static HashMap<Integer, Integer> map;

	/** Initialize your data structure here. */
	public Two_sum_3() {
		map = new HashMap<>();
	}

	/** Add the number to an internal data structure.. */
	public static void add(int number) {
		map.put(number, map.getOrDefault(number, 0) + 1);
	}

	/** Find if there exists any pair of numbers which sum is equal to the value. */
	public static boolean find(int value) {
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int num1 = entry.getKey();
			int num2 = value - num1;
			if ((num1 == num2 && map.get(num2) > 1) || (num1 != num2 && map.containsKey(num2))) {
				return true;
			}
		}
		return false;
	}
}
