package com.example.Leetcode;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;

public class Twosum {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		LeetcodeApplication la = new LeetcodeApplication();
		int num[] = { 2, 7, 11, 15 };
		int res[] = twoSum(num, 9);
		System.out.println(res);

	}

	public static int[] twoSum(int[] numbers, int target) {

		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				result[1] = i;
				result[0] = map.get(target - numbers[i]);
				return result;
			}
			map.put(numbers[i], i);
		}
		return result;

	}

	public static int[] twoSum_brute_force(int[] nums, int target) {
		int indices[] = new int[2];

		for (int i = 0; i < nums.length; i++) {
			int current = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				if (current + nums[j] == target) {
					indices[0] = i;
					indices[1] = j;
					
				}
			}
		}

		return indices;
	}

}
