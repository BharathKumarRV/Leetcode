package com.example.Leetcode.LinkedList;

public class Insertion_sortlist {
	
	ListNode head;
	
	static class ListNode {
		ListNode prev, next;
		int value;

		ListNode(int _value) {
			value = _value;
		}
	}
	
	public static Insertion_sortlist insert(Insertion_sortlist list, int data) {
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

	public static ListNode insertionSortList(ListNode head) {
		 ListNode dummy = new ListNode(0);
	     ListNode prev = dummy;

	    while (head != null) {
	        ListNode temp = head.next;
	        
	        /* Before insert, the prev is at the last node of the sorted list.
	           Only the last node's value is larger than the current inserting node 
	           should we move the  back to the head*/
	        //whenever we find head less than prev pointer need scan elements from beginning
	        if (prev.value >= head.value) prev = dummy;

	        while (prev.next != null && head.value>prev.next.value) {
	            prev = prev.next;
	        }
	        
	        head.next = prev.next; // found an place for head 
	        prev.next = head; //prev.next shd have list of elements
	        // prev = dummy; // Don't set prev to the head of the list after insert
	        head = temp;
	    }
	    return dummy.next;
	}
	
	public static void main(String[] args) {
		/* Start with the empty list. */
		// LRU_cache list = new LRU_cache();
		Insertion_sortlist list=new Insertion_sortlist();
		list=insert(list,-1);
		list=insert(list,5);
		list=insert(list,3);
		list=insert(list,4);
		list=insert(list,0);
		ListNode res=insertionSortList(list.head);
		System.out.println(res);

	}
	
}
