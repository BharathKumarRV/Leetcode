package com.example.Leetcode;

public class Maximum_gap {

	public static int solve(int[] a, int n) {
		int max1 = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (Math.abs(a[i] - a[j]) > max1) {
					max1 = Math.abs(a[i] - a[j]);
				}
			}
		}
		return max1;
	}
	
	public static int solve_2(int a[], int n)
    {
        int min1 = a[0];
        int max1 = a[0];
      
        // finding maximum and minimum 
        // of an array
        for (int i = 0; i < n; i++) 
        {
            if (a[i] > max1)
                max1 = a[i];
            if (a[i] < min1)
                min1 = a[i];
        }
          
        return Math.abs(min1 - max1);
    }

//Driver Code
	public static void main(String[] args) {
		int[] arr = { 1, 3, 6, 9 };
		int size = arr.length;
		System.out.println("Largest gap is : " + solve(arr, size));
	}
}
