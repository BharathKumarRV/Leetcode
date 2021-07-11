package com.example.Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Majority_element {

	public static void main(String[] args) {
		int nums[] = { 2, 2, 1, 1, 1, 2, 2 };
		int res = majorityElement1(nums);
		System.out.println(res);
	}

	public static int majorityElement(int[] num) {

		int major = num[0], count = 1;
		for (int i = 1; i < num.length; i++) {
			if (count == 0) {
				count++;
				major = num[i];
			} else if (major == num[i]) {
				count++;
			} else
				count--;

		}
		return major;
	}

	// Sorting

	public static int majorityElement1(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	// Hashtable
	public int majorityElement2(int[] nums) {
		Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
		// Hashtable<Integer, Integer> myMap = new Hashtable<Integer, Integer>();
		int ret = 0;
		for (int num : nums) {
			if (!myMap.containsKey(num))
				myMap.put(num, 1);
			else
				myMap.put(num, myMap.get(num) + 1);
			if (myMap.get(num) > nums.length / 2) {
				ret = num;
				break;
			}
		}
		return ret;
	}

}
