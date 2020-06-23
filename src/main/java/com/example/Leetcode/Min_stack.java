package com.example.Leetcode;

import java.util.Stack;

import org.springframework.boot.SpringApplication;

public class Min_stack {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		push(-2);
		push(0);
		push(-3);
		int res = getMin();
		System.out.println(res);
		push(4);
		pop();
		top();
		int res1 = getMin();
		System.out.println(res1);

	}

	static Stack<Integer> stack = new Stack<Integer>();
	static Stack<Integer> minStack = new Stack<Integer>();

	public static void push(int x) {
		// store current min value into minStack
		if (minStack.isEmpty() || x <= minStack.peek())
			minStack.push(x);
		stack.push(x);
	}

	public static void pop() {
		// use equals to compare the value of two object, if equal, pop both of them
		if (stack.peek().equals(minStack.peek()))
			minStack.pop();
		stack.pop();
	}

	public static int top() {
		return stack.peek();
	}

	public static int getMin() {
		return minStack.peek();
	}
}
