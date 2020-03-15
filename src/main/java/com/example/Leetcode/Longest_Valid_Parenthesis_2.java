package com.example.Leetcode;

import java.util.Stack;

import org.springframework.boot.SpringApplication;

public class Longest_Valid_Parenthesis_2 {

	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(LeetcodeApplication.class, args); String
	 * s=")())()()()"; int res=longestValidParentheses(s); System.out.println(res);
	 * 
	 * }
	 */

	public static int longestValidParentheses(String s) {
	        int n = s.length(), longest = 0;
	        Stack<Integer> st=new Stack<Integer>();
	        for (int i = 0; i < n; i++) {
	            if (s.charAt(i) == '(') st.push(i);
	            else {
	                if (!st.empty()) {
	                    if (s.charAt(st.peek()) == '(') st.pop();
	                    else st.push(i);
	                }
	                else st.push(i);
	            }
	        }
	        if (st.empty()) longest = n;
	        else {
	            int a = n, b = 0;
	            while (!st.empty()) {
	                b = st.peek(); st.pop();
	                longest = Math.max(longest, a-b-1);
	                a = b;
	            }
	            longest = Math.max(longest, a);
	        }
	        return longest;
	    }
}
