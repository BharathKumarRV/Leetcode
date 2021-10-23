package com.example.Leetcode.DP;

public class Count_sub_set_sum {

	static int isSubsetSum(int set[], int n, int sum) {
		// Base Cases
		if (sum == 0)
			return 1;
		if (n == 0)
			return 0;

		/*
		 * else, check if sum can be obtained by any of the following (a) including the
		 * last element (b) excluding the last element
		 */
		if (set[n - 1] <= sum) {
			return isSubsetSum(set, n - 1, sum) + isSubsetSum(set, n - 1, sum - set[n - 1]);
		} // If last element is greater than
			// sum, then ignore it
		else {
			return isSubsetSum(set, n - 1, sum);
		}

	}

	/* Driver code */
	public static void main(String args[]) {
		int set[] = { 1, 2, 3};
		int sum = 3;
		int n = set.length;
		System.out.println("Subset count sum" + isSubsetSum(set, n, sum));
	}
}
