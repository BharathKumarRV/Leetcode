package com.example.Leetcode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class Majority_element_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int nums[] = { 1, 1, 1, 3, 3, 2, 2, 2 };
		List<Integer> res = majorityElement(nums);
		System.out.println(res);
	}

	public static List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if (nums.length == 0)
			return res;

		int num1 = 0;
		int num2 = 1;
		int count1 = 0;
		int count2 = 0;

		for (int val : nums) {
			if (val == num1)
				count1++;
			else if (val == num2)
				count2++;
			else if (count1 == 0) {
				num1 = val;
				count1++;
			} else if (count2 == 0) {
				num2 = val;
				count2++;
			} else {
				count1--;
				count2--;
			}
		}
		count1 = 0;
		count2 = 0;
		for (int val : nums) {
			if (val == num1)
				count1++;
			else if (val == num2)
				count2++;
		}
		if (count1 > nums.length / 3)
			res.add(num1);
		if (count2 > nums.length / 3)
			res.add(num2);
		return res;

	}
}
