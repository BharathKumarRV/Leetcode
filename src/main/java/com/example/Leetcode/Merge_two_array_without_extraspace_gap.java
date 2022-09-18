package com.example.Leetcode;

public class Merge_two_array_without_extraspace_gap {

	static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

	static void merge(int ar1[], int ar2[], int n, int m) {
		// code here
		int gap = (int) Math.ceil((double) (n + m) / 2.0);
		while (gap > 0) {
			int i = 0;
			int j = gap;
			while (j < (n + m)) {
				if (j < n && ar1[i] > ar1[j]) {
					swap(ar1[i], ar1[j]);
				} else if (j >= n && i < n && ar1[i] > ar2[j - n]) {
					swap(ar1[i], ar2[j - n]);
				} else if (j >= n && i >= n && ar2[i - n] > ar2[j - n]) {
					swap(ar2[i - n], ar2[j - n]);
				}
				j++;
				i++;
			}
			if (gap == 1) {
				gap = 0;
			} else {
				gap = (int) Math.ceil((double) gap / 2.0);
			}
		}
	}

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
}
