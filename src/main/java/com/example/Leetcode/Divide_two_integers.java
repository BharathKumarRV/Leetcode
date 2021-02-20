package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Divide_two_integers {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int res = divide(43,8);
		System.out.println(res);

	}

	
	 public static int divide(int dividend, int divisor) {
	        
	        int sign = 1;
			if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
				sign = -1;
			long ldividend = Math.abs((long) dividend);
			long ldivisor = Math.abs((long) divisor);
			
			//Take care the edge cases.
			if (ldivisor == 0) return Integer.MAX_VALUE;
			if ((ldividend == 0) || (ldividend < ldivisor))	return 0;
			
			long lans = ldivide(ldividend, ldivisor);
			
			int ans;
			if (lans > Integer.MAX_VALUE){ //Handle overflow.
				ans = (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
			} else {
				ans = (int) (sign * lans);
			}
			return ans;
	        
	    }
	    
	    private static long ldivide(long ldividend, long ldivisor) {
			// Recursion exit condition
			if (ldividend < ldivisor) return 0;
			
			//  Find the largest multiple so that (divisor * multiple <= dividend), 
			//  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
			//  Think this as a binary search.
			long sum = ldivisor;
			long multiple = 1;
			while ((sum+sum) <= ldividend) {
				sum += sum;
				multiple += multiple;
			}
			//Look for additional value for the multiple from the reminder (dividend - sum) recursively.
			return multiple + ldivide(ldividend - sum, ldivisor);
		}
}
