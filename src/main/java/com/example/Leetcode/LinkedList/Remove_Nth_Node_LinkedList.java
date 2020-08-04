
package com.example.Leetcode.LinkedList;

import org.springframework.boot.SpringApplication;

import com.example.Leetcode.LeetcodeApplication;
import com.example.Leetcode.LinkedList.Linkedlist_cycle.ListNode;

// Definition for singly-linked list.

public class Remove_Nth_Node_LinkedList {

	static ListNode head;

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}

	public static Remove_Nth_Node_LinkedList insert(Remove_Nth_Node_LinkedList list, int data) {
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

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		Remove_Nth_Node_LinkedList list = new Remove_Nth_Node_LinkedList();
		list = insert(list, 1);
		list = insert(list, 1);
		list = insert(list, 3);
		list = insert(list, 4);
		list = insert(list, 5);
		list = insert(list, 1);
		ListNode res = removeNthFromEnd(head, 2);
		System.out.println(res);

	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode start = new ListNode(0);
		ListNode slow = start, fast = start;
		slow.next = head;

		// Move fast in front so that the gap between slow and fast becomes n
		for (int i = 1; i <= n + 1; i++) {
			fast = fast.next;
		}
		// Move fast to the end, maintaining the gap
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		// Skip the desired node
		slow.next = slow.next.next;
		return start.next;
	}
}
