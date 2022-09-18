package com.example.Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class SubSetSum {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		// code here
		List<Integer> arr = new ArrayList<>();
		arr.add(2);
		arr.add(3);
		List<Integer> sumSubset = new ArrayList<>();
		func(0, 0, arr, arr.size(), sumSubset);
		Collections.sort(sumSubset);
		System.out.println(sumSubset);

	}

	static void func(int ind, int sum, List<Integer> arr, int N, List<Integer> sumSubset) {
		if (ind == N) {
			sumSubset.add(sum);
			return;
		}

		// pick the element
		func(ind + 1, sum + arr.get(ind), arr, N, sumSubset);

		// Do-not pick the element
		func(ind + 1, sum, arr, N, sumSubset);
	}

}
