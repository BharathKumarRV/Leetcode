package com.example.Leetcode;

public class Merge_two_array_without_extraspace {

	public static void main(String[] args) {
		int arr1[] = { 1, 4, 7, 8, 10 };
		int arr2[] = { 2, 3, 9 };
		System.out.println("Before merge:");
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println();
		merge(arr1, arr2, arr1.length, arr2.length);
		System.out.println("After merge:");
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}

	}

	static void merge(int[] arr1, int arr2[], int n, int m) {
		// code here
		int i, k;
		for (i = 0; i < n; i++) {
			// take first element from arr1
			// compare it with first element of second array
			// if condition match, then swap
			if (arr1[i] > arr2[0]) {
				int temp = arr1[i];
				arr1[i] = arr2[0];
				arr2[0] = temp;
			}

			// then sort the second array
			// put the element in its correct position
			// so that next cycle can swap elements correctly
			int first = arr2[0];
			// insertion sort is used here
			for (k = 1; k < m && arr2[k] < first; k++) {
				arr2[k - 1] = arr2[k];
			}
			arr2[k - 1] = first;
		}
	}
}
