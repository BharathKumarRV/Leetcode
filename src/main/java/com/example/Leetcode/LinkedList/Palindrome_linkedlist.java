package com.example.Leetcode.LinkedList;

import com.example.Leetcode.LinkedList.Partition_linkedlist.ListNode;

public class Palindrome_linkedlist {

	ListNode head;

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

	}
	
	public static Palindrome_linkedlist insert(Palindrome_linkedlist list, int data) {
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
	
	public static boolean isPalindrome(ListNode head) {
	    ListNode fast = head, slow = head;
	    while (fast != null && fast.next != null) {
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	   
	    slow = reverse(slow);
	    fast = head;
	    
	    while (slow != null) {
	        if (fast.val != slow.val) {
	            return false;
	        }
	        fast = fast.next;
	        slow = slow.next;
	    }
	    return true;
	}

	public static ListNode reverse(ListNode head) {
	    ListNode prev = null;
	    while (head != null) {
	        ListNode next = head.next;
	        head.next = prev;
	        prev = head;
	        head = next;
	    }
	    return prev;
	}
	
	public static void main(String[] args) {
		/* Start with the empty list. */
		Palindrome_linkedlist list = new Palindrome_linkedlist();
		list = insert(list, 1);
		list = insert(list, 3);
		list = insert(list, 2);
		list = insert(list, 3);
		list = insert(list, 1);
		ListNode head = list.head;
		boolean res=isPalindrome(head);
		System.out.println(res);
	}
}
