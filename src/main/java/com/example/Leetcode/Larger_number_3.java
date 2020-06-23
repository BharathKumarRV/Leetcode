package com.example.Leetcode;

public class Larger_number_3 {

	public static void main(String[] args) {

		String res = largestNumber(nums);
		System.out.println(res);
	}

	static int nums[] = { 10, 2 };

	public static String largestNumber(int[] nums) {
		StringBuffer sb = new StringBuffer("");

		int i = 0;
		while (i < nums.length - 1) {

			for (int j = i + 1; j < nums.length; j++) {
				String ij = nums[i] + "" + nums[j];
				String ji = nums[j] + "" + nums[i];

				if (Long.parseLong(ij) > Long.parseLong(ji)) {
					continue;
				} else {
					swap(i, j);
				}
			}
			i++;
		}

		if(nums[0]==0) {
			return "0";
		}
		
		for (int k = 0; k < nums.length; k++) {
			sb.append(String.valueOf(nums[k]));
		}

		return sb.toString();

	}

	public static void swap(int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
