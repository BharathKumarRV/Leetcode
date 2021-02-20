package com.example.Leetcode;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;

public class Roman_Int_3 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int res = romanToInt("IX");
		System.out.println(res);

	}
	
	public static int romanToInt(String s) {
		 Map<Character, Integer> map = new HashMap();
         map.put('I', 1);
         map.put('V', 5);
         map.put('X', 10);
         map.put('L', 50);
         map.put('C', 100);
         map.put('D', 500);
         map.put('M', 1000);

         int result = 0;
         for (int i = 0; i < s.length(); i++) {
             if (i > 0 && map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
                 result += map.get(s.charAt(i)) - 2 * map.get(s.charAt(i - 1));
             } else {
                 result += map.get(s.charAt(i));
             }
         }
         return result;
    }
}
