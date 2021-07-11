package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Min_stack_4 {

	private static class Node {
		int val;
		int min;
		Node next;

		private Node(int val, int min) {
			this(val, min, null);
		}

		private Node(int val, int min, Node next) {
			this.val = val;
			this.min = min;
			this.next = next;
		}
	}

	private static Node head;

	public static void push(int x) {
		if (head == null)
			head = new Node(x, x);
		else
			head = new Node(x, Math.min(x, head.min), head);
	}

	public static void pop() {
		head = head.next;
	}

	public static int top() {
		return head.val;
	}

	public static int getMin() {
		return head.min;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		push(-1);
		push(-3);
		System.out.println(top());
		int res = getMin();
		System.out.println(res);
		push(2);
		push(4);
		pop();
		top();
		int res1 = getMin();
		System.out.println(res1);

	}

}
