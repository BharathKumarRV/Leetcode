package com.example.Leetcode.LinkedList;

import com.example.Leetcode.LinkedList.Reverse_LinkedList_2_1.ListNode;

public class Reverse_LinkedList_2_1 {

	ListNode head;

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}

	// Method to insert a new node
	public static Reverse_LinkedList_2_1 insert(Reverse_LinkedList_2_1 list, int data) {
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

	public static void printList(Reverse_LinkedList_2_1 list) {
		ListNode currNode = list.head;

		System.out.print("Reverse_LinkedList_2_1: ");

		// Traverse through the Reverse_LinkedList_2_1
		while (currNode != null) {
			// Print the data at current node
			System.out.print(currNode.val + " ");

			// Go to next node
			currNode = currNode.next;
		}
	}

	//https://www.youtube.com/watch?v=BE0hruM5O5U
		
	public static ListNode reverseBetween(ListNode head, int start, int end) {
		if (head == null)
			return null;
		ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
		dummy.next = head;

		ListNode nodeBeforeReversedSublist = dummy;
		int pos = 1;
		while (pos < start) {
			nodeBeforeReversedSublist = nodeBeforeReversedSublist.next;
			pos++;
		}

		ListNode sublistWorkingPtr = nodeBeforeReversedSublist.next;
		while (start < end) {
			// cut the new node out
			ListNode nodeComingToSublistFront = sublistWorkingPtr.next;
			sublistWorkingPtr.next = nodeComingToSublistFront.next;

			// pasting it at the front
			nodeComingToSublistFront.next = nodeBeforeReversedSublist.next;
			nodeBeforeReversedSublist.next = nodeComingToSublistFront;
			start++;
		}
		return dummy.next;

	}

	public static void main(String[] args) {
		/* Start with the empty list. */
		Reverse_LinkedList_2_1 list = new Reverse_LinkedList_2_1();

		//
		// ******INSERTION******
		//

		// Insert the values

		list = insert(list, 1);
		list = insert(list, 2);
		list = insert(list, 3);
		list = insert(list, 4);
		list = insert(list, 5);
		list = insert(list, 6);

		/*
		 * insert(list, 1); insert(list, 2); insert(list, 3); insert(list, 4);
		 * insert(list, 5); insert(list, 6); insert(list, 7); insert(list, 8);
		 */

		// Print the Reverse_LinkedList_2_1
		printList(list);
		ListNode new_head = reverseBetween(list.head, 3, 5);
		list.head = new_head;
		printList(list);
	}
}
