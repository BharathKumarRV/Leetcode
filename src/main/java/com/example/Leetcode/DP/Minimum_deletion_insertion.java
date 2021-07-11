package com.example.Leetcode.DP;

public class Minimum_deletion_insertion {

	 static int lcs(String str1, String str2, int m, int n)
	    {
	        int L[][] = new int[m + 1][n + 1];
	        int i, j;
	 
	        // Following steps build L[m+1][n+1] in
	        // bottom up fashion. Note that L[i][j]
	        // contains length of LCS of str1[0..i-1]
	        // and str2[0..j-1]
	        for (i = 0; i <= m; i++) {
	            for (j = 0; j <= n; j++) {
	                if (i == 0 || j == 0)
	                    L[i][j] = 0;
	 
	                else if (str1.charAt(i - 1)
	                         == str2.charAt(j - 1))
	                    L[i][j] = L[i - 1][j - 1] + 1;
	 
	                else
	                    L[i][j] = Math.max(L[i - 1][j],
	                                       L[i][j - 1]);
	            }
	        }
	 
	        // L[m][n] contains length of LCS
	        // for X[0..n-1] and Y[0..m-1]
	        return L[m][n];
	    }
	 
	    // function to find minimum number
	    // of deletions and insertions
	    static void printMinDelAndInsert(String str1,
	                                     String str2)
	    {
	        int m = str1.length();
	        int n = str2.length();
	 
	        int len = lcs(str1, str2, m, n);
	 
	        System.out.println("Minimum number of "
	                           + "deletions = ");
	        System.out.println(m - len);
	 
	        System.out.println("Minimum number of "
	                           + "insertions = ");
	        System.out.println(n - len);
	    }
	 
	    // Driver code
	    public static void main(String[] args)
	    {
	        String str1 = new String("heap");
	        String str2 = new String("pea");
	       
	          // Function Call
	        printMinDelAndInsert(str1, str2);
	    }
}
