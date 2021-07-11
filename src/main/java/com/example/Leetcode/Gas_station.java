package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Gas_station {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] gas = { 1, 2, 3, 4, 5 };
		int[] cost = { 3, 4, 5, 1, 2 };
		int res = canCompleteCircuit(gas, cost);
		System.out.println(res);

	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int sumGas = 0;
		int sumCost = 0;
		int start = 0;
		int tank = 0;
		for (int i = 0; i < gas.length; i++) {
			sumGas += gas[i];
			sumCost += cost[i];
			tank += gas[i] - cost[i];
			if (tank < 0) { // If the tank is negative then start cannot be
				start = i + 1; // from starting index(0) to i, so start will be i+1
				tank = 0; // tank should be zero from starting index.
			}
		}
		if (sumGas < sumCost) {
			return -1;
		} else {
			return start;
		}
	}
}
