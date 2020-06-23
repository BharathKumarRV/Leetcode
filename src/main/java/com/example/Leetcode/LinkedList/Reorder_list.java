package com.example.Leetcode.LinkedList;

import com.example.Leetcode.LinkedList.Linkedlist_cycle_2.ListNode;

public class Reorder_list {

	ListNode head;

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}

	public static Reorder_list insert(Reorder_list list, int data) {
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

	public static void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;

		// step 1. cut the list to two halves
		// prev will be the tail of 1st half
		// slow will be the head of 2nd half
		ListNode prev = null, slow = head, fast = head, l1 = head;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		prev.next = null;

		// step 2. reverse the 2nd half
		ListNode l2 = reverse(slow);

		// step 3. merge the two halves
		merge(l1, l2);
		System.out.println();
	}

	static ListNode reverse(ListNode head) {
		ListNode prev = null, curr = head, next = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}

	static void merge(ListNode l1, ListNode l2) {
		while (l1 != null) {
			ListNode n1 = l1.next, n2 = l2.next;
			l1.next = l2;

			if (n1 == null)
				break;

			l2.next = n1;
			l1 = n1;
			l2 = n2;
		}
	}

	/*
	 * private static void merge(ListNode head1, ListNode head2) { while (head2 !=
	 * null) { ListNode next = head1.next; // 1 2 3 - 6 5 4 // 1 6 2 5 3 4
	 * head1.next = head2; head1 = head2; head2 = next; } }
	 */

	public static void main(String[] args) {
		/* Start with the empty list. */
		Reorder_list list = new Reorder_list();

		list = insert(list, 1);
		list = insert(list, 2);
		list = insert(list, 3);
		list = insert(list, 4);
		list = insert(list, 5);
		list = insert(list, 6);

		reorderList(list.head);
	}
}
