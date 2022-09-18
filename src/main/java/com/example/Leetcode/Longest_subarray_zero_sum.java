package com.example.Leetcode;

import java.util.HashMap;
import java.util.List;

import org.springframework.boot.SpringApplication;

public class Longest_subarray_zero_sum {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int nums[] = { 1, 2, -2, 4, -4 };
		int res = maxLen(nums, nums.length);
		System.out.println(res);

	}
	
	private static int maxLen(int A[], int n)
    {
        // Your code here
        HashMap<Integer, Integer> mpp = new HashMap<Integer, Integer>();

        int maxi = 0;
        int sum = 0; 

        for(int i = 0;i<n;i++) {

            sum += A[i]; 

            if(sum == 0) {
                maxi = i + 1; 
            }
            else {
                if(mpp.get(sum) != null) {

                    maxi = Math.max(maxi, i - mpp.get(sum)); 
                }
                else {

                    mpp.put(sum, i); 
                }
            }
        }
        return maxi; 
    }
}
