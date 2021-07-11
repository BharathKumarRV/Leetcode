package com.example.Leetcode.DP;

public class Sub_set_sum_min_dp {

	 // Returns the minimum value of
    //the difference of the two sets.
    static int findMin(int arr[], int n)
    {
        // Calculate sum of all elements
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];
     
        // Create an array to store
        // results of subproblems
        boolean dp[][] = new boolean[n + 1][sum + 1];
     
        // Initialize first column as true.
        // 0 sum is possible  with all elements.
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;
     
        // Initialize top row, except dp[0][0],
        // as false. With 0 elements, no other
        // sum except 0 is possible
        for (int i = 1; i <= sum; i++)
            dp[0][i] = false;
     
        // Fill the partition table
        // in bottom up manner
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= sum; j++)
            {
                // If i'th element is excluded
     
                // If i'th element is included
                if (arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                else {
                	 dp[i][j] = dp[i - 1][j];
                }
            }
        }
     
        // Initialize difference of two sums.
        int diff = Integer.MAX_VALUE;
         
        // Find the largest j such that dp[n][j]
        // is true where j loops from sum/2 t0 0
        for (int s1 = sum / 2; s1 >= 0; s1--)
        {
            // Find the
            if (dp[n][s1] == true)
            {
                diff = sum - 2 * s1;
                break;
            }
        }
        return diff;
    }
     
    // Driver program
    public static void main (String[] args)
    {
        int arr[] = {3, 1, 4, 2, 2, 1};
        int n = arr.length;
        System.out.println ("The minimum difference between 2 sets is "
                            + findMin(arr, n));
     
    }
}
