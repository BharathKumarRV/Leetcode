package com.example.Leetcode;

import java.util.LinkedList;
import java.util.Queue;

import org.springframework.boot.SpringApplication;

public class Implement_stack_using_queue {

	static class MyStack {
		Queue<Integer> queue;

		public MyStack() {
			this.queue = new LinkedList<Integer>();
		}

		// Push element x onto stack.
		public void push(int x) {
			queue.add(x);
			for (int i = 0; i < queue.size() - 1; i++) {
				queue.add(queue.poll());
			}
		}

		// Removes the element on top of the stack.
		public void pop() {
			queue.poll();
		}

		// Get the top element.
		public int top() {
			return queue.peek();
		}

		// Return whether the stack is empty.
		public boolean empty() {
			return queue.isEmpty();
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		MyStack stack = new MyStack();

		stack.push(1);
		stack.push(2);
		System.out.println(stack.top()); // returns 2
		stack.pop(); // returns 2
		System.out.println(stack.empty()); // returns false

	}
}
