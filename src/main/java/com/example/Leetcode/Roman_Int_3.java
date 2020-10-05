package com.example.Leetcode;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;

public class Roman_Int_3 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int res = romanToInt("XV");
		System.out.println(res);

	}
	
	public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] chars = s.toCharArray();
        int result = 0;
        int i = 0, j = 1;
        for(; j < chars.length; i++, j++) {
            if (map.get(chars[i]) >= map.get(chars[j])) {
                result += map.get(chars[i]);
            } else {
                result -= map.get(chars[i]);
            }
        }
        result += map.get(chars[i]);
        return result;
    }
}
