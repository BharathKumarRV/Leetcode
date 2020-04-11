package com.example.Leetcode.LinkedList;

public class Reverse_linkedlist {

	ListNode head;

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}

	// Method to insert a new node
	public static Reverse_linkedlist insert(Reverse_linkedlist list, int data) {
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
	
	public static void printList(Reverse_linkedlist list) {
		ListNode currNode = list.head;

		System.out.print("Reverse_linkedlist: ");

		// Traverse through the Reverse_linkedlist
		while (currNode != null) {
			// Print the data at current node
			System.out.print(currNode.val + " ");

			// Go to next node
			currNode = currNode.next;
		}
	}
	
	public static ListNode reverse(ListNode head) {
		ListNode prev=null;
		
		while(head!=null) {
			ListNode next_node=head.next;
		    head.next=prev;
		    prev=head;
		    head=next_node;
		}
		return prev;
	}
	
	public static void main(String[] args) {
		/* Start with the empty list. */
		Reverse_linkedlist list = new Reverse_linkedlist();

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

		// Print the Reverse_linkedlist
		printList(list);
		ListNode head=list.head;
		ListNode new_head=reverse(head);
		list.head=new_head;
		printList(list);
	}
	
	
}
