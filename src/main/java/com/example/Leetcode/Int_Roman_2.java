package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Int_Roman_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		String res = intToRoman(58);
		System.out.println(res);

	}
	
	public static String intToRoman(int num) {
	    String[][] table = {{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
	                           {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
	                           {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
	                           {"", "M", "MM", "MMM"}
	                          };
	    String result=new String();
	    int count = 0;
	    while(num > 0){
	        int temp = num % 10;
	        result = table[count][temp] + result;
	        num /= 10;
	        count++;
	    }
	    return result;
	}
}
