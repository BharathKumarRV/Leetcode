package com.example.Leetcode.LinkedList;

import com.example.Leetcode.LinkedList.Delete_duplicates.ListNode;

public class Remove_linked_list_elements {

	ListNode head;

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}

	public static Remove_linked_list_elements insert(Remove_linked_list_elements list, int data) {
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

	/*
	 * public static ListNode removeElements(ListNode head, int val) { while (head
	 * != null && head.val == val) head = head.next; ListNode curr = head; while
	 * (curr != null && curr.next != null) if (curr.next.val == val) curr.next =
	 * curr.next.next; else curr = curr.next; return head; }
	 */

	public static ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return null;
		head.next = removeElements(head.next, val);
		return head.val == val ? head.next : head;
	}

	public static void main(String[] args) {
		/* Start with the empty list. */
		Remove_linked_list_elements list = new Remove_linked_list_elements();
		list = insert(list, 1);
		list = insert(list, 1);
		list = insert(list, 3);
		list = insert(list, 4);
		list = insert(list, 5);
		list = insert(list, 1);
		// printList(list);
		ListNode head = list.head;
		ListNode res = removeElements(head, 1);
		// printList(list);
	}

}
