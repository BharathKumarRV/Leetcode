package com.example.Leetcode;

import org.springframework.boot.SpringApplication;

public class Stack_self {

	static private class Node {
		int val;
		int min;
		Node next;

		private Node(int val, int min, Node next) {
			this.val = val;
			this.min = min;
			this.next = next;
		}
	}

	private static Node head;

	public static void push(int x) {
		if (head == null)
			head = new Node(x, x, null);
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
}
