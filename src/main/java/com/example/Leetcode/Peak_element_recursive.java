package com.example.Leetcode;

public class Peak_element_recursive {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 1 };
		Integer peak = getPeakElement(array);
		System.out.println(peak != null ? "Peak Element is " + peak : "No peak element!");
	}

	public static Integer getPeakElement(int[] array) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int n = array.length;
		int start = 0;
		int end = n - 1;
		return helper(array, start, end);
	}

	public static Integer helper(int[] array, int start, int end) {

		int mid = (start + end) / 2;

		if ((mid == 0 || array[mid - 1] <= array[mid]) && (mid == array.length - 1 || array[mid] >= array[mid + 1])) {
			return array[mid]; // array[mid] is peak element
		} else {
			if (mid > 0 && array[mid - 1] > array[mid]) {
				return helper(array, start, mid - 1);
			} else {
				return helper(array, mid + 1, end);
			}
		}

	}
}
