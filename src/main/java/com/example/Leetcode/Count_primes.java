package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Count_primes {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int res = countPrimes(10);
		System.out.println(res);

	}
	
	 public static int countPrimes(int n) {
         boolean[] m = new boolean[n];
        int count = 0;
        for (int i=2; i<n; i++) {
            if (m[i])
                continue;
             
            count++; // increase count for prime
            for (int j=i; j<n; j=j+i)
                m[j] = true; // Marking all the multiples as non prime
        }
         
        return count;
    }
}
