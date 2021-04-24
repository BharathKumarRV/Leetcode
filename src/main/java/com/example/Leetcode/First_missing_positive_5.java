package com.example.Leetcode;

public class First_missing_positive_5 {

	public static void main(String[] args) {
		int arr[] = { 3, 4, 7, 1 };
		int arr_size = arr.length;
		int missing = firstMissingPositive(arr);
		System.out.println("The smallest positive missing number is " + missing);
	}

	// https://www.youtube.com/watch?v=-lfHWWMmXXM
	public static int firstMissingPositive(int A[]) {
		int n = A.length;
		for (int i = 0; i < n; ++i) {
			while (A[i] >= 1 && A[i] <= n && A[i] != A[A[i] - 1])
				// swap(A,A[i], A[A[i] - 1]);
				swap(A, i);
		}

		for (int i = 0; i < n; ++i)
			if (A[i] != i + 1)
				return i + 1;

		return n + 1;
	}

	public static void swap(int A[], int i) {

		int temp = A[i];
		int temp2 = A[i] - 1;
		A[i] = A[A[i] - 1];
		A[temp2] = temp;
	}
}
