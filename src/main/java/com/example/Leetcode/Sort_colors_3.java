package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Sort_colors_3 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int A[] = { 2, 0, 2, 1, 1, 0 };
		sortColors(A);
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i]);
		}

	}

	public static void sortColors(int A[]) {
		int num0 = 0, num1 = 0, num2 = 0;
		int n=A.length;

		//Timee complexity: O(2N)
		for (int i = 0; i < n; i++) {
			if (A[i] == 0)
				++num0;
			else if (A[i] == 1)
				++num1;
			else if (A[i] == 2)
				++num2;
		}

		for (int i = 0; i < num0; ++i)
			A[i] = 0;
		for (int i = 0; i < num1; ++i)
			A[num0 + i] = 1;
		for (int i = 0; i < num2; ++i)
			A[num0 + num1 + i] = 2;
	}
}
