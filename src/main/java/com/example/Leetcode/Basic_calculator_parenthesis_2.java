package com.example.Leetcode;

import java.util.Stack;

import org.springframework.boot.SpringApplication;

public class Basic_calculator_parenthesis_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int res = calculate("1+(4+5+2)-3");
		System.out.println(res);
	}
	
	
	public static int calculate(String s) {
	    if(s == null) return 0;
	        
	    int result = 0;
	    int sign = 1;
	    int num = 0;
	            
	    Stack<Integer> stack = new Stack<Integer>();
	    stack.push(sign);
	            
	    for(int i = 0; i < s.length(); i++) {
	        char c = s.charAt(i);
	                
	        if(c >= '0' && c <= '9') {
	            num = num * 10 + (c - '0');
	                    
	        } else if(c == '+' || c == '-') {
	            result += sign * num;
	            sign = stack.peek() * (c == '+' ? 1: -1); 
	            num = 0;
	                    
	        } else if(c == '(') {
	            stack.push(sign);
	                    
	        } else if(c == ')') {
	            stack.pop();
	        }
	    }
	            
	    result += sign * num;
	    return result;
	}
}
