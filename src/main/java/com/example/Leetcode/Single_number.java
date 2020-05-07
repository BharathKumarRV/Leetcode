package com.example.Leetcode;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;

public class Single_number {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); int[] nums=
	 * {4,1,2,1,2}; int res = singleNumber(nums,nums.length);
	 * System.out.println(res);
	 * 
	 * }
	 */
	
	/*
	 * public static int singleNumber(int[] A) {
	 * 
	 * Set<Integer> s = new HashSet<Integer>(); for (int i: A){ if(!s.add(i)){
	 * s.remove(i); } } return s.iterator().next();
	 * 
	 * }
	 */

	public static int singleNumber(int A[], int n) {
	    int result = 0;
	    for (int i = 0; i<n; i++)
	    {
			result ^=A[i];
	    }
		return result;
	}
}
