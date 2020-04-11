package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Decode_ways {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); int res =
	 * numDecodings("12"); System.out.print(res);
	 * 
	 * }
	 */

	public static int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            int onedigit = Integer.valueOf(s.substring(i-1, i));
            int twodigit = Integer.valueOf(s.substring(i-2, i));
            if(onedigit >= 1 && onedigit <= 9) {
               dp[i] += dp[i-1];  
            }
            if(twodigit >= 10 && twodigit <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
