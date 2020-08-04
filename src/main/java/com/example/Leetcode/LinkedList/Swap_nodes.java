package com.example.Leetcode.LinkedList;

import com.example.Leetcode.LinkedList.LinkedList.ListNode;

public class Swap_nodes {

	ListNode head;

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}

	// Method to insert a new node
	public static Swap_nodes insert(Swap_nodes list, int data) {
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

	public static void printList(Swap_nodes list) {
		ListNode currNode = list.head;

		System.out.print("LinkedList: ");

		// Traverse through the LinkedList
		while (currNode != null) {
			// Print the data at current node
			System.out.print(currNode.val + " ");

			// Go to next node
			currNode = currNode.next;
		}
	}

	public static ListNode swapPairs(ListNode head) {
		if ((head == null) || (head.next == null))
			return head;
		ListNode n = head.next;
		head.next = swapPairs(head.next.next);
		n.next = head;
		return n;
	}

	public static ListNode swapPairs_2(ListNode head) {
		ListNode start = new ListNode(0);
		start.next = head;
		ListNode temp = start.next;

		/* Traverse only till there are atleast 2 nodes left */
		while (temp != null && temp.next != null) {

			/* Swap the data */
			int k = temp.val;
			temp.val = temp.next.val;
			temp.next.val = k;
			temp = temp.next.next;
		}
		return start.next;
	}

	public static void main(String[] args) {
		/* Start with the empty list. */
		Swap_nodes list = new Swap_nodes();

		//
		// ******INSERTION******
		//

		// Insert the values

		list = insert(list, 1);
		list = insert(list, 2);
		list = insert(list, 3);
		list = insert(list, 4);

		/*
		 * insert(list, 1); insert(list, 2); insert(list, 3); insert(list, 4);
		 * insert(list, 5); insert(list, 6); insert(list, 7); insert(list, 8);
		 */

		// Print the LinkedList
		printList(list);
		ListNode n = swapPairs(list.head);
		printList(list);
	}
}
