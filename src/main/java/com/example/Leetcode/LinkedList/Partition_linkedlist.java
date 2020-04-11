package com.example.Leetcode.LinkedList;

import com.example.Leetcode.LinkedList.LinkedList.ListNode;

public class Partition_linkedlist {

	ListNode head;

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}

	// Method to insert a new node
	public static Partition_linkedlist insert(Partition_linkedlist list, int data) {
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

	public static void printList(Partition_linkedlist list) {
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

	public static ListNode partition(ListNode head, int x) {
		ListNode smallerHead = new ListNode(0), biggerHead = new ListNode(0);
		ListNode smaller = smallerHead, bigger = biggerHead;
		while (head != null) {
			if (head.val < x) {
				smaller = smaller.next = head;
			} else {
				bigger = bigger.next = head;
			}
			head = head.next;
		}
		// no need for extra check because of fake heads
		smaller.next = biggerHead.next; // smaller will be at the end of the list, biggerHead will be at the beginning of bigger list
		bigger.next = null; // cut off anything after bigger
		return smallerHead.next; //smallerHead will the beginning of the smaller list
	}

	public static void main(String[] args) {
		/* Start with the empty list. */
		Partition_linkedlist list = new Partition_linkedlist();
		list = insert(list, 1);
		list = insert(list, 4);
		list = insert(list, 3);
		list = insert(list, 2);
		list = insert(list, 5);
		list = insert(list, 2);
		printList(list);
		ListNode head = list.head;
		partition(head, 3);
		printList(list);
	}

}
