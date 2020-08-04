package com.example.Leetcode.LinkedList;

import java.util.Stack;

public class Palindrome_linkedlist_stack {

	ListNode head;

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}

	public static Palindrome_linkedlist_stack insert(Palindrome_linkedlist_stack list, int data) {
		// Create a new node with given data
		ListNode new_node = new ListNode(data);
		new_node.next = null;

		// If the Linked List is empty,
		// then make the new node as head
		if (list.head == null) {
			list.head = new_node;
		} else {
			// Else traverse till the last node
			// and insert the new_node there
			ListNode last = list.head;
			while (last.next != null) {
				last = last.next;
			}

			// Insert the new_node at last node
			last.next = new_node;
		}

		// Return the list by head
		return list;
	}

	public static boolean isPalindrome(ListNode head) {
		ListNode temp = head;
		Stack stack = new Stack();
		while (temp != null) {
			stack.push(temp.val);
			temp = temp.next;
		}

		while (head != null) {
			if (head.val != (int) stack.pop()) {
				return false;
			}
			head = head.next;
		}
		return true;
	}

	public static void main(String[] args) {
		/* Start with the empty list. */
		Palindrome_linkedlist_stack list = new Palindrome_linkedlist_stack();
		list = insert(list, 1);
		list = insert(list, 3);
		list = insert(list, 2);
		list = insert(list, 3);
		list = insert(list, 1);
		ListNode head = list.head;
		boolean res = isPalindrome(head);
		System.out.println(res);
	}
}
