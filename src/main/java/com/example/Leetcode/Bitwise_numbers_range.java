package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Bitwise_numbers_range {

	public static int rangeBitwiseAnd(int m, int n) {
		int i = 0; // i means we have how many bits are 0 on the right
		while (m != n) {
			m >>= 1;
			n >>= 1;
			i++;
		}
		return m << i;
	}
	
	 public static int rangeBitwiseAnd_2(int m, int n) {
	        if(m==0) return 0;
	        int and =m;

	        for(int i=m;i<=n;i++){
	            and&=i;
	            if(i==Integer.MAX_VALUE) break;
	            if(and==0) return 0;
	        }
	        return and;
	    }

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int res = rangeBitwiseAnd_2(5,7);
		System.out.println(res);

	}

}
