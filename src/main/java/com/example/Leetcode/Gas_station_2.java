package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Gas_station_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] gas = { 1, 2, 3, 4, 5 };
		int[] cost = { 3, 4, 5, 1, 2 };
		int res = canCompleteCircuit(gas, cost);
		System.out.println(res);

	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int n = gas.length;
		for (int i = 0; i < n; i++) {
			int total = 0, stopCount = 0, j = i;
			while (stopCount < n) { // loop for n stops
				total += gas[j % n] - cost[j % n];
				if (total < 0) // starting from this stop we can't complete trip break
					break;
				stopCount++;
				j++;
			}
			if (stopCount == n && total >= 0) // if we are able to cover all the stop and fuel +ve return i'th stop
				return i;
		}

		return -1;
	}
}
