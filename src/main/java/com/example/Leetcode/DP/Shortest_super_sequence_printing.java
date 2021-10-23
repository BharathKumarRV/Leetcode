package com.example.Leetcode.DP;

public class Shortest_super_sequence_printing {

	static String printShortestSuperSeq(String X, String Y) {
		int m = X.length();
		int n = Y.length();

		// dp[i][j] contains length of
		// shortest supersequence
		// for X[0..i-1] and Y[0..j-1]
		int dp[][] = new int[m + 1][n + 1];
		// int i, j;
		// Fill table in bottom up manner
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;

				else if (X.charAt(i - 1) == Y.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + 1;

				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		// Following code is used to print
		// shortest supersequence dp[m][n] s
		// tores the length of the shortest
		// supersequence of X and Y
		/// int index = dp[m][n];

		// string to store the shortest supersequence
		String str = "";

		// Start from the bottom right corner and one by one
		// push characters in output string
		int i = m, j = n;
		while (i > 0 && j > 0)

		{
			// If current character in X and Y are same, then
			// current character is part of shortest supersequence
			if (X.charAt(i - 1) == Y.charAt(j - 1))

			{
				// Put current character in result
				str += (X.charAt(i - 1));

				// reduce values of i, j and index
				i--;
				j--;
				// index--;
			}

			// If current character in X and Y are different
			else {
				if (dp[i][j - 1] > dp[i - 1][j]) {

					// Put current character of Y in result
					str += (Y.charAt(j - 1));

					// reduce values of j and index
					j--;
					// index--;
				} else {

					// Put current character of X in result
					str += (X.charAt(i - 1));

					// reduce values of i and index
					i--;
					// index--;
				}
			}
		}

		// If Y reaches its end, put remaining characters
		// of X in the result string
		while (i > 0) {
			str += (X.charAt(i - 1));
			i--;
			// index--;
		}

		// If X reaches its end, put remaining characters
		// of Y in the result string
		while (j > 0) {
			str += (Y.charAt(j - 1));
			j--;
			// index--;
		}

		// reverse the string and return it
		str = reverse(str);
		return str;
	}

	static String reverse(String input) {
		char[] temparray = input.toCharArray();
		int left=0;
		int right = temparray.length - 1;

		for (left = 0; left < right; left++, right--) {
			// Swap values of left and right
			char temp = temparray[left];
			temparray[left] = temparray[right];
			temparray[right] = temp;
		}
		return String.valueOf(temparray);
	}

	// Driver code
	public static void main(String[] args) {
		String X = "AGGTAB";
		String Y = "GXTXAYB";
		System.out.println(printShortestSuperSeq(X, Y));
	}
}
