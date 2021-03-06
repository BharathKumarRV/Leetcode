package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Int_Roman {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		String res = intToRoman(1994);
		System.out.println(res);

	}

	public static String intToRoman(int num) {

		String M[] = { "", "M", "MM", "MMM" };
		String C[] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String X[] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String I[] = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
		return M[(num % 10000) / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];

	}
}
