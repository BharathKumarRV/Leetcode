package com.example.Leetcode;

import java.util.Stack;

import org.springframework.boot.SpringApplication;

public class Longest_Valid_Parenthesis_2 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		String s = "())";
		int res = longestValidParentheses(s);
		System.out.println(res);

	}
/*
	The workflow of the solution is as below.

	Scan the string from beginning to end.
	If current character is '(',
	push its index to the stack. If current character is ')' and the
	character at the index of the top of stack is '(', we just find a
	matching pair so pop from the stack. Otherwise, we push the index of
	')' to the stack.
	After the scan is done, the stack will only
	contain the indices of characters which cannot be matched. Then
	let's use the opposite side - substring between adjacent indices
	should be valid parentheses.
	If the stack is empty, the whole input
	string is valid. Otherwise, we can scan the stack to get longest
	valid substring as described in step 3.
	
	*/
	public static int longestValidParentheses(String s) {
		int n = s.length(), longest = 0;
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '(')
				st.push(i);
			else if (!st.empty() && s.charAt(st.peek()) == '(')
				st.pop();
			else
				st.push(i);
		}
		if (st.empty())
			longest = n;
		else {
			int a = n, b = 0;
			while (!st.empty()) {
				b = st.peek();
				st.pop();
				longest = Math.max(longest, a - b - 1);
				a = b;
			}
			longest = Math.max(longest, a);
		}
		return longest;
	}
}
