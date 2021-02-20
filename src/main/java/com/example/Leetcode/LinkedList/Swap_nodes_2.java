package com.example.Leetcode.LinkedList;

import com.example.Leetcode.LinkedList.Swap_nodes.ListNode;

public class Swap_nodes_2 {

	ListNode head;

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}

	// Method to insert a new node
	public static Swap_nodes_2 insert(Swap_nodes_2 list, int data) {
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

	public static void printList(Swap_nodes_2 list) {
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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null && head.next != null) {
            ListNode sec = head.next;
            head.next = sec.next;
            sec.next = head;
            pre.next = sec;
            pre = head;
            head = head.next;
        }
        return dummy.next;
    }

	public static void main(String[] args) {
		/* Start with the empty list. */
		Swap_nodes_2 list = new Swap_nodes_2();

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
