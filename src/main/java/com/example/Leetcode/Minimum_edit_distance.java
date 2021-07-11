package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Minimum_edit_distance {

	public static int min(int x, int y, int z) 
	{ 
		return Math.min(Math.min(x, y), z); 
	} 

	public static int editDistDP(String str1, String str2, int m, int n) 
	{ 
		// Create a table to store results of subproblems 
		int dp[][]=new int[m + 1][n + 1]; 

		// Fill d[][] in bottom up manner 
		for (int i = 0; i <= m; i++) { 
			for (int j = 0; j <= n; j++) { 
				// If first string is empty, only option is to 
				// insert all characters of second string 
				if (i == 0) 
					dp[i][j] = j; // Min. operations = j 

				// If second string is empty, only option is to 
				// remove all characters of second string 
				else if (j == 0) 
					dp[i][j] = i; // Min. operations = i 

				// If last characters are same, ignore last char 
				// and recur for remaining string 
				else if (str1.charAt(i - 1) == str2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1]; 

				// If the last character is different, consider all 
				// possibilities and find the minimum 
				else
					dp[i][j] = 1 + min(dp[i][j - 1], // Insert 
									dp[i - 1][j], // Remove 
									dp[i - 1][j - 1]); // Replace 
			} 
		} 

		return dp[m][n]; 
	} 
	
	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[][] Grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		int res = editDistDP("ab","bc",2,2);
		System.out.println(res);

	}


}
