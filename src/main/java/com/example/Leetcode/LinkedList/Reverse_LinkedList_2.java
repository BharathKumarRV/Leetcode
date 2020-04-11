package com.example.Leetcode.LinkedList;

import com.example.Leetcode.LinkedList.Reverse_linkedlist.ListNode;

public class Reverse_LinkedList_2 {

	ListNode head;

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}

	// Method to insert a new node
	public static Reverse_LinkedList_2 insert(Reverse_LinkedList_2 list, int data) {
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

	public static void printList(Reverse_LinkedList_2 list) {
		ListNode currNode = list.head;

		System.out.print("Reverse_LinkedList_2: ");

		// Traverse through the Reverse_LinkedList_2
		while (currNode != null) {
			// Print the data at current node
			System.out.print(currNode.val + " ");

			// Go to next node
			currNode = currNode.next;
		}
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null) {
			return null;
		}
		ListNode prev = null;
		ListNode current_node = head;

		while (m > 1) {
			prev = current_node;
			current_node = current_node.next;
			m--;
			n--;
		}

		ListNode connection = prev;
		ListNode tail = current_node;

		while (n > 0) {
			ListNode next_node = current_node.next;
			current_node.next = prev;
			prev = current_node;
			current_node = next_node;
			n--;
		}

		if (connection != null) {
			connection.next = prev;
		} else {
			head = prev;
		}

		tail.next = current_node;
		return head;

	}

	public static void main(String[] args) {
		/* Start with the empty list. */
		Reverse_LinkedList_2 list = new Reverse_LinkedList_2();

		//
		// ******INSERTION******
		//

		// Insert the values

		list = insert(list, 1);
		list = insert(list, 2);
		list = insert(list, 3);
		list = insert(list, 4);
		list = insert(list, 5);

		/*
		 * insert(list, 1); insert(list, 2); insert(list, 3); insert(list, 4);
		 * insert(list, 5); insert(list, 6); insert(list, 7); insert(list, 8);
		 */

		// Print the Reverse_LinkedList_2
		printList(list);
		ListNode new_head=reverseBetween(list.head, 2, 4);
		list.head=new_head;
		printList(list);
	}

}
