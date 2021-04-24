package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Haystack_needle {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int res = strStr_2("hello","ll");
		System.out.println(res);

	}

	public static int strStr(String haystack, String needle) {
		if (haystack == null || needle == null) {
			return -1;
		}

		for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
			int j;
			for (j = 0; j < needle.length(); j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					break;
				}
			}
			if (j == needle.length()) {
				return i;
			}
		}

		return -1;
	}
	
	 public static int strStr_2(String haystack, String needle) {
	       
	        for(int i=0;i<haystack.length()-needle.length()+1;i++){
	            int k=0;
	            while(k<needle.length()){
	                if(haystack.charAt(i+k)==needle.charAt(k)){
	                    k++;
	                }
	                else{
	                    break;
	                }
	            }
	            
	            if(k==needle.length()){
	                return i;
	            }
	        }
	        
	        return -1;
	    }
}
