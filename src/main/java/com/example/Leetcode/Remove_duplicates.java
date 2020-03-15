package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Remove_duplicates {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); LeetcodeApplication
	 * la = new LeetcodeApplication(); int[] A= {1,1,2,3,4,4}; int res =
	 * la.removeDuplicates(A); System.out.println(res);
	 * 
	 * }
	 */

	public int removeDuplicates(int[] A) {
        int n=A.length;
        if(n < 2) return n;
        int id = 1;
        for(int i = 1; i < n; ++i) 
            if(A[i] != A[i-1]) A[id++] = A[i];
        return id;
        
    }
}
