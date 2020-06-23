package com.example.Leetcode;

public class Number_of_bits {

	public static void main(String[] args) {

		int res = hammingWeight(14);
		System.out.print(res);

	}
	
	 public static int hammingWeight(int n) {
	     if(n==0)
	         return 0;
	     int count=0;
	    for(int i=0;i<32;i++){
	     if((n & 1)==1)
	         count++;
	     n>>=1;
	    }
	        
	        return count;
	}
}
