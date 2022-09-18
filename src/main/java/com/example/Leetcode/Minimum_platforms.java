package com.example.Leetcode;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;

public class Minimum_platforms {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[][] Grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
		int res = findPlatform(arr, dep, arr.length);
		System.out.println(res);

	}

	static int findPlatform(int arr[], int dep[], int n) {
		Arrays.sort(arr);
		Arrays.sort(dep);

		int plat_needed = 1, result = 1;
		int i = 1, j = 0;

		while (i < n && j < n) {

			if (arr[i] <= dep[j]) {
				plat_needed++;
				i++;
			}

			else if (arr[i] > dep[j]) {
				plat_needed--;
				j++;
			}

			if (plat_needed > result)
				result = plat_needed;
		}

		return result;
	}

}
