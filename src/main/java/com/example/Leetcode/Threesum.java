package com.example.Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class Threesum {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int num[] = { -2, 0, 0, 2, 2 };
		List<List<Integer>> res = threeSum(num);
		System.out.println(res);

	}

	public static List<List<Integer>> threeSum(int[] num) {

		Arrays.sort(num);
		List<List<Integer>> res = new LinkedList<>();
		for (int i = 0; i < num.length - 2; i++) {
			if (num[i] > 0)
				break; // Since the nums is sorted, if first number is bigger than 0, it is impossible
						// to have a sum of 0.
			if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
				int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
				while (lo < hi) {
					if (num[lo] + num[hi] == sum) {
						res.add(Arrays.asList(num[i], num[lo], num[hi]));
						while (lo < hi && num[lo] == num[lo + 1]) //for duplicates  {-2, 0, 0, 2, 2} 
							lo++;
						while (lo < hi && num[hi] == num[hi - 1])
							hi--;
						lo++;
						hi--;
					} else if (num[lo] + num[hi] < sum)
						lo++;
					else
						hi--;
				}
			}
		}
		return res;

	}
}
