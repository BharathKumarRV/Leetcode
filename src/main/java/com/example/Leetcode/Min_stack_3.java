package com.example.Leetcode;

import java.util.Stack;

import org.springframework.boot.SpringApplication;

public class Min_stack_3 {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		push(-1);
		System.out.println(top());
		int res = getMin();
		System.out.println(res);
		push(-3);
		push(4);
		pop();
		top();
		int res1 = getMin();
		System.out.println(res1);

	}
	
    static class Pair {
	      Integer first;
	      Integer second;
	      
		public Pair(Integer first, Integer second) {
			super();
			this.first = first;
			this.second = second;
		}
	      
	      
	};
	
	static Stack<Pair> stack = new Stack<Pair>();
	

	public static void push(int x) {
        int min=(!stack.isEmpty() && x>stack.peek().second)? stack.peek().second:x;
		stack.push(new Pair(x,min));
	}

	public static void pop() {
		// use equals to compare the value of two object, if equal, pop both of the
		stack.pop();
	}

	public static int top() {
		return stack.peek().first;
	}

	public static int getMin() {
		return stack.peek().second;
	}
}
