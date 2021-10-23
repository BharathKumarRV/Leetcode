package com.example.Leetcode.DP;

public class Palindrome_partitioning_min_cuts_top_down_optimized {

	public static int minPalPartion(String s) {
		int n = s.length();
		boolean dp[][] = new boolean[n][n];

		for (int g = 0; g < dp.length; g++) {
			for (int i = 0, j = g; j < dp.length; i++, j++) {
				if (g == 0) {
					dp[i][j] = true;
				} else if (g == 1) {
					dp[i][j] = s.charAt(i) == s.charAt(j);
				} else {
					if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
						dp[i][j] = true;
					} else {
						dp[i][j] = false;
					}
				}
			}
		}

		int strg[] = new int[n];

		strg[0]=0;
		
		for(int j=1;j<strg.length;j++) {
			int min=Integer.MAX_VALUE;
			for(int i=j;i>=1;i--) {
				if(dp[i][j]) {
					if(strg[i-1]<min) {
						min=strg[i-1];
					}
				}
			}
			
			strg[j]=min+1;
			
		}

		return strg[n-1];
	}

	public static void main(String args[]) {
		String str = "ababbbabbababa";
		System.out.println("Min cuts needed for " + "Palindrome Partitioning is " + minPalPartion(str));
	}
}
