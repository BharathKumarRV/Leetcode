package com.example.Leetcode.DP;

public class Longest_common_subsequence_recursive {

	public static void main(String args[]) {
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		System.out.println("Length of LCS is" + " " + lcs(X, Y, m, n));
	}
	
	 public static int lcs( char[] X, char[] Y, int m, int n )
	  {
	    if (m == 0 || n == 0)
	      return 0;
	    if (X[m-1] == Y[n-1])
	      return 1 + lcs(X, Y, m-1, n-1);
	    else
	      return max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n));
	  }
	  
	  /* Utility function to get max of 2 integers */
	  static int max(int a, int b)
	  {
	    return (a > b)? a : b;
	  }

}
