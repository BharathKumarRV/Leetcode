package com.example.Leetcode.LinkedList;

import com.example.Leetcode.LinkedList.LinkedList.ListNode;

public class Rotate_linkedlistBy_nth_node {

	ListNode head;

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}

	// Method to insert a new node
	public static Rotate_linkedlistBy_nth_node insert(Rotate_linkedlistBy_nth_node list, int data) {
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

	public static ListNode rotateRight(ListNode head, int k) {

		if (head == null) {
			return null;
		}
		// 1 2 3 4 5
		int n = 1;
		ListNode tail = head;
		while (tail.next != null) {
			++n;
			tail = tail.next;
		}
		k %= n;
		if (k == 0) {
			return head;
		}
		int stepsToNewHead = n - k;
		tail.next = head;
		// ListNode newTail=tail;
		while (stepsToNewHead-- > 0) {
			tail = tail.next;
			// tail=tail.next;
		}
		ListNode newHead = tail.next;
		tail.next = null;
		return newHead;
	}

	public static ListNode rotateRight_2(ListNode head, int k) {
		ListNode tail = head;
		ListNode pre = head;
		while (tail.next != null && tail.next.next != null) {
			pre = pre.next;
			tail = tail.next.next;
		}
		//1 2 3 4 5
		pre=pre.next;
		tail.next = head;
		for (int i = 0; i < k; i++) {
			head = tail;
			tail = pre;
			tail = tail.next;
			pre = pre.next;

		}
		pre.next = null;
		return head;
	}

	public static void printList(Rotate_linkedlistBy_nth_node list, ListNode newHead) {
		ListNode currNode = newHead;

		System.out.print("LinkedList: ");

		// Traverse through the LinkedList
		while (currNode != null) {
			// Print the data at current node
			System.out.print(currNode.val + " ");

			// Go to next node
			currNode = currNode.next;
		}
	}

	public static void main(String[] args) {
		/* Start with the empty list. */
		Rotate_linkedlistBy_nth_node list = new Rotate_linkedlistBy_nth_node();

		//
		// ******INSERTION******
		//

		// Insert the values
		list = insert(list, 1);
		list = insert(list, 2);
		list = insert(list, 3);
		list = insert(list, 4);
		list = insert(list, 5);

		// Print the LinkedList
		// printList(list);
		ListNode head = list.head;
		ListNode newhead = rotateRight_2(head, 2);
		printList(list, newhead);
	}
}
