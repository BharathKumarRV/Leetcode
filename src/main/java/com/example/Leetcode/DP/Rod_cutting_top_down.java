package com.example.Leetcode.DP;

public class Rod_cutting_top_down {

	// A utility function that returns
		// maximum of two integers
		static int max(int a, int b) {
			return (a > b) ? a : b;
		}

		// Returns the maximum value that can
		// be put in a knapsack of capacity W
		static int rodcutting(int L, int N[], int val[], int n) {
			int i, j;
			int dp[][] = new int[n + 1][L + 1];

			// Build table K[][] in bottom up manner
			for (i = 0; i <= n; i++) {
				for (j = 0; j <= L; j++) {
					if (i == 0 || j == 0)
						dp[i][j] = 0;
					else if (N[i - 1] <= j)
						dp[i][j] = max(val[i - 1] + dp[i - 1][j - N[i - 1]], dp[i - 1][j]);
					else
						dp[i][j] = dp[i - 1][j];
				}
			}

			return dp[n][L];
		}

		// Driver code
		public static void main(String args[]) {
			int val[] = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
			int N[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
			int L = N.length;
			int n = val.length;
			System.out.println(rodcutting(L, N, val, n));
		}
}
