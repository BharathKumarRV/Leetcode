package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Square_root {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int res = mySqrt2(8);
		System.out.println(res);
	}

	public static int mySqrt(int x) {
		long left = 1;
		long right = x;

		if (x < 2) {
			return x;
		}

		while (left < right) {
			long mid = left + ((right - left) / 2);

			if (mid * mid == x) {
				return (int) mid;
			} else if (mid * mid > x) {
				right = mid;
			} else if (mid * mid < x) {
				left = mid + 1;
			}

		}
		return (int) left - 1;
	}
	
	/*
	 * There are comments on threads where it is mentioned: it is to prevent
	 * overflow. But they do not mention how integers overflow in Java. Let me tell
	 * you why: In a nutshell, they overflow in a circular fashion. Meaning if you
	 * do Integer.MAX_VALUE + 1 it will yield Integer.MIN_VALUE. Same for the other
	 * way around. Try printing these expressions in a Java program to really see it
	 * in action.
	 * 
	 * So when we found our value mid <= x / mid, it is important to check if it is
	 * not overflowing. If it overflows, then it rolls over to the negative integers
	 * and thus the value of mid + 1 can never be greater than x/mid + 1
	 */
	
	public static int mySqrt2(int x) {
		if (x == 0) return 0;
		int start = 1, end = x;
		while (start < end) { 
			int mid = start + (end - start) / 2;
			/* Val should be less or equal to x and val+1 should be greater than x*/
			if (mid <= x / mid && (mid + 1) > x / (mid + 1))// Found the result:
				return mid; 
			else if (mid > x / mid)// Keep checking the left part
				end = mid;
			else
				start = mid + 1;// Keep checking the right part
		}
		return start;
	}
	
	
	public int mySqrt3(int x) { 
		if (x == 0) return 0;
		for (int i = 1; i <= x / i; i++) 		
			if (i <= x / i && (i + 1) > x / (i + 1))// Look for the critical point: i*i <= x && (i+1)(i+1) > x
				return i;		
		return -1;
	}
}
