package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Pow {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); double res =
	 * pow(2.00000,-2); System.out.println(res);
	 * 
	 * }
	 */

	public static double pow(double x, int n) {
        if(n == 0)
            return 1;
        double temp=pow(x,n/2);
        
        if(n%2==0)
        	return temp*temp;
        else if(n>0)
        	return temp*temp*x;
        else
        	return (temp*temp)/x;
    }
}
