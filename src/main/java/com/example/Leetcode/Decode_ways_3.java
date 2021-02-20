package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Decode_ways_3 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int res = numDecodings("226");
		System.out.print(res);

	}

	public static int numDecodings(String s) {
		if (s == null || s.length() == 0 || s.charAt(0)=='0') {
			return 0;
		}
		if(s.length()==1) {
			return 1;
		}
		int count1=1,count2=1;
		for(int i=1;i<s.length();i++) {
			int d=s.charAt(i)-'0';
			int dd=(s.charAt(i-1)-'0')*10+d;
			int count=0;
			if(d>0)
				count+=count2;
			if(dd>=10 && dd<=26)
				count+=count1;
			count1=count2;//count1 is prev to prev
			count2=count;//count is prev
		}
		
		return count2;
	}
}
