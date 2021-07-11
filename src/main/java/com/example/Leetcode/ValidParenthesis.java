package com.example.Leetcode;

import java.util.List;
import java.util.Stack;

import org.springframework.boot.SpringApplication;

public class ValidParenthesis {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		LeetcodeApplication la = new LeetcodeApplication();
		String s = "()";
		boolean res =isValid_3(s);
		System.out.println(res);

	}

	public static boolean isValid(String s) {

		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();

	}
	
	 public static boolean isValid_3(String s) {
	        Stack<Character> stack = new Stack<Character>();
	       for(int i = 0; i<s.length(); i++) {
		            // Push any open parentheses onto stack
		            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
		                stack.push(s.charAt(i));
	                else if (stack.isEmpty() || stack.pop() != s.charAt(i))
					    return false;
	         }
	        
	          return stack.isEmpty();
	}
	
	
	 public static boolean isValid_2(String s) {
	        Stack<Character> stack = new Stack<Character>();
	        // Iterate through string until empty
	        for(int i = 0; i<s.length(); i++) {
	            // Push any open parentheses onto stack
	            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
	                stack.push(s.charAt(i));
	            // Check stack for corresponding closing parentheses, false if not valid
	            else if(s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(')
	                stack.pop();
	            else if(s.charAt(i) == ']' && !stack.empty() && stack.peek() == '[')
	                stack.pop();
	            else if(s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{')
	                stack.pop();
	            else
	                return false;
	        }
	        // return true if no open parentheses left in stack
	        return stack.empty();
	    }
}
