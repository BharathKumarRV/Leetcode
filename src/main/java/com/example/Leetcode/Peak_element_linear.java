package com.example.Leetcode;

public class Peak_element_linear {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 1 };
		Integer peak = getPeakElement(array);
		System.out.println(peak != null ? "Peak Element is " + peak : "No peak element!");
	}

	public static Integer getPeakElement(int[] array) {

		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1]) {// <
				return i - 1;
			}
		}
		return array.length - 1;
	}
}
