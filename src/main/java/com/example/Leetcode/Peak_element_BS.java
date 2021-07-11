package com.example.Leetcode;

public class Peak_element_BS {

	public static void main(String[] args) {
		int[] array = { 6, 5, 4, 3, 2, 3, 2 };
		Integer peak = getPeakElement(array);
		System.out.println(peak != null ? "Peak Element is " + peak : "No peak element!");
	}

	public static int getPeakElement(int[] array) {
		if (array == null || array.length == 0) {
			return -1;
		}

		if (array.length == 1) {
			return 0;
		}

		int n = array.length;

		int start = 0;
		int end = n - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (mid > 0 && mid < end) {

				if ((array[mid - 1] < array[mid]) && (array[mid] > array[mid + 1])) {
					return mid; // array[mid] is peak element
				} else if (array[mid - 1] > array[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else if (mid == 0) {
				if (array[mid] > array[mid + 1]) {
					return mid;
				} else {
					return mid + 1;
				}
			} else {
				if (array[mid] > array[end - 1]) {
					return mid;
				} else {
					return end - 1;
				}
			}

		}
		return -1;
	}
}
