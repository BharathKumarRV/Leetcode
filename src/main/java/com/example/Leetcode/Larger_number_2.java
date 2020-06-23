package com.example.Leetcode;

public class Larger_number_2 {

	public static void main(String[] args) {
		int nums[] = { 3, 30, 34, 5, 9 };
		String res = largestNumber(nums);
		System.out.println(res);
	}

	public static String largestNumber(int[] nums) {

		StringBuffer sb = new StringBuffer("");
		int i = 0;
		while (i < nums.length) {

			if (nums[i] == -1 && i < nums.length) {
				i++;
				continue;
			} else if (i == nums.length)
				break;

			for (int j = 0; j < nums.length; j++) {

				if (i == j)
					continue;
				if (nums[j] == -1)
					continue;

				if (isBigger(nums[i], nums[j])) {

				} else {
					i = j;
					continue;
				}

			}

			if (!sb.toString().equals("0")) {
				sb.append(nums[i] + "");
			}

			nums[i] = -1;
			i = 0;

		}

		return sb.toString();
	}

	public static boolean isBigger(int a, int b) {

		String ab = a + "" + b;
		String ba = b + "" + a;

		return Long.parseLong(ab) > Long.parseLong(ba) ? true : false;

	}
}
