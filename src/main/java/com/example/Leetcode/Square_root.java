package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Square_root {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); int res =
	 * mySqrt(2147395599); System.out.println(res); }
	 */

	public static int mySqrt(int x) {
        long left=1;
        long right=x;
        
        if(x<2){
            return x;
        }
        
        while(left<right){
            long mid=left+((right-left)/2);
            
            if(mid*mid==x){
                return (int)mid;
            }
            else if(mid*mid>x){
                right=mid;
            }
            else if(mid*mid<x){
                left=mid+1;
            }
            
        }
        return (int)left-1;
    }
}
