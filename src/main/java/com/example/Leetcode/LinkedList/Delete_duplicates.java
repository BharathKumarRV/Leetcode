package com.example.Leetcode.LinkedList;

import com.example.Leetcode.LinkedList.LinkedList.ListNode;

public class Delete_duplicates {

	ListNode head;

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}
	
	public static Delete_duplicates insert(Delete_duplicates list, int data) {
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

	public static ListNode deleteDuplicates(ListNode head) {
		ListNode curr = head;

		while (curr != null) {
			if (curr.next == null) {
				break;
			}
			if (curr.val == curr.next.val) {
				curr.next = curr.next.next;
			} else {
				curr = curr.next;
			}
		}

		return head;
	}
	
	public ListNode deleteDuplicates_method2(ListNode head) {
        if (head == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.next != null && head.val == head.next.val ? head.next : head;
    }
	
	
	

	public static void printList(Delete_duplicates list) {
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

	public static void main(String[] args) {
		/* Start with the empty list. */
		Delete_duplicates list = new Delete_duplicates();
		list = insert(list, 1);
		list = insert(list, 1);
		list = insert(list, 2);
		list = insert(list, 3);
		list = insert(list, 3);
		printList(list);
		ListNode head = list.head;
		ListNode res = deleteDuplicates(head);
		printList(list);
	}

}
