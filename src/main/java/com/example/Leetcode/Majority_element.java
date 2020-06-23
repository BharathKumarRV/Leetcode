package com.example.Leetcode;

public class Majority_element {

	public static void main(String[] args) {
		int nums[] = { 3, 2, 3 };
		int res = majorityElement(nums);
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
	
	/*
	 * // Sorting public int majorityElement1(int[] nums) { Arrays.sort(nums);
	 * return nums[nums.length/2]; }
	 */
	
	/*
	 * // Hashtable public int majorityElement2(int[] nums) { Map<Integer, Integer>
	 * myMap = new HashMap<Integer, Integer>(); //Hashtable<Integer, Integer> myMap
	 * = new Hashtable<Integer, Integer>(); int ret=0; for (int num: nums) { if
	 * (!myMap.containsKey(num)) myMap.put(num, 1); else myMap.put(num,
	 * myMap.get(num)+1); if (myMap.get(num)>nums.length/2) { ret = num; break; } }
	 * return ret; }
	 */
}
